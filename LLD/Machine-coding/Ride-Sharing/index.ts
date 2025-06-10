import { DriverStatus, Gender, RideAssetType } from "./helper/enums"
import { getRandom } from "./helper/utils"
import { DriverController } from "./src/controllers/driver.controller"
import { RiderController } from "./src/controllers/rider.controller"
import { Time } from "./src/dtos/Time"
import { Driver } from "./src/models/Driver"
import { FareCalculationStrategy, TimeBasedCalculation } from "./src/models/FareCalculationStrategy"
import { NodeLocation } from "./src/models/NodeLocation"
import { RideAsset } from "./src/models/RideAsset"
import { Rider } from "./src/models/Rider"

export class Init {
    private fareCalculationStrategy?: FareCalculationStrategy
    private driverController: DriverController
    private riderController: RiderController

    constructor() {
        this.driverController = new DriverController()
        this.riderController = new RiderController()
    }

    setFareCalculationStrategy(strategy: FareCalculationStrategy) {
        this.fareCalculationStrategy = strategy
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
        if(riderResponse) {
            const [sessionId, riderId] = riderResponse
            if(sessionId) {
                const pickUpLocation: NodeLocation = new NodeLocation(getRandom(), getRandom());
                this.riderController.updatePickUp(riderId, pickUpLocation)
                const dropLocation: NodeLocation = new NodeLocation(getRandom(), getRandom());
                this.riderController.updateDrop(riderId, dropLocation)
            }
        }
    }

    execute() {
        // this.fareCalculationStrategy?.calculate

        // Driver setup
        this.runDriverSetUp()

        // Rider setup
        this.runRiderSetUp()
    }
}

const init = new Init()
init.setFareCalculationStrategy(new TimeBasedCalculation())
init.execute()