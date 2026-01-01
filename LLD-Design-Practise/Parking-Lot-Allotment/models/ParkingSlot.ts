import { VehicleType } from "../utils/vehicleType.ts"
import { Vehicle } from "./Vehicle.ts"

export class ParkingSlot {
    private id: number
    private type: VehicleType
    private vehicle: Vehicle | null = null

    constructor(id: number, type: VehicleType) {
        this.id = id
        this.type = type
    }

    public getVehicle() { return this.vehicle; }
    public getId() { return this.id; }
    public setVehicle(vehicle: Vehicle) { this.vehicle = vehicle}
}