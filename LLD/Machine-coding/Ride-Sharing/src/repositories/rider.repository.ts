import { Rider } from "../models/Rider"

export class RiderRepository {
    rider: Rider[]
    constructor() {
        this.rider = []
    }

    getRider() {
        return this.rider
    }

    setRider(rider: Rider[]) {
        this.rider = rider
    }
}