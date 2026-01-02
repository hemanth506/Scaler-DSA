import { randomUUID } from "crypto"
import { ParkingSlot } from "./ParkingSlot.js"
import { Vehicle } from "./Vehicle.js"

export class ParkingTicket {
    private ticketId: string
    private parkingSlot: ParkingSlot
    private vehicle: Vehicle
    private entryTime: number
    private exitTime?: number
    private price?: number

    constructor(parkingSlot: ParkingSlot, vehicle: Vehicle, entryTime: number) {
        this.ticketId = randomUUID()
        this.parkingSlot = parkingSlot
        this.vehicle = vehicle
        this.entryTime = entryTime
    }

    getVehicle() { return this.vehicle; }
    getParkingSlot() { return this.parkingSlot; }
    getEntryTime() { return this.entryTime; }
    getExitTime() { return this.exitTime; }
    getPrice() { return this.price; }

    setExitTime(exitTime: number) {  this.exitTime = exitTime }
    setPrice(price: number) { this.price = price }
}