import { ParkingLot } from "./models/ParkingLot.ts";
import { Vehicle } from "./models/Vehicle.ts";
import { VehicleType } from "./utils/vehicleType.ts";

const params: {
  vehicleType: VehicleType;
  count: number;
}[] = [
  { vehicleType: VehicleType.BIKE, count: 5 },
  { vehicleType: VehicleType.CAR, count: 3 },
  { vehicleType: VehicleType.TRUCK, count: 8 },
];
const parkingLot = new ParkingLot(params);

const bike1 = new Vehicle(VehicleType.BIKE, 'TN01DF2345')
console.log(parkingLot.park(bike1));

const car1 = new Vehicle(VehicleType.CAR, 'KA99PL2934')
console.log(parkingLot.park(car1));

const car2 = new Vehicle(VehicleType.CAR, 'TS07SNDJL')
console.log(parkingLot.park(car2));

console.log(parkingLot.getAvailableSlots(VehicleType.CAR));

parkingLot.unPark(6)

console.log(parkingLot.getAvailableSlots(VehicleType.CAR));

console.log(parkingLot.getOccupiedSlots());
