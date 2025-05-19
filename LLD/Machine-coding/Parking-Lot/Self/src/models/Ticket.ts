import { FairPricingMap, VehicleType } from "../../helper/enums";
import { FairDetails } from "../../helper/types";

export class Ticket {
  vehicleType: VehicleType;
  fairDetails: FairDetails;
  startTime: Date;

  constructor(vehicleType: VehicleType) {
    this.vehicleType = vehicleType;
    this.fairDetails = FairPricingMap[vehicleType];
    this.startTime = new Date();
  }

  public calculateFair(vehicleNumber: string) {
    const startTime = this.startTime;
    const endTime = new Date();
    const diffInMilliseconds = endTime.getTime() - startTime.getTime();
    const seconds = Math.floor(diffInMilliseconds / 1000) % 60;
    const minutes = Math.floor(diffInMilliseconds / (1000 * 60)) % 60;
    const hours = Math.floor(diffInMilliseconds / (1000 * 60 * 60)) % 24;

    let amount = 0;
    if (seconds) {
      amount = amount + seconds * this.fairDetails.oneSec;
    }

    if (minutes) {
      amount = amount + seconds * this.fairDetails.oneMin;
    }

    if (hours) {
      amount = amount + seconds * this.fairDetails.oneHr;
    }

    console.log(
      `🤑 The parking charges for vehicle number: ${vehicleNumber} is ${amount} cent(s)`
    );
    return amount;
  }
}