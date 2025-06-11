import { DriverStatus, RideAssetType } from "../../helper/enums";
import { getRandom } from "../../helper/utils";
import { Driver } from "../models/Driver";
import { DriverLocationMap } from "../models/DriverLocationMap";
import { NodeLocation } from "../models/NodeLocation";
import { RideAsset } from "../models/RideAsset";
import { DriverRepository } from "../repositories/driver.repository";
import { DriverLocationMapRepository } from "../repositories/driverLocationMap.repository";
import { v4 as uuid } from "uuid"

export class DriverService {
    driverRepo: DriverRepository
    driverLocationMapRepo: DriverLocationMapRepository

    constructor() {
        this.driverRepo = new DriverRepository()
        this.driverLocationMapRepo = new DriverLocationMapRepository()
    }

    signUp(newDriver: Driver) {
        const driver: Driver | undefined = this.driverRepo.getDrivers().get(newDriver.id);
        
        if (driver) {
            throw new Error("Driver already exists")
        }

        this.driverRepo.getDrivers().set(newDriver.id, newDriver);
        console.log(`🚀 ~ New driver signed up ${newDriver.id}`);
    }

    login(email: string, password: string) {
        const allDrivers: Map<string, Driver> = this.driverRepo.getDrivers()

        if (allDrivers.size > 0) {
            let driver: Driver | null = null;
            for (const [, value] of allDrivers) {
                if (value.email === email) {
                    driver = value
                    break;
                }
            }

            if (!driver) {
                throw new Error("Driver does not exists")
            }

            if (driver.password !== password) {
                throw new Error("Invalid credentials")
            }

            const driverLocationMap = new DriverLocationMap(driver.id, new NodeLocation(getRandom(), getRandom()))

            const map = this.driverLocationMapRepo.getDriverLocationMap();
            map.set(driver.id, driverLocationMap);

            console.log(`🚀 ~ Driver logged in ${JSON.stringify([...map.entries()])}`);
            return [uuid(), driver.id]
        }
    }

    updateDriverStatus(driverId: string, status: DriverStatus) {
        if (status === DriverStatus.ONLINE || status === DriverStatus.ON_TRIP) {
            const rideAsset = this.driverLocationMapRepo.getDriverLocationMap().get(driverId)?.getRideAssetId()
            if (rideAsset) {
                this.driverLocationMapRepo.getDriverLocationMap().get(driverId)?.setStatus(status)
                console.log(`🚀 ~ Driver status updated to ${status}`);
            } else {
                throw new Error("Status Update fail! RideAsset is not Selected/Empty")
            }
        }
    }

    addRideAsset(driverId: string, riderAsset: RideAsset) {
        const driver = this.driverRepo.getDrivers().get(driverId)
        if(driver) {
            driver.getRegisteredRideAsset().set(riderAsset.id, riderAsset)
            if(driver.getRegisteredRideAsset().size === 1) {
                // Since there is only one rideAsset, we can pick that as the default rideAsset.
                const map = this.driverLocationMapRepo.getDriverLocationMap();
                map.get(driverId)?.setRideAssetId(riderAsset.id);
                console.log(`🚀 ~ RideAsset Picked ${JSON.stringify(map.get(driverId))}`);
            }
            console.log(`🚀 ~ RideAsset added!`);

        }
    }

    getNearByActiveDrivers(rideAssetType: RideAssetType) {
        const allDrivers = this.driverLocationMapRepo.getDriverLocationMap();
        const activeDrivers = []
        for(const [, value] of allDrivers) {
            if(value.getStatus() === DriverStatus.ONLINE) {
                activeDrivers.push(value)
            }
        }

        const activeRideAssetTypeDriver: DriverLocationMap[] = []
        for(let i = 0; i < activeDrivers.length; i++) {
            const rideAssetId = activeDrivers[i].getRideAssetId()
            if(rideAssetId) {
                const activeAssetPerDriver = this.driverRepo.getDrivers().get(activeDrivers[i].driverId)?.getRegisteredRideAsset().get(rideAssetId)
                if(activeAssetPerDriver?.type === rideAssetType) {
                    activeRideAssetTypeDriver.push(activeDrivers[i])
                }
            }
        }

        return activeRideAssetTypeDriver
    }
}