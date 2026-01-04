import type { AddOn, Priority, Shade } from "../utils/printer-utils.ts"

export type PrintJobDTO = {
    addOn: AddOn[],
    shade: Shade,
    noOfPagesRequiredToPrint: number,
    allowColorFallback: boolean,
    allowSpeedFallback: boolean,
    priority: Priority
}
