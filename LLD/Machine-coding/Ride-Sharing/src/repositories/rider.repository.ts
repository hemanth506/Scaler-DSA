import { Rider } from "../models/Rider"

export class RiderRepository {
    riders: Map<string, Rider>
    constructor() {
        this.riders = new Map()
    }

    getRiders() {
        return this.riders
    }

    setRiders(riders: Map<string, Rider>) {
        this.riders = riders
    }
}