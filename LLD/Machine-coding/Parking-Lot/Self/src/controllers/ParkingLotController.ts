import { ResponseType } from "../../helper/enums";
import { Gate } from "../models/Gate";
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

  public incomingVehicle(vehicle: Transport, parkingLot: ParkingLot, gate: Gate): ResponseType {
    return parkingLot.handleIncomingVehicle(vehicle, gate);
  }

  public displayDashboard(parkingLot: ParkingLot) {
    parkingLot.displayDashboard();
  }

  public exitingVehicle(parkingLot: ParkingLot, vehicleNumber: string): {
    status: ResponseType;
    poppedVehicle: Transport;
} | null {
    return parkingLot.handleExitingVehicle(vehicleNumber)
  }
}
