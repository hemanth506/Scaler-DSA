import { Driver } from "../models/Driver"

export class DriverRepository {
    driver: Driver[]
    constructor() {
        this.driver = []
    }

    getDriver() {
        return this.driver
    }

    setDriver(driver: Driver[]) {
        this.driver = driver
    }
}