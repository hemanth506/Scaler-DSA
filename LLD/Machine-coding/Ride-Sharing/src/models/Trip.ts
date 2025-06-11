import { TripStatusType } from "../../helper/enums";
import { GlobalClass } from "./GlobalClass";
import { NodeLocation } from "./NodeLocation";

export class Trip extends GlobalClass {
    riderId: string
    driverId: string
    pickUp: NodeLocation
    drop: NodeLocation
    tripStatus: TripStatusType
    fareAmount: number | null
    startTime: Date
    endTime: Date | null
    constructor(riderId: string, driverId: string, pickUp: NodeLocation, drop: NodeLocation, tripStatus: TripStatusType) {
        super();
        this.riderId = riderId
        this.driverId = driverId
        this.pickUp = pickUp
        this.drop = drop
        this.tripStatus = TripStatusType.ON_GOING
        this.fareAmount = null
        this.startTime = new Date()
        this.endTime = null
    }

    setTripStatus(tripStatus: TripStatusType) {
        this.tripStatus = tripStatus
    }

    getTripStatus() {
        return this.tripStatus
    }

    setDrop(drop: NodeLocation) {
        this.drop = drop
    }

    getDrop() {
        return this.drop
    }

    setPickUp(pickUp: NodeLocation) {
        this.pickUp = pickUp
    }

    getPickUp() {
        return this.pickUp
    }


    setDriverId(driverId: string) {
        this.driverId = driverId
    }

    getDriverId() {
        return this.driverId
    }

    setFareAmount(fareAmount: number) {
        this.fareAmount = fareAmount
    }

    getFareAmount() {
        return this.fareAmount
    }

    getEndTime() {
        return this.endTime
    }

    setEndTime(endTime: Date) {
        this.endTime = endTime
    }

    getStartTime() {
        return this.startTime
    }

    setStartTime(startTime: Date) {
        this.startTime = startTime
    }
}