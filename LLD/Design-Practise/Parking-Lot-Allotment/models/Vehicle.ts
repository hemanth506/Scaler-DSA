import { VehicleType } from "../utils/vehicleType.js";

export class Vehicle {
    private type: VehicleType
    private vehicleNumber: string
    constructor(type: VehicleType, vehicleNumber: string) {
        this.type = type
        this.vehicleNumber = vehicleNumber
    }
    getVehicleType(): VehicleType { return this.type; }
}