import { DriverStatus, RideAssetType } from "./helper/enums"
import { DriverController } from "./src/controllers/driver.controller"
import { Driver } from "./src/models/Driver"
import { FareCalculationStrategy, TimeBasedCalculation } from "./src/models/FareCalculationStrategy"
import { RideAsset } from "./src/models/RideAsset"

export class Init {
    private fareCalculationStrategy?: FareCalculationStrategy
    private driverController: DriverController

    constructor() {
        this.driverController = new DriverController()
    }

    setFareCalculationStrategy(strategy: FareCalculationStrategy) {
        this.fareCalculationStrategy = strategy
    }

    execute() {
        // this.fareCalculationStrategy?.calculate

        const driver = new Driver("Hemanth", new Date("1997-11-20"), "PSIENQ-392-WNSSO", "hemanthraaj31@gmail.com", "pass123")
        // const riderAsset = [new RideAsset(RideAssetType.TWO_WHEELER, "TN 07 DF 7557")]
        // driver.setRegisteredRideAsset(riderAsset);
        this.driverController.signUp(driver)

        const result = this.driverController.login("hemanthraaj31@gmail.com", "pass123")
        if (result) {
            const [sessionId, driverId] = result
            this.driverController.addRideAsset(driverId, new RideAsset(RideAssetType.TWO_WHEELER, "TN 07 DF 7557"), sessionId)
            this.driverController.updateDriverStatus(driverId, DriverStatus.ONLINE, sessionId)
        }
    }
}

const init = new Init()
init.setFareCalculationStrategy(new TimeBasedCalculation())
init.execute()