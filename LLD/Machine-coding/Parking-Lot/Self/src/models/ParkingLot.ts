import {
  FairPricingMap,
  VehicleIndexMap,
  VehicleType,
} from "../../helper/enums";
import { EntryGate } from "./EntryGate";
import { ExitGate } from "./ExitGate";
import { Level } from "./Level";
import { ParkingSpot } from "./ParkingSpot";
import { Transport } from "./Transport";

export class ParkingLot {
  noOfLevels: number;
  levels: Level[];
  entryGate: EntryGate;
  exitGate: ExitGate;

  constructor(
    noOfLevels: number,
    totalSpotsAllotedPerVehicleType: number[][],
    entryGate: EntryGate
  ) {
    this.noOfLevels = noOfLevels;
    this.entryGate = entryGate;
    this.exitGate = new ExitGate();
    this.levels = this.assignLevels(totalSpotsAllotedPerVehicleType);
  }

  private assignLevels(totalSpotsAllotedPerVehicleType: number[][]): Level[] {
    let tempLevel: Level[] = [];
    for (let i = 0; i < this.noOfLevels; i++) {
      tempLevel.push(new Level(i, totalSpotsAllotedPerVehicleType[i]));
    }
    return tempLevel;
  }

  public handleIncomingVehicle(vehicle: Transport) {
    this.entryGate.provideTicket(vehicle, this.levels);
  }

  public displayDashboard() {
    console.log("🚀 ~ this ~", JSON.stringify(this, null, 2));
    console.log("🅿️ Parked vehicle: ", [
      ...this.entryGate.parkedVehicle.entries(),
    ]);
  }

  public handleExitingVehicle(vehicleNumber: string) {
    const location = this.entryGate.parkedVehicle.get(vehicleNumber);
    if (!location) {
      console.log(`❌ ~ Vehicle number ${vehicleNumber} not exist!`);
      return;
    }
    const [levelId, spotId] = location;
    const parkingSpot = (this.levels[levelId].allotments as ParkingSpot[])[spotId];
    if (parkingSpot.vehicle?.ticket) {
      this.exitGate.calculateFair(vehicleNumber, parkingSpot.vehicle.ticket);
      this.exitGate.removeVehicleOrAllocateQueuedVehicle(this.entryGate.waitingQueue, parkingSpot, this.entryGate, location, vehicleNumber, this.levels)
    }
  }

  public static getBuilder() {
    return new ParkingLotBuilder();
  }
}

export class ParkingLotBuilder {
  private noOfLevels!: number;
  private totalSpotsAllotedPerVehicleType!: number[][];
  private vehicleTypeLength: number = Object.keys(VehicleType).length;
  private entryGate!: EntryGate;

  public setNoOfLevels(noOfLevels: number): ParkingLotBuilder {
    this.noOfLevels = noOfLevels;
    return this;
  }

  public setEntryGate() {
    this.entryGate = new EntryGate();
    this.entryGate.setDefaultWaitingQueue(this.vehicleTypeLength);
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
      this.totalSpotsAllotedPerVehicleType,
      this.entryGate
    );
  }
}
