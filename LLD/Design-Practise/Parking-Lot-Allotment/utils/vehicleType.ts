export const VehicleType = {
    CAR: "Car",
    BIKE: "Bike",
    TRUCK: "Truck",
} as const;

export type VehicleType = (typeof VehicleType)[keyof typeof VehicleType];


type FloorAndCount = {
    floor: number,
    count: number
}

export type VehicleTypeFloorParams = {
  vehicleType: VehicleType;
  floorAndCount: FloorAndCount[];
}