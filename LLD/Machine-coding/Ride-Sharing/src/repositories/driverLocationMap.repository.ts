import { DriverLocationMap } from "../models/DriverLocationMap"

export class DriverLocationMapRepository {
    driverLocationMap: DriverLocationMap[]
    constructor() {
        this.driverLocationMap = []
    }

    getDriverLocationMap() {
        return this.driverLocationMap
    }

    setDriverLocationMap(driverLocationMap: DriverLocationMap[]) {
        this.driverLocationMap = driverLocationMap
    }
}