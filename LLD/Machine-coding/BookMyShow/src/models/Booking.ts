import { BookingStatus } from "../../helper/enums";
import { GlobalClass } from "./GlobalClass";
import { Payment } from "./Payment";
import { ShowSeatMap } from "./ShowSeatMap";

export class Booking extends GlobalClass {
    _status: BookingStatus
    _showSeat: ShowSeatMap[]
    _amount: number
    _payments: Payment[]

    constructor(id: string, status: BookingStatus, showSeat: ShowSeatMap[], amount: number, payments: Payment[]) {
        super(id)
        this._status = status
        this._showSeat = showSeat
        this._amount = amount
        this._payments = payments
    }
}