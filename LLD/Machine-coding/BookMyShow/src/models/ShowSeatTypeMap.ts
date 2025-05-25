import { GlobalClass } from "./GlobalClass";
import { Show } from "./Show";

export class ShowSeatTypeMap extends GlobalClass {
    _show: Show
    _seatType: string
    _price: number

    constructor(id: string, show: Show, seatType: string, price: number) {
        super(id)
        this._seatType = seatType
        this._show = show
        this._price = price
    }
}