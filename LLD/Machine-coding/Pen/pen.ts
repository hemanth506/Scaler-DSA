import { PenDetails, Refill, RefillPen, LiquidPen, Ink } from "./pen.types";

class RefillPenClass extends RefillPen {
  penDetails: PenDetails | undefined;
  refill: Refill | undefined;

  constructor(penDetails: PenDetails, refill: Refill) {
    super();
    this.penDetails = penDetails;
    this.refill = refill;
  }

  write(word: string): void {
    throw new Error("Method not implemented.");
  }
  erase(word: string): void {
    throw new Error("Method not implemented.");
  }
  open(): void {
    throw new Error("Method not implemented.");
  }
  close(): void {
    throw new Error("Method not implemented.");
  }
}

class LiquidPenClass extends LiquidPen {
  penDetails: PenDetails | undefined;
  nibDiameter: string | undefined;
  ink: Ink | undefined;

  constructor(penDetails: PenDetails, ink: Ink, nibDiameter: string) {
    super();
    this.penDetails = penDetails;
    this.ink = ink;
    this.nibDiameter = nibDiameter;
  }

  write(word: string): void {
    throw new Error("Method not implemented.");
  }
  erase(word: string): void {
    throw new Error("Method not implemented.");
  }
  open(): void {
    throw new Error("Method not implemented.");
  }
  close(): void {
    throw new Error("Method not implemented.");
  }
}
