import { Gate } from "../models/Gate";
import { Ticket } from "../models/Ticket";
import { Transport } from "../models/Transport";

export class TicketController {
    public issueTicket(ticket: Ticket, vehicle: Transport, gate: Gate) {
        ticket.provideEntryTicket(vehicle, gate)
    }
}