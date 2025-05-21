import { vehicleIndexMap, VehicleType } from "../../helper/enums";
import { ParkingSpot, ParkingSpotFactory } from "./ParkingSpot";

export class Level {
  levelId: string;
  totalSpotsAllotedPerVehicleType: number[]; // This will be as array based on [bike, car, truck]
  totalSpotsAvailablePerVehicleType: number[]; // This will be as array based on [bike, car, truck]
  allotments!: ParkingSpot[] | {};

  constructor(levelId: number, totalSpotsAllotedPerVehicleType: number[]) {
    this.levelId = `Level-${levelId}`;
    this.totalSpotsAllotedPerVehicleType = [...totalSpotsAllotedPerVehicleType];
    this.totalSpotsAvailablePerVehicleType = [
      ...totalSpotsAllotedPerVehicleType,
    ];
    this.setAllotments();
  }

  public decreaseTotalSpotsAvailablePerVehicleType(index: number) {
    this.totalSpotsAvailablePerVehicleType[index] =
      this.totalSpotsAvailablePerVehicleType[index] - 1;
  }

  public increaseTotalSpotsAvailablePerVehicleType(index: number) {
    this.totalSpotsAvailablePerVehicleType[index] =
      this.totalSpotsAvailablePerVehicleType[index] + 1;
  }

  public getVehicleTypeByIndex(index: number): VehicleType {
    return Object.entries(vehicleIndexMap).find(
      ([_, val]) => val === index
    )?.[0] as VehicleType;
  }

  public setAllotments() {
    let tempParkingSpot = [];
    let spotId = 0;
    for (let i = 0; i < this.totalSpotsAllotedPerVehicleType.length; i++) {
      if (this.totalSpotsAllotedPerVehicleType[i] === 0) {
        tempParkingSpot.push({})
        spotId++;
      } else {
        for (let j = 0; j < this.totalSpotsAllotedPerVehicleType[i]; j++) {
          const vehicleType: VehicleType = this.getVehicleTypeByIndex(i);
          tempParkingSpot.push(
            ParkingSpotFactory.getParkingSpot(vehicleType, spotId, this.levelId)
          );
          spotId++;
        }
      }

    }
    this.allotments = tempParkingSpot;
  }
}
