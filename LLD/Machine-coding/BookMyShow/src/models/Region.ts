import { BaseClass } from "./GlobalClass"
import { Theatre } from "./Theatre"

export class Region extends BaseClass{
    _theatres: Theatre[]

    constructor(id: string, name: string, theatres: Theatre[]) {
        super(id, name)
        this._theatres = theatres
    }

    public setTheatres(theatres: Theatre[]) {
        this._theatres = theatres
    }

    public getTheatres() {
        return this._theatres
    }
}