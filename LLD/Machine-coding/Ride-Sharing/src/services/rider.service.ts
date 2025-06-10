import { NodeLocation } from "../models/NodeLocation"
import { Rider } from "../models/Rider"
import { RiderLocationMap } from "../models/RiderLocationMap"
import { RiderRepository } from "../repositories/rider.repository"
import { RiderLocationMapRepository } from "../repositories/riderLocationMap.repository"
import { v4 as uuid } from "uuid"

export class RiderService {
    riderRepo: RiderRepository
    riderLocationMapRepo: RiderLocationMapRepository

    constructor() {
        this.riderRepo = new RiderRepository()
        this.riderLocationMapRepo = new RiderLocationMapRepository()
    }

    signUp(newRider: Rider) {
        const rider: Rider | undefined = this.riderRepo.getRiders().get(newRider.id);

        if (rider) {
            throw new Error("Rider already exists")
        }

        this.riderRepo.getRiders().set(newRider.id, newRider);
        console.log(`🚀 ~ New rider signed up ${JSON.stringify(this.riderRepo.getRiders())}`);
    }

    login(email: string, password: string) {
        const allRiders: Map<string, Rider> = this.riderRepo.getRiders()

        if (allRiders.size > 0) {
            let rider: Rider | null = null;
            for (const [, value] of allRiders) {
                if (value.email === email) {
                    rider = value
                    break;
                }
            }

            if (!rider) {
                throw new Error("Rider does not exists")
            }

            if (rider.password !== password) {
                throw new Error("Invalid credentials")
            }

            const riderLocationMap = new RiderLocationMap(rider.id)

            const map = this.riderLocationMapRepo.getRiderLocationMap();
            map.set(rider.id, riderLocationMap);

            console.log(`🚀 ~ Rider logged in ${JSON.stringify([...map.entries()])}`);
            return [uuid(), rider.id]
        }
    }

    updatePickUp(riderId: string, pickUpNode: NodeLocation) {
        const riderLoc = this.riderLocationMapRepo.getRiderLocationMap().get(riderId)
        if(riderLoc) {
            riderLoc.setPickUp(pickUpNode)
            this.riderLocationMapRepo.getRiderLocationMap().set(riderId, riderLoc)
        } else {
            const newRiderLoc = new RiderLocationMap(riderId);
            newRiderLoc.setPickUp(pickUpNode)
            this.riderLocationMapRepo.getRiderLocationMap().set(riderId, newRiderLoc)
        }

        console.log(`Updated pickUp :: ${JSON.stringify(this.riderLocationMapRepo.getRiderLocationMap().get(riderId))}`)
    }

    updateDrop(riderId: string, dropNode: NodeLocation) {
        const riderLoc = this.riderLocationMapRepo.getRiderLocationMap().get(riderId)
        if(riderLoc) {
            riderLoc.setDrop(dropNode)
            this.riderLocationMapRepo.getRiderLocationMap().set(riderId, riderLoc)
        } else {
            const newRiderLoc = new RiderLocationMap(riderId);
            newRiderLoc.setDrop(dropNode)
            this.riderLocationMapRepo.getRiderLocationMap().set(riderId, newRiderLoc)
        }

        console.log(`Updated drop :: ${JSON.stringify(this.riderLocationMapRepo.getRiderLocationMap().get(riderId))}`)
    }
}