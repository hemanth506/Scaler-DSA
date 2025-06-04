import { DriverLocationMap } from "../models/DriverLocationMap"

export class DriverLocationMapRepository {
    driverLocationMap: Map<string, DriverLocationMap> // <driver.id, DriverLocationMap>
    constructor() {
        this.driverLocationMap = new Map()
    }

    getDriverLocationMap() {
        return this.driverLocationMap
    }

    setDriverLocationMap(driverLocationMap: Map<string, DriverLocationMap>) {
        this.driverLocationMap = driverLocationMap
    }
}