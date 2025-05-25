import { Feature } from "../../helper/enums";
import { BaseClass } from "./GlobalClass";
import { Seat } from "./Seat";

export class Screen  extends BaseClass {
    _seats: Seat[]
    _features: Feature[]

    constructor(id: string, name: string, seats: Seat[], features: Feature[]) {
        super(id, name)
        this._features = features
        this._seats = seats
    }
}