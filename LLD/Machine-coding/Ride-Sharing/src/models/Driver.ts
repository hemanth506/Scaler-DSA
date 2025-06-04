import { GlobalClass } from "./GlobalClass";
import { RideAsset } from "./RideAsset";

export class Driver extends GlobalClass {
    name: string
    dob: Date
    licenseNo: string
    email: string
    password: string
    registeredRideAsset: RideAsset[] | null
    constructor(name: string, dob: Date, licenseNo: string, email: string, password: string) {
        super()
        this.name = name
        this.dob = dob
        this.licenseNo = licenseNo
        this.email = email
        this.password = password
        this.registeredRideAsset = null
    }

    setRegisteredRideAsset(registeredRideAsset: RideAsset[]) {
        this.registeredRideAsset = registeredRideAsset
    }

    getRegisteredRideAsset() {
        return this.registeredRideAsset
    }
}