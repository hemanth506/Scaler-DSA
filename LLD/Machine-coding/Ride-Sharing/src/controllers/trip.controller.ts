import { RideAssetType } from "../../helper/enums"
import { TripService } from "../services/trip.service"
import { DriverController } from "./driver.controller"
import { RiderController } from "./rider.controller"

export class TripController {
    tripService: TripService
    constructor() {
        this.tripService = new TripService()
    }

    notifyNearByDrivers(riderId: string, rideAssetType: RideAssetType, riderController: RiderController, driverController: DriverController) {
        this.tripService.notifyNearByDrivers(riderId, rideAssetType, riderController, driverController)
    }

    startTrip(driverId: string, riderId: string, riderController: RiderController, driverController: DriverController) {
        return this.tripService.startTrip(driverId, riderId, riderController, driverController)
    }

    calculateFairAmount(tripId: string) {
        this.tripService.calculateFairAmount(tripId)
    }
}