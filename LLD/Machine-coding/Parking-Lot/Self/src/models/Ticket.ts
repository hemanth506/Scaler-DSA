import { fairPricingMap, VehicleType } from "../../helper/enums";
import { fairDetails } from "../../helper/types";
import { Gate } from "./Gate";
import { v4 as uuidv4 } from "uuid"
import { Transport } from "./Transport";

export class Ticket {
  id?: string
  vehicleType?: VehicleType;
  startTime?: Date;
  gate?: Gate;

  public calculateFair(vehicleNumber: string, vehicleType: VehicleType) {
    const fairDetails: fairDetails = fairPricingMap[vehicleType]
    const startTime = this?.startTime;
    const endTime = new Date();
    if(startTime) {
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

  private buildTicket(vehicleType: VehicleType, gate: Gate) {
    const ticket = new Ticket();
    ticket.id = uuidv4()
    ticket.startTime = new Date(); 
    ticket.gate = gate
    ticket.vehicleType = vehicleType;
    return ticket;
  }

  public provideEntryTicket(vehicle: Transport, gate: Gate) {
    const ticket = this.buildTicket(vehicle.type, gate)
    vehicle.setTicket(ticket);
    console.log("📥 Ticket issued to vehicle:", vehicle.number);
  }
}