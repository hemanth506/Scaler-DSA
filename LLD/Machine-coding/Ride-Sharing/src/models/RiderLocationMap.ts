import { GlobalClass } from "./GlobalClass";
import { NodeLocation } from "./NodeLocation";

export class RiderLocationMap extends GlobalClass {
    riderId: string
    pickUp: NodeLocation | null
    drop: NodeLocation | null
    currentTripId: string | null
    constructor(riderId: string) {
        super()
        this.riderId = riderId
        this.pickUp = null
        this.drop = null
        this.currentTripId = null
    }

    setPickUp(pickUp: NodeLocation) {
        this.pickUp = pickUp
    }

    getPickUp(): NodeLocation | null {
        return this.pickUp
    }

    setDrop(drop: NodeLocation) {
        this.drop = drop
    }

    getDrop(): NodeLocation | null {
        return this.drop
    }

    setCurrentTripId(tripId: string) {
        this.currentTripId = tripId
    }

    getCurrentTripId(): string | null {
        return this.currentTripId
    }
}