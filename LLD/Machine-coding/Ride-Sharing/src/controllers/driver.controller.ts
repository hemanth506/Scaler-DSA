import { DriverStatus } from "../../helper/enums";
import { Driver } from "../models/Driver";
import { RideAsset } from "../models/RideAsset";
import { DriverService } from "../services/driver.service";

export class DriverController {
    driverService: DriverService
    constructor() {
        this.driverService = new DriverService();
    }
    signUp(driver: Driver) {
        this.driverService.signUp(driver)
    }

    login(email: string, password: string) {
        return this.driverService.login(email, password)
    }

    addRideAsset(driverId: string, rideAsset: RideAsset, sessionId?: string) {
        if(sessionId) {
            this.driverService.addRideAsset(driverId, rideAsset)
        }
    }

    updateDriverStatus(driverId: string, status: DriverStatus, sessionId?: string) {
        if(sessionId) {
            this.driverService.updateDriverStatus(driverId, status)
        }
    }
}