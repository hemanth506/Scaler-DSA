import { Trip } from "../models/Trip"

export class TripRepository {
    trip: Trip[]
    constructor() {
        this.trip = []
    }

    getTrip() {
        return this.trip
    }

    setTrip(trip: Trip[]) {
        this.trip = trip
    }
}