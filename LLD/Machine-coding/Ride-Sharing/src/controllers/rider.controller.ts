import { NodeLocation } from "../models/NodeLocation";
import { Rider } from "../models/Rider";
import { RiderService } from "../services/rider.service";

export class RiderController {
    riderService: RiderService
    constructor() {
        this.riderService = new RiderService();
    }
    signUp(rider: Rider) {
        this.riderService.signUp(rider)
    }

    login(email: string, password: string) {
        return this.riderService.login(email, password)
    }

    updatePickUp(riderId: string, pickUpNode: NodeLocation) {
        this.riderService.updatePickUp(riderId, pickUpNode)
    }

    updateDrop(riderId: string, dropNode: NodeLocation) {
        this.riderService.updateDrop(riderId, dropNode)
    }
}