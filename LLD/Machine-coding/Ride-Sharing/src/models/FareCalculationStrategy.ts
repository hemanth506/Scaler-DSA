import { Time } from "../dtos/Time";

export interface FareCalculationStrategy {
    calculate(time: Time, distance?: number): number
}


export class TimeBasedCalculation implements FareCalculationStrategy {
    calculate(time: Time, distance?: number): number {
        const startTime = new Date(time.getStartTime());
        const endTime = new Date(time.getEndTime());

        const diffInMs = endTime.getTime() - startTime.getTime();
        const diffInSeconds = diffInMs / 1000;
        console.log(`Trip duration is ${diffInSeconds} seconds`)
        return Number((diffInSeconds * 800).toFixed(2))
    }
}

export class StandardCalculation implements FareCalculationStrategy {
    calculate(time: Time, distance?: number): number {
        const startTime = new Date(time.getStartTime());
        const endTime = new Date(time.getEndTime());

        const diffInMs = endTime.getTime() - startTime.getTime();
        const diffInSeconds = diffInMs / 1000;
        console.log(`Trip duration is ${diffInSeconds} seconds`)
        return Number((diffInSeconds * 1000).toFixed(2))
    }
}

