import { Time } from "../dtos/Time";

export interface FareCalculationStrategy {
    calculate(time: Time, distance?: number): number
}


export class TimeBasedCalculation implements FareCalculationStrategy {
    calculate(time: Time, distance?: number): number {
        return Math.random() * 800
    }
}

export class StandardCalculation implements FareCalculationStrategy {
    calculate(time: Time, distance?: number): number {
        return Math.random() * 1000;
    }
}

