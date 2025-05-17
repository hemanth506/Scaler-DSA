import { FairDetails } from "./types";

export enum VehicleType {
  CAR = "CAR",
  BIKE = "BIKE",
  TRUCK = "TRUCK",
}

export enum OccupiedState {
  OCCUPIED = "OCCUPIED",
  AVAILABLE = "AVAILABLE",
  UNDER_SERVICE = "UNDER_SERVICE",
}

export const FairPricingMap: Record<VehicleType, FairDetails> = {
  [VehicleType.BIKE]: { oneHr: 1000, oneMin: 100, oneSec: 10 },
  [VehicleType.CAR]: { oneHr: 2000, oneMin: 200, oneSec: 20 },
  [VehicleType.TRUCK]: { oneHr: 3000, oneMin: 300, oneSec: 30 },
};

export const VehicleIndexMap: Record<VehicleType, number> = {
  [VehicleType.BIKE]: 0,
  [VehicleType.CAR]: 1,
  [VehicleType.TRUCK]: 2,
};