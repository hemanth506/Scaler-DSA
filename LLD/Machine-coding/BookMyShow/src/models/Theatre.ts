import { BaseClass } from "./GlobalClass";
import { Screen } from "./Screen";

export class Theatre extends BaseClass{
    _screens: Screen[]
    constructor(id: string, name: string, screens: Screen[]) {
        super(id, name)
        this._screens = screens
    }

    public setScreens(screens: Screen[]) {
        this._screens = screens
    }

    public getScreens() {
        return this._screens
    }
}