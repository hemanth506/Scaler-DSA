import { Booking } from "./Booking";
import { GlobalClass } from "./GlobalClass";

export class User extends GlobalClass{
    _name: string
    _phNumber: string
    _bookings: Booking[]

    constructor(id: string, name:string, phnNumber: string, bookings: Booking[]) {
      super(id);
      this._name = name
      this._bookings = bookings
      this._phNumber = phnNumber
    }
}