import { PriorityQueue } from "datastructures-js";
import { VehicleType } from "../utils/vehicleType.ts";
import { ParkingSlot } from "./ParkingSlot.ts";
import { Vehicle } from "./Vehicle.ts";

type OccupiedSlotDTO = { slotId: number; vehicle: Vehicle };

export class ParkingLot {
	private parkingSlotHeapPerVehicleType: Map<VehicleType, PriorityQueue<ParkingSlot>>
	private availableSlotsPerVehicleType: Map<VehicleType, Set<number>>
	private parkedVehicle: Map<number, Vehicle>

	constructor(parkingLotCounts: { vehicleType: VehicleType; count: number }[]) {
		this.parkingSlotHeapPerVehicleType = new Map<VehicleType, PriorityQueue<ParkingSlot>>
		this.availableSlotsPerVehicleType = new Map<VehicleType, Set<number>>
		this.parkedVehicle = new Map<number, Vehicle>()
		
		let start = 1
		for (let { vehicleType, count } of parkingLotCounts) {
			const end = count + start
			const pq = new PriorityQueue((a: ParkingSlot, b: ParkingSlot) => a.getId() - b.getId())
			const set = new Set<number>()
			for (let i = start; i <= end - 1; i++) {
				pq.enqueue(new ParkingSlot(i, vehicleType))
				set.add(i)
			}
			this.parkingSlotHeapPerVehicleType.set(vehicleType, pq)
			this.availableSlotsPerVehicleType.set(vehicleType, set)
			start = end
		}
	}

	public park(vehicle: Vehicle): number | null {
		if (!this.parkingSlotHeapPerVehicleType.get(vehicle.getVehicleType())?.isEmpty()) {
			const nextParkingSlot = this.parkingSlotHeapPerVehicleType.get(vehicle.getVehicleType())?.dequeue()
			if (nextParkingSlot) {
				this.parkedVehicle.set(nextParkingSlot.getId(), vehicle)
				this.availableSlotsPerVehicleType.get(vehicle.getVehicleType())?.delete(nextParkingSlot.getId())
				return nextParkingSlot.getId()
			}
		}
		return null
	}

	public unPark(slotId: number): void {
		if (this.parkedVehicle.has(slotId)) {
			const vehicle: Vehicle | undefined = this.parkedVehicle.get(slotId)
			if (vehicle) {
				const vehType = vehicle.getVehicleType()
				this.parkedVehicle.delete(slotId)
				this.availableSlotsPerVehicleType.get(vehType)?.add(slotId)
				this.parkingSlotHeapPerVehicleType.get(vehType)?.enqueue(new ParkingSlot(slotId, vehType))
			}
		}
		return;
	}

	public getAvailableSlots(type: VehicleType): number[] {
		const availableSet = this.availableSlotsPerVehicleType.get(type)
		if(availableSet) {
			return [...availableSet]
		}
		return []
	}

	public getOccupiedSlots(): OccupiedSlotDTO[] {
		const occupiedDto: OccupiedSlotDTO[] = []
		for (let [slotId, vehicle] of this.parkedVehicle) {
			occupiedDto.push({ slotId, vehicle })
		}
		return occupiedDto
	}
}
