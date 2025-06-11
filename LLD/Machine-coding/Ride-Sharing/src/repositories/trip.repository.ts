import { Trip } from "../models/Trip"

export class TripRepository {
    trip: Map<string, Trip>
    constructor() {
        this.trip = new Map()
    }

    getTrip() {
        return this.trip
    }

    setTrip(trip: Map<string, Trip>) {
        this.trip = trip
    }
}