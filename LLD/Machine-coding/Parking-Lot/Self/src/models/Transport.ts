import { VehicleType } from "../../helper/enums";
import { Ticket } from "./Ticket";

export class Transport {
  type: VehicleType;
  typeId: number;
  number: string;
  ticket: Ticket | null;
  constructor(
    type: VehicleType,
    number: string,
    typeId: number
  ) {
    this.type = type;
    this.number = number;
    this.typeId = typeId;
    this.ticket = null
  }

  setTicket(ticket: Ticket) {
    this.ticket = ticket;
  }

  getTicket() {
    return this.ticket;
  }
}
