import type { CoolentType, HighSpeedPrinterConfig, NormalPrinterConfig, Shade } from "../utils/printer-utils.ts";
import { BasePrinterDecorator } from "./utils.ts";

export class NormalPrinter extends BasePrinterDecorator {
    inkLevelAvailable: number;
    noOfPagesAvailable: number;
    printingSpeedRate: number;
    private shade?: Shade;
    constructor(config: NormalPrinterConfig) {
        super(config.isOnline)
        this.inkLevelAvailable = config.inkLevelAvailable
        this.noOfPagesAvailable = config.noOfPagesAvailable
        this.printingSpeedRate = config.printingSpeedRate
    }

    setShadeType(type: Shade) {
        this.shade = type
    }

    getshade() { return this.shade }
    
    print(): string {
        return `Printed the document in ${this.shade} which uses Normal Printer`
    }
}

export class HighSpeedPrinter extends BasePrinterDecorator {
    inkLevelAvailable: number;
    noOfPagesAvailable: number;
    printingSpeedRate: number;
    private shade?: Shade;
    private coolentType: CoolentType
    private noOfCoolingFans: number
    constructor(config: HighSpeedPrinterConfig) {
        super(config.isOnline)
        this.inkLevelAvailable = config.inkLevelAvailable
        this.noOfPagesAvailable = config.noOfPagesAvailable
        this.printingSpeedRate = config.printingSpeedRate
        this.coolentType = config.coolentType
        this.noOfCoolingFans = config.noOfCoolingFans
    }

    setShadeType(type: Shade) {
        this.shade = type
    }
    getshade() { return this.shade }

    print(): string {
        return `Printed the document in ${this.shade} which uses High Speed Printer`
    }
}