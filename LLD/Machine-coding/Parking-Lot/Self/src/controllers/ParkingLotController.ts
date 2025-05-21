import { ResponseType } from "../../helper/enums";
import { DEFAULT_ENTRY_GATE, Gate } from "../models/Gate";
import { ParkingLot } from "../models/ParkingLot";
import { Ticket } from "../models/Ticket";
import { Transport } from "../models/Transport";
import { TicketController } from "./TicketController";

export class ParkingLotController {
  ticketController = new TicketController();
  ticket = new Ticket();

  public initParkingLot(
    noOfLevels: number,
    totalSpotsAllotedPerVehicleType: number[][]
  ): ParkingLot {
    return ParkingLot.getBuilder()
      .setNoOfLevels(noOfLevels)
      .setTotalSpotsAllotedPerVehicleType(totalSpotsAllotedPerVehicleType)
      .build();
  }

  public incomingVehicle(vehicle: Transport, parkingLot: ParkingLot, gate: Gate) {
    const response: ResponseType = parkingLot.handleIncomingVehicle(vehicle, gate);
    if (response === ResponseType.SLOT_ALLOTED) {
      this.ticketController.issueTicket(this.ticket, vehicle, gate)
    }
  }

  public displayDashboard(parkingLot: ParkingLot) {
    parkingLot.displayDashboard();
  }

  public exitingVehicle(parkingLot: ParkingLot, vehicleNumber: string) {
    const response = parkingLot.handleExitingVehicle(vehicleNumber)
    if (response) {
      const { status, poppedVehicle } = response
      if (status === ResponseType.SLOT_ALLOTED_FOR_QUEUED_VEHICLE && poppedVehicle) {
        this.ticketController.issueTicket(this.ticket, poppedVehicle, DEFAULT_ENTRY_GATE)
      }
    }
  }
}
