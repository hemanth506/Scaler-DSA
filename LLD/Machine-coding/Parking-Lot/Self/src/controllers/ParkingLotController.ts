import { ParkingLot } from "../models/ParkingLot";
import { Transport } from "../models/Transport";

export class ParkingLotController {
  public initParkingLot(
    noOfLevels: number,
    totalSpotsAllotedPerVehicleType: number[][]
  ): ParkingLot {
    return ParkingLot.getBuilder()
      .setNoOfLevels(noOfLevels)
      .setTotalSpotsAllotedPerVehicleType(totalSpotsAllotedPerVehicleType)
      .build();
  }

  public incomingVehicle(vehicle: Transport, parkingLot: ParkingLot) {
    parkingLot.handleIncomingVehicle(vehicle);
  }

  public displayDashboard(parkingLot: ParkingLot) {
    parkingLot.displayDashboard();
  }

  public exitingVehicle(parkingLot: ParkingLot, vehicleNumber: string) {
    parkingLot.handleExitingVehicle(vehicleNumber)
  }
}
