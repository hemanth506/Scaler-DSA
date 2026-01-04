import { PrintJobBuilder } from "../builder/printer.builder.ts";
import type { CapabilityDecorator, Decorator } from "../decorator/utils.ts";
import type { PrintJobDTO } from "../dtos/printer-dto.ts";
import type { Scheduler } from "../scheduler/printerScheduler.ts";
import type { Priority } from "../utils/printer-utils.ts";

export class PrinterOrchestrator {
    capabilityDecorator: CapabilityDecorator
    scheduler: Scheduler
    constructor(capabilityDecorator: CapabilityDecorator, scheduler: Scheduler) {
        this.capabilityDecorator = capabilityDecorator
        this.scheduler = scheduler
    }
    public static createBuilder(): PrintJobBuilder {
        return new PrintJobBuilder()
    }

    public orchestrate(printJobDTO: PrintJobDTO) {
        const [decorators, priority]: [Decorator[], Priority] = this.capabilityDecorator.decorate(printJobDTO)
        this.scheduler.schedule(decorators, priority)
    }
} 