import type { PrintJobDTO } from "../dtos/printer-dto.ts"
import { Priority } from "../utils/printer-utils.ts"

export interface Decorator {
    isOnline: boolean
    inner?: Decorator

    print(): void
    getInner(): Decorator | undefined
}

export abstract class PrinterDecorator implements Decorator {
    isOnline: boolean
    inner?: Decorator
    constructor(isOnlineStatus: boolean, inner?: Decorator) {
        this.isOnline = isOnlineStatus
        this.inner = inner
    }
    setIsOnline(status: boolean) { this.isOnline = status }
    getIsOnline() { return this.isOnline }
    getInner(): Decorator | undefined {
        return this.inner
    }

    abstract print(): string
}

export abstract class BasePrinterDecorator extends PrinterDecorator {
    abstract inkLevelAvailable: number
    abstract noOfPagesAvailable: number
    abstract printingSpeedRate: number
    constructor(isOnlineStatus: boolean) {
        super(isOnlineStatus)
    }
}

export interface CapabilityDecorator {
    decorate(job: PrintJobDTO): [Decorator[], Priority]
}