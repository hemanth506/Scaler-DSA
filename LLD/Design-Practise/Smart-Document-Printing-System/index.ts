import { PrinterCapabilityDecorator } from "./decorator/PrinterCapabilityDecorator.ts";
import { PrinterOrchestrator } from "./orchestrator/printerOrchestrator.ts";
import { PrinterScheduler } from "./scheduler/printerScheduler.ts";
import { AddOn, Priority, Shade } from "./utils/printer-utils.ts";

const printerParams = PrinterOrchestrator.createBuilder()
  .setAddons(AddOn.BINDING)
  .setAddons(AddOn.BRAILLE)
  .setAddons(AddOn.DUPLEX)
  .setAllowColorFallback(true)
  .setNoOfPagesRequiredToPrint(30)
  .setShade(Shade.BLACK_WHITE)
  .setPriority(Priority.HIGH)
  .build()

if(!(printerParams instanceof Error)){
    const cd = new PrinterCapabilityDecorator()
    const ps = new PrinterScheduler()

    const obj = new PrinterOrchestrator(cd, ps)
    obj.orchestrate(printerParams);
}
  