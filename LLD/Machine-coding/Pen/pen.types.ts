export abstract class Pen {
  abstract penDetails: PenDetails | undefined

  abstract write(word: string): void;
  abstract erase(word: string): void;
  abstract open(): void;
  abstract close(): void;
}

export abstract class RefillPen extends Pen {
  abstract refill: Refill | undefined;
}

export abstract class LiquidPen extends Pen {
  abstract nibDiameter: string | undefined;
  abstract ink: Ink | undefined;
}

export interface PenDetails {
    bodyColor: string | undefined;
    bodyType: BodyType | undefined;
    hasEraser: boolean | undefined;
    eraser: Eraser | undefined;
    isClosed: IsClosed | undefined;
    closingType: ClosingType | undefined;
    colors: Colors | undefined;
    levelOfInk: number | undefined;
  }

export interface Ink {
  liquidType: string;
  density: string;
}

export interface Eraser {
  size: number;
  position: string[2];
  color: string;
}

export interface Refill {
  type: RefillType;
  inkDensity: number;
  stemDiameter: number;
  nibDiameter: number;
  lastRefill: Date;
}

export enum BodyType {
  METAL = "METAL",
  PLASTIC = "PLASTIC",
}

export enum IsClosed {
  OPEN = "OPEN",
  CLOSE = "CLOSE",
  STUCK = "STUCK",
  BROKEN = "BROKEN",
}

export enum ClosingType {
  CAP = "CAP",
  CLICK = "CLICK",
  TWIST = 'TWIST'
}

export enum Colors {
  BLUE = "BLUE",
  BLACK = "BLACK",
  GREEN = "GREEN",
}

export enum RefillType {
  GEL = "GEL",
  BALL = "BALL",
}
