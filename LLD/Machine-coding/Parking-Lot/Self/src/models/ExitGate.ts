import { OccupiedState } from "../../helper/enums";
import { EntryGate } from "./EntryGate";
import { Level } from "./Level";
import { ParkingSpot } from "./ParkingSpot";
import { Ticket } from "./Ticket";
import { Transport } from "./Transport";

export class ExitGate {
  totalAmountCollected: number;

  constructor() {
    this.totalAmountCollected = 0;
  }

  removeVehicleOrAllocateQueuedVehicle(
    queuedVehicle: Transport[][],
    parkingSpot: ParkingSpot,
    entryGate: EntryGate,
    location: [number, number],
    previousVehicleNumber: string,
    levelArray: Level[]
  ) {
    console.log("queuedVehicle", queuedVehicle);
    console.log("parkingSpot", parkingSpot);
    const [levelId, spotId] = location;
    const spotTypeId = parkingSpot.vehicle?.typeId;
    if (spotTypeId) {
      console.log('queuedVehicle[spotTypeId]', queuedVehicle[spotTypeId])
      if (queuedVehicle[spotTypeId].length === 0) {
        console.log(`🙅‍♂️ Great, No vehicles in the queue`);
        entryGate.parkedVehicle.delete(previousVehicleNumber)
        levelArray[levelId].increaseTotalSpotsAvailablePerVehicleType(spotId)
        parkingSpot.setIsOccupiedStatus(OccupiedState.AVAILABLE)
        parkingSpot.setVehicle(null)
      } else {
        const poppedVehicle = queuedVehicle[spotTypeId].shift();
        if (poppedVehicle) {
          entryGate.provideTicketForPoppedVehicle(poppedVehicle, parkingSpot);
          entryGate.parkedVehicle.set(poppedVehicle.number, [levelId, spotId])
        }
      }
    }
  }

  calculateFair(vehicleNumber: string, ticket: Ticket) {
    const startTime = ticket.startTime;
    const endTime = new Date();
    const diffInMilliseconds = endTime.getTime() - startTime.getTime();
    const seconds = Math.floor(diffInMilliseconds / 1000) % 60;
    const minutes = Math.floor(diffInMilliseconds / (1000 * 60)) % 60;
    const hours = Math.floor(diffInMilliseconds / (1000 * 60 * 60)) % 24;

    let amount = 0;
    if (seconds) {
      amount = amount + seconds * ticket.fairDetails.oneSec;
    }

    if (minutes) {
      amount = amount + seconds * ticket.fairDetails.oneMin;
    }

    if (hours) {
      amount = amount + seconds * ticket.fairDetails.oneHr;
    }
    this.setTotalAmountCollected(this.getTotalAmountCollected() + amount);

    console.log(`🤑 The parking charges for vehicle number: ${vehicleNumber} is ${amount} cent(s)`);
  }

  getTotalAmountCollected() {
    return this.totalAmountCollected;
  }

  setTotalAmountCollected(totalAmount: number) {
    this.totalAmountCollected = totalAmount;
  }
}
