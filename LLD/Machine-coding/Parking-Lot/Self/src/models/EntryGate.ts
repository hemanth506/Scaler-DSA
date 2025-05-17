import { OccupiedState } from "../../helper/enums";
import { Level } from "./Level";
import { ParkingSpot } from "./ParkingSpot";
import { Ticket } from "./Ticket";
import { Transport } from "./Transport";

export class EntryGate {
  parkedVehicle: Map<string, [number, number]>
  waitingQueue: Transport[][];

  constructor() {
    this.parkedVehicle = new Map()
    this.waitingQueue = [];
  }

  public provideTicket(vehicle: Transport, level: Level[]): Ticket | null {
    const vehicleType = vehicle.type;
    const vehicleTypeId = vehicle.typeId;
    for (let i = 0; i < level.length; i++) {
      const currentLevel = level[i];
      if (currentLevel.totalSpotsAvailablePerVehicleType[vehicleTypeId] > 0) {
        for (let j = 0; j < (currentLevel.allotments as ParkingSpot[]).length; j++) {
          const currentAllotment = (currentLevel.allotments as ParkingSpot[])[j];
          if (
            currentAllotment.isOccupied === OccupiedState.AVAILABLE &&
            currentAllotment.spotType === vehicleType
          ) {
            currentAllotment.setIsOccupiedStatus(OccupiedState.OCCUPIED);
            currentAllotment.setVehicle(vehicle);
            currentAllotment.setOccupiedStartDateTime()
            currentLevel.decreaseTotalSpotsAvailablePerVehicleType(
              vehicleTypeId
            );
            const tempLevelId = currentAllotment.levelId.split('-')[1];
            const tempSpotId = currentAllotment.spotId.split('-')[1];
            this.parkedVehicle.set(vehicle.number, [parseInt(tempLevelId), parseInt(tempSpotId)])
            const ticket = new Ticket(vehicleType);
            vehicle.setTicket(ticket)
            console.log("📥 Ticket issued to vehicle:", vehicle.number);
            return ticket
          }
        }
      }
    }
    console.log('😢 Sorry 🙏🏼, As of now there are no empty spot for your vehicle to park, requesting to wait in the queue,')
    this.waitingQueue[vehicleTypeId].push(vehicle)
    return null;
  }

  public provideTicketForPoppedVehicle(poppedVehicle: Transport, parkingSpot: ParkingSpot): Ticket {
    parkingSpot.vehicle = null
    parkingSpot.vehicle = poppedVehicle
    const ticket = new Ticket(poppedVehicle.type);
    poppedVehicle.setTicket(ticket);
    console.log("📥 Ticket issued to popped vehicle from queue:", poppedVehicle.number);
    return ticket
  }

  public setDefaultWaitingQueue(vehicleTypeLength: number): void {
    let tempWaitingQueue = [];
    for (let i = 0; i < vehicleTypeLength; i++) {
      tempWaitingQueue.push([]);
    }
    this.waitingQueue = tempWaitingQueue;
  }
}
