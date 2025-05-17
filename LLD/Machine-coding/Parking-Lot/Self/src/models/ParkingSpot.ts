import { OccupiedState, VehicleType } from "../../helper/enums";
import { Transport } from "./Transport";

export class ParkingSpot {
  spotType: VehicleType;
  spotId: string;
  levelId: string;
  isOccupied: OccupiedState;
  vehicle: Transport | null;
  occupiedStartDateTime: Date | null;

  constructor(spotType: VehicleType, spotId: number, levelId: string) {
    this.spotType = spotType;
    this.spotId = `Spot-${spotId}`;
    this.levelId = levelId;
    this.isOccupied = OccupiedState.AVAILABLE;
    this.vehicle = null;
    this.occupiedStartDateTime = null
  }

  setIsOccupiedStatus(status: OccupiedState) {
    this.isOccupied = status
  }

  setVehicle(vehicle: Transport | null) {
    this.vehicle = vehicle
  }

  setOccupiedStartDateTime() {
    this.occupiedStartDateTime = new Date()
  }
}


export class ParkingSpotFactory {
  public static getParkingSpot(
    vehicle: VehicleType,
    spotId: number,
    levelId: string
  ) {
    switch (vehicle) {
      case VehicleType.BIKE:
        return new ParkingSpot(VehicleType.BIKE, spotId, levelId);
      case VehicleType.CAR:
        return new ParkingSpot(VehicleType.CAR, spotId, levelId);
      default:
      case VehicleType.TRUCK:
        return new ParkingSpot(VehicleType.TRUCK, spotId, levelId);
    }
  }
}