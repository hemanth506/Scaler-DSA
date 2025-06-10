import { RiderLocationMap } from "../models/RiderLocationMap"

export class RiderLocationMapRepository {
    riderLocationMap: Map<string, RiderLocationMap>
    constructor() {
        this.riderLocationMap = new Map()
    }

    getRiderLocationMap() {
        return this.riderLocationMap
    }

    setRiderLocationMap(riderLocationMap: Map<string, RiderLocationMap>) {
        this.riderLocationMap = riderLocationMap
    }
}