import { fairDetails } from "./types";

export enum VehicleType {
  CAR = "CAR",
  BIKE = "BIKE",
  TRUCK = "TRUCK",
}

export enum GateType {
    ENTRY = "ENTRY",
    EXIT = "EXIT"
}

export enum OccupiedState {
  OCCUPIED = "OCCUPIED",
  AVAILABLE = "AVAILABLE",
  UNDER_SERVICE = "UNDER_SERVICE",
}

export const fairPricingMap: Record<VehicleType, fairDetails> = {
  [VehicleType.BIKE]: { oneHr: 1000, oneMin: 100, oneSec: 10 },
  [VehicleType.CAR]: { oneHr: 2000, oneMin: 200, oneSec: 20 },
  [VehicleType.TRUCK]: { oneHr: 3000, oneMin: 300, oneSec: 30 },
};

export const vehicleIndexMap: Record<VehicleType, number> = {
  [VehicleType.BIKE]: 0,
  [VehicleType.CAR]: 1,
  [VehicleType.TRUCK]: 2,
};

export enum ResponseType {
  SLOT_ALLOTED = "SLOT_ALLOTED",
  SLOT_ALLOTED_FOR_QUEUED_VEHICLE = "SLOT_ALLOTED_FOR_QUEUED_VEHICLE",
  PUSHED_TO_QUEUE = "PUSHED_TO_QUEUE",
  VEHICLE_EXITED = "VEHICLE_EXITED"
}