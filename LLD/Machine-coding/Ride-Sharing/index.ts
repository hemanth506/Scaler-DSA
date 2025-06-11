import { DriverStatus, Gender, RideAssetType } from "./helper/enums"
import { getRandom } from "./helper/utils"
import { DriverController } from "./src/controllers/driver.controller"
import { RiderController } from "./src/controllers/rider.controller"
import { TripController } from "./src/controllers/trip.controller"
import { Driver } from "./src/models/Driver"
import { TimeBasedCalculation } from "./src/models/FareCalculationStrategy"
import { NodeLocation } from "./src/models/NodeLocation"
import { RideAsset } from "./src/models/RideAsset"
import { Rider } from "./src/models/Rider"
import promptSync from "prompt-sync";
import { Callback } from "./src/services/pubSub.service"

export class Init {
    private driverController: DriverController
    private riderController: RiderController
    private tripController: TripController
    private prompt: any

    constructor() {
        this.driverController = new DriverController()
        this.riderController = new RiderController()
        this.tripController = new TripController()
        this.prompt = promptSync();
    }

    runDriverSetUp() {
        const driver1 = new Driver("Hemanth", new Date("1997-11-20"), "PSIENQ-392-WNSSO", "hemanthraaj31@gmail.com", "pass123")
        this.driverController.signUp(driver1)

        const driver2 = new Driver("John", new Date("1999-04-10"), "HJKNEK-823-KJWX", "john@gmail.com", "pass910")
        this.driverController.signUp(driver2)

        const driver3 = new Driver("Micheal", new Date("1980-01-09"), "LKJDSA-2092-MNSO", "micheal@gmail.com", "pass018")
        this.driverController.signUp(driver3)


        const driver1Response = this.driverController.login("hemanthraaj31@gmail.com", "pass123")
        if (driver1Response) {
            const [sessionId, driverId] = driver1Response
            this.driverController.addRideAsset(driverId, new RideAsset(RideAssetType.TWO_WHEELER, "TN 07 DF 7557"), sessionId)
            this.driverController.updateDriverStatus(driverId, DriverStatus.ONLINE, sessionId)
        }

        const driver2Response = this.driverController.login("john@gmail.com", "pass910")
        if (driver2Response) {
            const [sessionId, driverId] = driver2Response
            this.driverController.addRideAsset(driverId, new RideAsset(RideAssetType.TWO_WHEELER, "KA 13 KP 9212"), sessionId)
            this.driverController.updateDriverStatus(driverId, DriverStatus.ONLINE, sessionId)
        }

        const driver3Response = this.driverController.login("micheal@gmail.com", "pass018")
        if (driver3Response) {
            const [sessionId, driverId] = driver3Response
            this.driverController.addRideAsset(driverId, new RideAsset(RideAssetType.TWO_WHEELER, "TN 18 QL 2172"), sessionId)
            this.driverController.updateDriverStatus(driverId, DriverStatus.ONLINE, sessionId)
        }
    }

    runRiderSetUp() {
        const rider = new Rider("Ruchika", "agsruchika@gmail.com", "pass456", Gender.FEMALE)
        this.riderController.signUp(rider)
        const riderResponse = this.riderController.login("agsruchika@gmail.com", "pass456")
        let riderId;
        if(riderResponse) {
            const [resSessionId, resRiderId] = riderResponse
            if(resSessionId) {
                riderId = resRiderId
                const pickUpLocation: NodeLocation = new NodeLocation(getRandom(), getRandom());
                this.riderController.updatePickUp(resRiderId, pickUpLocation)
                const dropLocation: NodeLocation = new NodeLocation(getRandom(), getRandom());
                this.riderController.updateDrop(resRiderId, dropLocation)
            }
        }

        return riderId;
    }

    execute() {
        this.tripController.tripService.setFareCalculationStrategy(new TimeBasedCalculation())

        // Driver setup
        this.runDriverSetUp()

        // Rider setup
        const riderId = this.runRiderSetUp()

        if(riderId) {
            // find trip for rider
            this.tripController.notifyNearByDrivers(riderId, RideAssetType.TWO_WHEELER, this.riderController, this.driverController)
    
            // driver acceptance
            const driverId = this.prompt("Enter the driver id who accepts the ride? \n")

            // start trip
            const tripId = this.tripController.startTrip(driverId, riderId, this.riderController, this.driverController)

            if(tripId) { // work around
                this.executeTripInterval(tripId, this.postTripTask.bind(this))   
            }
        }
    }

    postTripTask(tripId: string) {
        this.tripController.tripService.tripRepo.getTrip().get(tripId)?.setEndTime(new Date())

        this.tripController.calculateFairAmount(tripId)
    }

    executeTripInterval(tripId: string, callback: Callback) {
        const minutes = Math.floor(Math.random() * (10 - 5 + 1)) + 5;
        setTimeout(() => {
            console.log(`🚀 ~ Trip ${tripId} has completed!`)
            callback(tripId)
        }, minutes * 1000)
    }
}

const init = new Init()
init.execute()