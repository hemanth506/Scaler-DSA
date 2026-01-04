import type { PrintJobDTO } from "../dtos/printer-dto.ts";
import { AddOn, Priority, Shade } from "../utils/printer-utils.ts";

export class PrintJobBuilder {
    private shade?: Shade
    private addOn: AddOn[] = []
    private noOfPagesRequiredToPrint?: number
    private allowColorFallback: boolean = false
    private allowSpeedFallback: boolean = false
    private priority?: Priority

    setPriority(priority: Priority): PrintJobBuilder {
        this.priority = priority
        return this
    }

    setShade(shade: Shade): PrintJobBuilder {
        this.shade = shade
        return this
    }

    setAddons(addOn: AddOn): PrintJobBuilder {
        this.addOn.push(addOn)
        return this
    }

    setNoOfPagesRequiredToPrint(noOfPagesRequiredToPrint: number): PrintJobBuilder {
        this.noOfPagesRequiredToPrint = noOfPagesRequiredToPrint
        return this
    }

    setAllowColorFallback(allowColorFallback: boolean): PrintJobBuilder {
        this.allowColorFallback = allowColorFallback
        return this
    }

    setAllowSpeedFallback(allowSpeedFallback: boolean): PrintJobBuilder {
        this.allowSpeedFallback = allowSpeedFallback
        return this
    }

    private validate(): boolean {
        if (!this.shade) return false
        if (!this.noOfPagesRequiredToPrint || this.noOfPagesRequiredToPrint <= 0) return false
        if (!this.priority) return false
        return true
    }

    build(): PrintJobDTO | Error {
        if (!this.validate()) {
            return new Error("Printer not available at the moment!!")
        }
        return {
            addOn: this.addOn,
            shade: this.shade!,
            noOfPagesRequiredToPrint: this.noOfPagesRequiredToPrint!,
            allowColorFallback: this.allowColorFallback,
            allowSpeedFallback: this.allowSpeedFallback,
            priority: this.priority!
        }
    }
}