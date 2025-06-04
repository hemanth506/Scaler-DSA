import { FareCalculationStrategy, TimeBasedCalculation } from "./src/models/FareCalculationStrategy"

export class Init {
    private fareCalculationStrategy?: FareCalculationStrategy

    setFareCalculationStrategy(strategy: FareCalculationStrategy) {
        this.fareCalculationStrategy = strategy
    }

    execute() {
        this.fareCalculationStrategy?.calculate
    }
}

const init = new Init()
init.setFareCalculationStrategy(new TimeBasedCalculation())
init.execute()