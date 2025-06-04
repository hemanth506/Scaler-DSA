import { DriverStatus } from "../../helper/enums";
import { GlobalClass } from "./GlobalClass";
import { NodeLocation } from "./NodeLocation";

export class DriverLocationMap extends GlobalClass {
    driverId: string
    driverNodeLocation: NodeLocation
    rideAssetId: string | null
    status: DriverStatus
    currentTripId: string | null
    constructor(driverId: string, driverNodeLocation: NodeLocation) {
        super()
        this.driverId = driverId
        this.driverNodeLocation = driverNodeLocation
        this.rideAssetId = null
        this.status = DriverStatus.OFFLINE
        this.currentTripId = null
    }

    setRideAssetId(rideAssetId: string) {
        this.rideAssetId = rideAssetId
    }

    getRideAssetId() {
        return this.rideAssetId
    }

    setStatus(status: DriverStatus) {
        this.status = status
    }

    getStatus() {
        return this.status
    }

    setCurrentTripId(currentTripId: string) {
        this.currentTripId = currentTripId
    }

    getCurrentTripId() {
        return this.currentTripId
    }
}