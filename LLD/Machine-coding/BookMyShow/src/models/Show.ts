import { GlobalClass } from "./GlobalClass";
import { Movie } from "./Movie";
import { Screen } from "./Screen";

export class Show extends GlobalClass {
    _startTime: Date
    _endTime: Date
    _movie: Movie
    _screen: Screen

    constructor(id: string, startTime: Date, endTime: Date, movie: Movie, screen: Screen) {
        super(id)
        this._endTime = endTime
        this._startTime = startTime
        this._movie = movie
        this._screen = screen
    }
}