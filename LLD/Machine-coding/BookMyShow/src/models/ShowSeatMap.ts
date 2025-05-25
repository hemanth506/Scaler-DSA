import { SeatStatus } from "../../helper/enums";
import { GlobalClass } from "./GlobalClass";
import { Seat } from "./Seat";
import { Show } from "./Show";

export class ShowSeatMap extends GlobalClass {
    _show: Show
    _seat: Seat
    _status: SeatStatus
    _lockedAt: Date

    constructor(id: string, show: Show, seat: Seat, status: SeatStatus, lockedAt: Date) {
        super(id)
        this._seat = seat
        this._show = show
        this._status = status
        this._lockedAt = lockedAt
    }
}