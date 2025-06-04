import { Driver } from "../models/Driver"

export class DriverRepository {
    drivers: Map<string, Driver> // <driver.id, DriverLocationMap>
    constructor() {
        this.drivers = new Map()
    }

    getDrivers() {
        return this.drivers
    }

    setDrivers(drivers: Map<string, Driver>) {
        this.drivers = drivers
    }
}