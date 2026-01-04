import type { PrintJobDTO } from "../dtos/printer-dto.ts";
import { PrinterDecoratorFactory } from "../factory/PrinterDecoratorFactory.ts";
import { BasePrinter, Priority } from "../utils/printer-utils.ts";
import { HighSpeedPrinter, NormalPrinter } from "./baseDecorator.ts";
import type { Decorator, CapabilityDecorator } from "./utils.ts";

export class PrinterCapabilityDecorator implements CapabilityDecorator {
    private strategyByBasePrinter = {
        [BasePrinter.HIGH_SPEED_PRINTER.type]: new HighSpeedPrinter(BasePrinter.HIGH_SPEED_PRINTER.config),
        [BasePrinter.NORMAL_PRINTER.type]: new NormalPrinter(BasePrinter.NORMAL_PRINTER.config)
    }
    decorate(job: PrintJobDTO): [Decorator[], Priority] {
        const highSpeed = this.strategyByBasePrinter[BasePrinter.HIGH_SPEED_PRINTER.type]
        highSpeed.setShadeType(job.shade)
        const normal = this.strategyByBasePrinter[BasePrinter.NORMAL_PRINTER.type]
        normal.setShadeType(job.shade)

        const basePrinters = []

        if(!job.allowSpeedFallback || job.priority === Priority.HIGH) {
            basePrinters.push(highSpeed)
        }
        if(job.priority === Priority.HIGH) {
            basePrinters.push(normal)
        }
        
        const printers = []
        for(let bp of basePrinters) {
            printers.push(PrinterDecoratorFactory.applyAddOns(bp, job.addOn))
        }

        return [printers, job.priority];
    }
}