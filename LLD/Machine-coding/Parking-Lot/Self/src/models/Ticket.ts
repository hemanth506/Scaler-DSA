import { FairPricingMap, VehicleType } from "../../helper/enums";
import { FairDetails } from "../../helper/types";
import { ParkingSpot } from "./ParkingSpot";

export class Ticket {
  vehicleType: VehicleType;
  fairDetails: FairDetails;
  startTime: Date;

  constructor(vehicleType: VehicleType) {
    this.vehicleType = vehicleType;
    this.fairDetails = FairPricingMap[vehicleType];
    this.startTime = new Date();
  }
}