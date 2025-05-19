import {
  FairPricingMap,
  OccupiedState,
  VehicleIndexMap,
  VehicleType,
} from "../../helper/enums";
import { Level } from "./Level";
import { ParkingSpot } from "./ParkingSpot";
import { Ticket } from "./Ticket";
import { Transport } from "./Transport";

export class ParkingLot {
  noOfLevels: number;
  levels: Level[];
  parkedVehicle: Map<string, [number, number]>;
  waitingQueue: Transport[][];
  totalAmountCollected: number;

  constructor(noOfLevels: number, totalSpotsAllotedPerVehicleType: number[][]) {
    this.noOfLevels = noOfLevels;
    this.levels = this.setInitialLevels(totalSpotsAllotedPerVehicleType);
    this.parkedVehicle = new Map();
    this.waitingQueue = this.setDefaultWaitingQueue();
    this.totalAmountCollected = 0;
  }

  private setDefaultWaitingQueue(): Transport[][] {
    let tempWaitingQueue = [];
    for (let i = 0; i < Object.keys(VehicleType).length; i++) {
      tempWaitingQueue.push([]);
    }
    return tempWaitingQueue;
  }

  private setInitialLevels(
    totalSpotsAllotedPerVehicleType: number[][]
  ): Level[] {
    let tempLevel: Level[] = [];
    for (let i = 0; i < this.noOfLevels; i++) {
      tempLevel.push(new Level(i, totalSpotsAllotedPerVehicleType[i]));
    }
    return tempLevel;
  }

  public handleIncomingVehicle(vehicle: Transport) {
    const availability = this.checkForAvailability(vehicle);
    if (availability) {
      const [i, j]: [number, number] = availability;
      const currentAllotment = (this.levels[i].allotments as ParkingSpot[])[j];
      const tempLevelId = currentAllotment.levelId.split("-")[1];
      const tempSpotId = currentAllotment.spotId.split("-")[1];
      currentAllotment.setIsOccupiedStatus(OccupiedState.OCCUPIED);
      currentAllotment.setVehicle(vehicle);
      this.levels[i].decreaseTotalSpotsAvailablePerVehicleType(vehicle.typeId);
      this.parkedVehicle.set(vehicle.number, [
        parseInt(tempLevelId),
        parseInt(tempSpotId),
      ]);
      this.provideTicket(vehicle);
    } else {
      console.log(
        "😢 Sorry 🙏🏼, As of now there are no empty spot for your vehicle to park, requesting to wait in the queue,"
      );
      this.waitingQueue[vehicle.typeId].push(vehicle);
    }
  }

  private provideTicket(vehicle: Transport) {
    const ticket = new Ticket(vehicle.type);
    vehicle.setTicket(ticket);
    console.log("📥 Ticket issued to vehicle:", vehicle.number);
  }

  private checkForAvailability(vehicle: Transport): [number, number] | null {
    const vehicleType = vehicle.type;
    const vehicleTypeId = vehicle.typeId;
    for (let i = 0; i < this.levels.length; i++) {
      const currentLevel = this.levels[i];
      if (currentLevel.totalSpotsAvailablePerVehicleType[vehicleTypeId] > 0) {
        for (
          let j = 0;
          j < (currentLevel.allotments as ParkingSpot[]).length;
          j++
        ) {
          const currentAllotment = (currentLevel.allotments as ParkingSpot[])[
            j
          ];
          if (
            currentAllotment.isOccupied === OccupiedState.AVAILABLE &&
            currentAllotment.spotType === vehicleType
          ) {
            return [i, j];
          }
        }
      }
    }
    return null;
  }

  public displayDashboard() {
    console.log("🚀 ~ this ~", JSON.stringify(this, null, 2));
    console.log("🅿️ Parked vehicle: ", [...this.parkedVehicle.entries()]);
  }

  public handleExitingVehicle(vehicleNumber: string) {
    const location = this.parkedVehicle.get(vehicleNumber);
    if (!location) {
      console.log(`❌ ~ Vehicle number ${vehicleNumber} not exist!`);
      return;
    }
    const [levelId, spotId] = location;
    const parkingSpot = (this.levels[levelId].allotments as ParkingSpot[])[
      spotId
    ];
    if (parkingSpot.vehicle?.ticket) {
      const fairAmount =
        parkingSpot.vehicle.ticket.calculateFair(vehicleNumber);
      this.totalAmountCollected = this.totalAmountCollected + fairAmount;
      this.removeVehicleOrAllocateQueuedVehicle(
        parkingSpot,
        location,
        vehicleNumber
      );
    }
  }

  private removeVehicleOrAllocateQueuedVehicle(
    parkingSpot: ParkingSpot,
    location: [number, number],
    previousVehicleNumber: string
  ) {
    const [levelId, spotId] = location;
    const spotTypeId = parkingSpot.vehicle?.typeId;
    if (spotTypeId !== undefined) {
      if (this.waitingQueue[spotTypeId].length === 0) {
        console.log(`🙅‍♂️ Great, No vehicles in the queue`);
        this.levels[levelId].increaseTotalSpotsAvailablePerVehicleType(spotId);
        parkingSpot.setIsOccupiedStatus(OccupiedState.AVAILABLE);
        parkingSpot.setVehicle(null);
      } else {
        const poppedVehicle = this.waitingQueue[spotTypeId].shift();
        console.log('🚀 ~ ParkingLot.ts:147 ~ ParkingLot ~ poppedVehicle:', poppedVehicle)
        if (poppedVehicle) {
          parkingSpot.setVehicle(null);
          parkingSpot.vehicle = poppedVehicle;
          this.provideTicket(poppedVehicle);
          this.parkedVehicle.set(poppedVehicle.number, [levelId, spotId]);
        }
      }
      this.parkedVehicle.delete(previousVehicleNumber);
      // console.log("this.waitingQueue", this.waitingQueue);
      // console.log("parkingSpot", parkingSpot);
    }
  }

  public static getBuilder() {
    return new ParkingLotBuilder();
  }
}

export class ParkingLotBuilder {
  private noOfLevels!: number;
  private totalSpotsAllotedPerVehicleType!: number[][];
  private vehicleTypeLength = Object.keys(VehicleType).length;

  public setNoOfLevels(noOfLevels: number): ParkingLotBuilder {
    this.noOfLevels = noOfLevels;
    return this;
  }

  public setTotalSpotsAllotedPerVehicleType(
    totalSpotsAllotedPerVehicleType: number[][]
  ): ParkingLotBuilder {
    this.totalSpotsAllotedPerVehicleType = totalSpotsAllotedPerVehicleType;
    return this;
  }

  private validateVehiclesCount() {
    for (let i = 0; i < this.totalSpotsAllotedPerVehicleType.length; i++) {
      if (
        this.vehicleTypeLength !==
        this.totalSpotsAllotedPerVehicleType[i].length
      ) {
        return new Error("Transport count not matching based on vehicle type!");
      }
    }

    if (this.vehicleTypeLength !== Object.keys(FairPricingMap).length) {
      return new Error(
        "Transport count not matching based on vehicle fair pricing map!"
      );
    }

    if (this.vehicleTypeLength !== Object.keys(VehicleIndexMap).length) {
      return new Error(
        "Transport count not matching based on vehicle index map!"
      );
    }
  }

  private validateLevelCount() {
    if (this.noOfLevels !== this.totalSpotsAllotedPerVehicleType.length) {
      return new Error("Level count not matching!");
    }
  }

  public build(): ParkingLot {
    this.validateVehiclesCount();
    this.validateLevelCount();
    return new ParkingLot(
      this.noOfLevels,
      this.totalSpotsAllotedPerVehicleType
    );
  }
}
