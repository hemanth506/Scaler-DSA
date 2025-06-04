import { RiderLocationMap } from "../models/RiderLocationMap"

export class RiderLocationMapRepository {
    riderLocationMap: RiderLocationMap[]
    constructor() {
        this.riderLocationMap = []
    }

    getRiderLocationMap() {
        return this.riderLocationMap
    }

    setRiderLocationMap(riderLocationMap: RiderLocationMap[]) {
        this.riderLocationMap = riderLocationMap
    }
}