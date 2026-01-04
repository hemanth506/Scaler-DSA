import { BindingDecor, BrailleDecor, DuplexDecor } from "../decorator/addOnDecorator.ts"
import type { Decorator, PrinterDecorator } from "../decorator/utils.ts"
import { AddOn } from "../utils/printer-utils.ts"

export class PrinterDecoratorFactory {
    static applyAddOns(
        base: PrinterDecorator,
        addOns: AddOn[]
    ): Decorator {
        let printer = base

        for (const addOn of addOns) {
            switch (addOn) {
                case AddOn.DUPLEX:
                    printer = new DuplexDecor(printer)
                    break

                case AddOn.BINDING:
                    printer = new BindingDecor(printer)
                    break

                case AddOn.BRAILLE:
                    printer = new BrailleDecor(printer)
                    break
            }
        }

        return printer
    }
}