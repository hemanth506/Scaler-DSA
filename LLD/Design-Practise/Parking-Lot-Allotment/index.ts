import { ParkingLot } from "./models/ParkingLot.js";
import { Vehicle } from "./models/Vehicle.js";
import { VehicleType, type VehicleTypeFloorParams } from "./utils/vehicleType.js";

const params: VehicleTypeFloorParams[] = [
  { vehicleType: VehicleType.BIKE, floorAndCount: [{floor: 1, count: 3}, {floor: 2, count: 6}] },
  { vehicleType: VehicleType.CAR, floorAndCount: [{floor: 1, count: 4}, {floor: 2, count: 3}] },
  { vehicleType: VehicleType.TRUCK, floorAndCount: [{floor: 1, count: 5}, {floor: 2, count: 3}] },
];
const parkingLot = new ParkingLot(params);

const bike1 = new Vehicle(VehicleType.BIKE, 'TN01DF2345')
console.log(parkingLot.park(bike1));

const car1 = new Vehicle(VehicleType.CAR, 'KA99PL2934')
console.log(parkingLot.park(car1));

const car2 = new Vehicle(VehicleType.CAR, 'TS07SNDJL')
console.log(parkingLot.park(car2));

console.log(parkingLot.getAvailableSlots(VehicleType.CAR));

parkingLot.unPark(10)

console.log(parkingLot.getAvailableSlots(VehicleType.CAR));

console.log(parkingLot.getOccupiedSlots());
