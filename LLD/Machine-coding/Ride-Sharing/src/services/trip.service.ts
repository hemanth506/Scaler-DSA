import { RideAssetType, TripStatusType } from "../../helper/enums";
import { DriverController } from "../controllers/driver.controller";
import { RiderController } from "../controllers/rider.controller";
import { Time } from "../dtos/Time";
import { DriverLocationMap } from "../models/DriverLocationMap";
import { FareCalculationStrategy } from "../models/FareCalculationStrategy";
import { Trip } from "../models/Trip";
import { TripRepository } from "../repositories/trip.repository";
import { PubSubService } from "./pubSub.service";

export class TripService {
    tripRepo: TripRepository
    driverThreshold: number = 2
    pubSubService: PubSubService
    private fareCalculationStrategy?: FareCalculationStrategy

    constructor() {
        this.tripRepo = new TripRepository()
        this.pubSubService = new PubSubService()
    }

    setFareCalculationStrategy(strategy: FareCalculationStrategy) {
        this.fareCalculationStrategy = strategy
    }

    notifyNearByDrivers(riderId: string, rideAssetType: RideAssetType, riderController: RiderController, driverController: DriverController) {
        const allRiderLocMap = riderController.riderService.getAllRiderLocationMap();
        const riderPickUp = allRiderLocMap.get(riderId)?.getPickUp();
        if (riderPickUp) {
            const drivers = driverController.driverService.getNearByActiveDrivers(rideAssetType)
            
            drivers.sort((a: DriverLocationMap, b: DriverLocationMap) => {
                const dxA = a.getDriverNodeLocation().x - riderPickUp.x;
                const dyA = a.getDriverNodeLocation().y - riderPickUp.y;
                const dxB = b.getDriverNodeLocation().x - riderPickUp.x;
                const dyB = b.getDriverNodeLocation().y - riderPickUp.y;
                
                const distA = dxA * dxA + dyA * dyA;
                const distB = dxB * dxB + dyB * dyB;
                
                return distA - distB;
            })
            
            const firstTwoDrivers: DriverLocationMap[] = drivers.slice(0, this.driverThreshold)
            for(let i = 0; i < firstTwoDrivers.length; i++) {
                this.pubSubService.subscribe(`For-rider-${riderId}`, (data?: any) => {
                    console.log(`Trip Request sent to Driver [${firstTwoDrivers[i].driverId}] to location [${riderPickUp.x}, ${riderPickUp.y}] to pick Rider [${riderId}]`)
                })
            }

            this.pubSubService.publish(`For-rider-${riderId}`)
        }
    }

    startTrip(driverId: string, riderId: string, riderController: RiderController, driverController: DriverController) {
        const riderLocMap = riderController.riderService.riderLocationMapRepo.getRiderLocationMap().get(riderId);
        const driverLocMap = driverController.driverService.driverLocationMapRepo.getDriverLocationMap().get(driverId);
        
        const riderPickUp = riderLocMap?.getPickUp()
        const riderDrop = riderLocMap?.getDrop()

        let newTrip;
        if(riderLocMap && riderPickUp && riderDrop && driverLocMap) {
            newTrip = new Trip(riderId, driverId, riderPickUp, riderDrop, TripStatusType.ON_GOING);
            this.tripRepo.getTrip().set(newTrip.id, newTrip);
            riderLocMap.setCurrentTripId(newTrip.id)
            driverLocMap.setCurrentTripId(newTrip.id);
            this.pubSubService.subscribe(`For-trip-${newTrip.id}`, () => {
                console.log(`🚀 Hi ${riderId}, your trip has started 🎒 and your driver ${driverId} has reached at your location! Please approach the vehicle 🛵`)
            })

            this.pubSubService.publish(`For-trip-${newTrip.id}`)
        }

        return newTrip?.id;
    }

    calculateFairAmount(tripId: string) {
        const tripDetail = this.tripRepo.getTrip().get(tripId);
        let resFairAmount;
        if(tripDetail) {
            const tripStartTime = tripDetail.getStartTime()
            const tripEndTime = tripDetail.getEndTime()

            if(tripStartTime && tripEndTime) {
                const time: Time = new Time(tripStartTime, tripEndTime)
                const fairAmount = this.fareCalculationStrategy?.calculate(time)
                if(fairAmount) {
                    tripDetail.setFareAmount(fairAmount)
                    resFairAmount = fairAmount
                }
            }
        }
        console.log(`💰 The charges for the trip ${tripId} is ${resFairAmount} WON 💰`)
        return resFairAmount
    }
}