import { GlobalClass } from "./GlobalClass";
import { NodeLocation } from "./NodeLocation";

export class RiderLocationMap extends GlobalClass {
    riderId: string
    pickUp: NodeLocation
    drop: NodeLocation
    currentTripId: string | null
    constructor(riderId: string, pickUp: NodeLocation, drop: NodeLocation) {
        super()
        this.riderId = riderId
        this.pickUp = pickUp
        this.drop = drop
        this.currentTripId = null
    }

    setPickUp(pickUp: NodeLocation) {
        this.pickUp = pickUp
    }

    getPickUp(): NodeLocation {
        return this.pickUp
    }

    setDrop(drop: NodeLocation) {
        this.pickUp = drop
    }

    getDrop(): NodeLocation {
        return this.drop
    }

    setCurrentTripId(tripId: string) {
        this.currentTripId = tripId
    }

    getCurrentTripId(): string | null {
        return this.currentTripId
    }
}