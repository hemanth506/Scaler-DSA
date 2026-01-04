export const CoolentType = {
    INLET: "INLET",
    OUTLET: "OUTLET"
}
export type CoolentType = (typeof CoolentType)[keyof typeof CoolentType];

export interface NormalPrinterConfig {
    isOnline: boolean,
    inkLevelAvailable: number,
    noOfPagesAvailable: number,
    printingSpeedRate: number,
}

export interface HighSpeedPrinterConfig extends NormalPrinterConfig {
    coolentType: CoolentType
    noOfCoolingFans: number
}

export const BasePrinter = {
    NORMAL_PRINTER: {
        type: "NORMAL_PRINTER",
        config: {
            isOnline: true,
            inkLevelAvailable: 100,
            noOfPagesAvailable: 300,
            printingSpeedRate: 50,
        } as NormalPrinterConfig,
    },
    HIGH_SPEED_PRINTER: {
        type: "HIGH_SPEED_PRINTER",
        config: {
            isOnline: true,
            inkLevelAvailable: 100,
            noOfPagesAvailable: 300,
            printingSpeedRate: 150,
            coolentType: CoolentType.INLET
        } as HighSpeedPrinterConfig,
    },
};
export type BasePrinter = (typeof BasePrinter)[keyof typeof BasePrinter];

export const AddOn = {
    THREE_DIMENTIONAL: "THREE_DIMENTIONAL",
    DUPLEX: "DUPLEX",
    STAPLING: "STAPLING",
    BINDING: "BINDING",
    WATERMARK: "WATERMARK",
    BRAILLE: "BRAILLE",
};
export type AddOn = (typeof AddOn)[keyof typeof AddOn];

export const Shade = {
    COLOR: "COLOR",
    BLACK_WHITE: "BLACK_WHITE",
};
export type Shade = (typeof Shade)[keyof typeof Shade];

export const Priority = {
    HIGH: "HIGH",
    MEDIUM: "MEDIUM",
    LOW: "LOW",
};
export type Priority = (typeof Priority)[keyof typeof Priority];
