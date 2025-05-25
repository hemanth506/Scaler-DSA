import { GlobalClass } from "./GlobalClass";

export class Seat extends GlobalClass {
    _number: number
    _seatType: string
    _row: number
    _column: number

    constructor(id:string, number: number, seatType: string, row: number, column: number) {
        super(id)
        this._number = number
        this._seatType = seatType
        this._row = row
        this._column = column
    }
}

