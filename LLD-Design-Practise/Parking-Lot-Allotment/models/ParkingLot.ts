import { PriorityQueue } from "datastructures-js";
import { VehicleType, type VehicleTypeFloorParams } from "../utils/vehicleType.ts";
import { ParkingSlot } from "./ParkingSlot.ts";
import { Vehicle } from "./Vehicle.ts";
import { ParkingTicket } from "./ParkingTicket.ts";
import { PricingFactory } from "../strategy/PricingStrategy.ts";

type OccupiedSlotDTO = { slotId: number; vehicle: Vehicle };

export class ParkingLot {
	private parkingSlotHeapPerVehicleType: Map<VehicleType, PriorityQueue<ParkingSlot>>
	private availableSlotsPerVehicleType: Map<VehicleType, Set<number>>
	private allotedTickets: Map<number, ParkingTicket>
	private allTickets: ParkingTicket[] // added this as a repository

	constructor(vehicleTypeFloorParams: VehicleTypeFloorParams[]) {
		this.parkingSlotHeapPerVehicleType = new Map<VehicleType, PriorityQueue<ParkingSlot>>
		this.availableSlotsPerVehicleType = new Map<VehicleType, Set<number>>
		this.allotedTickets = new Map<number, ParkingTicket>()
		this.allTickets = []
		this.initializeParkingLot(vehicleTypeFloorParams)
	}

	private initializeParkingLot(vehicleTypeFloorParams: VehicleTypeFloorParams[]) {
		let start = 1
		for (let { vehicleType, floorAndCount } of vehicleTypeFloorParams) {
			const pq = new PriorityQueue((a: ParkingSlot, b: ParkingSlot) => {
				if (a.getFloor() === b.getFloor()) return a.getId() - b.getId();
				return a.getFloor() - b.getFloor()
			})
			const set = new Set<number>()
			for (let { floor, count } of floorAndCount) {
				const end = count + start
				for (let i = start; i <= end - 1; i++) {
					pq.enqueue(new ParkingSlot(i, vehicleType, floor))
					set.add(i)
				}
				this.parkingSlotHeapPerVehicleType.set(vehicleType, pq)
				this.availableSlotsPerVehicleType.set(vehicleType, set)
				start = end
			}
		}
	}

	public park(vehicle: Vehicle): number | null {
		if (!this.parkingSlotHeapPerVehicleType.get(vehicle.getVehicleType())?.isEmpty()) {
			const nextParkingSlot = this.parkingSlotHeapPerVehicleType.get(vehicle.getVehicleType())?.dequeue()
			if (nextParkingSlot) {
				const parkingTicket = new ParkingTicket(nextParkingSlot, vehicle, Date.now())
				this.allotedTickets.set(nextParkingSlot.getId(), parkingTicket)
				this.availableSlotsPerVehicleType.get(vehicle.getVehicleType())?.delete(nextParkingSlot.getId())
				return nextParkingSlot.getId()
			}
		}
		return null
	}

	private calculateParkingCharge(vehType: VehicleType, parkingTicket: ParkingTicket) {
		const pricingStrategy = PricingFactory.getStrategy(vehType)
		const exitTime = Date.now()
		const durationInSeconds = exitTime - parkingTicket.getEntryTime()
		const priceForParking = pricingStrategy.calculatePrice(durationInSeconds)
		parkingTicket.setExitTime(exitTime)
		parkingTicket.setPrice(priceForParking)
		this.allTickets.push(parkingTicket)
		console.log(`You have to pay ${priceForParking} for ${durationInSeconds} seconds`);
	}

	public unPark(slotId: number): void {
		if (this.allotedTickets.has(slotId)) {
			const parkingTicket: ParkingTicket | undefined = this.allotedTickets.get(slotId)
			if (parkingTicket) {
				const vehType = parkingTicket.getVehicle().getVehicleType()

				for (let i = 0; i < 1000000000; i++) { } // just added for delay, so I can get some value as amount

				this.calculateParkingCharge(vehType, parkingTicket)

				this.allotedTickets.delete(slotId)
				this.availableSlotsPerVehicleType.get(vehType)?.add(slotId)
				this.parkingSlotHeapPerVehicleType.get(vehType)?.enqueue(parkingTicket.getParkingSlot())
			}
		}
		return;
	}

	public getAvailableSlots(type: VehicleType): number[] {
		const availableSet = this.availableSlotsPerVehicleType.get(type)
		if (availableSet) {
			return [...availableSet]
		}
		return []
	}

	public getOccupiedSlots(): OccupiedSlotDTO[] {
		const occupiedDto: OccupiedSlotDTO[] = []
		for (let [slotId, parkingTicket] of this.allotedTickets) {
			occupiedDto.push({ slotId, vehicle: parkingTicket.getVehicle() })
		}
		return occupiedDto
	}
}
