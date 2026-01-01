import { VehicleType } from "../utils/vehicleType.ts"
import { Vehicle } from "./Vehicle.ts"

export class ParkingSlot {
    private id: number
    private type: VehicleType
    private floor: number

    constructor(id: number, type: VehicleType, floor: number) {
        this.id = id
        this.type = type
        this.floor = floor
    }

    public getId() { return this.id; }
    public getFloor() { return this.floor; }

}