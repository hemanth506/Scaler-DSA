import { VehicleType } from "../utils/vehicleType.js"

interface PricingStrategy {
    pricePerSecond: number
    calculatePrice(durationInSeconds: number): number
}

const BIKE_PRICING_AMOUNT_PER_SECOND = 2
const CAR_PRICING_AMOUNT_PER_SECOND = 4
const TRUCK_PRICING_AMOUNT_PER_SECOND = 8

export class BikePricingStrategy implements PricingStrategy {
    pricePerSecond: number = BIKE_PRICING_AMOUNT_PER_SECOND
    calculatePrice(durationInSeconds: number): number { // the logic can be changes/updated
        return durationInSeconds * this.pricePerSecond
    }
}

export class CarPricingStrategy implements PricingStrategy {
    pricePerSecond: number = CAR_PRICING_AMOUNT_PER_SECOND
    calculatePrice(durationInSeconds: number): number { // the logic can be changes/updated
        return durationInSeconds * this.pricePerSecond
    }
}

export class TruckPricingStrategy implements PricingStrategy {
    pricePerSecond: number = TRUCK_PRICING_AMOUNT_PER_SECOND
    calculatePrice(durationInSeconds: number): number { // the logic can be changes/updated
        return durationInSeconds * this.pricePerSecond
    }
}

export class PricingFactory {
    private static strategies = {
    [VehicleType.BIKE]: new BikePricingStrategy(),
    [VehicleType.CAR]: new CarPricingStrategy(),
    [VehicleType.TRUCK]: new TruckPricingStrategy(),
  }
    public static getStrategy(type: VehicleType) {
        return this.strategies[type]
    }
}