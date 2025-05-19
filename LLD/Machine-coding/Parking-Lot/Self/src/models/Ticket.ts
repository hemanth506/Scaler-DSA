import { FairPricingMap, VehicleType } from "../../helper/enums";
import { FairDetails } from "../../helper/types";
import { Gate } from "./Gate";
import { v4 as uuidv4 } from "uuid"

export class Ticket {
  id: string
  vehicleType: VehicleType;
  startTime: Date;
  gate: Gate;

  constructor(vehicleType: VehicleType, gate: Gate) {
    this.id = uuidv4()
    this.vehicleType = vehicleType;
    this.startTime = new Date();
    this.gate = gate
  }

  public calculateFair(vehicleNumber: string, vehicleType: VehicleType) {
    const fairDetails: FairDetails = FairPricingMap[vehicleType]
    const startTime = this.startTime;
    const endTime = new Date();
    const diffInMilliseconds = endTime.getTime() - startTime.getTime();
    const seconds = Math.floor(diffInMilliseconds / 1000) % 60;
    const minutes = Math.floor(diffInMilliseconds / (1000 * 60)) % 60;
    const hours = Math.floor(diffInMilliseconds / (1000 * 60 * 60)) % 24;

    let amount = 0;
    if (seconds) {
      amount = amount + seconds * fairDetails.oneSec;
    }

    if (minutes) {
      amount = amount + seconds * fairDetails.oneMin;
    }

    if (hours) {
      amount = amount + seconds * fairDetails.oneHr;
    }

    console.log(
      `🤑 The parking charges for vehicle number: ${vehicleNumber} is ${amount} cent(s)`
    );
    return amount;
  }
}