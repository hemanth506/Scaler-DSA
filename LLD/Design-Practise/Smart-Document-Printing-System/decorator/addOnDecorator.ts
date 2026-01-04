import { PrinterDecorator } from "./utils.ts";
import type { Decorator } from "./utils.ts";

export class ThreeDimentionalDecor extends PrinterDecorator {
    constructor(decor: Decorator) {
        super(decor.isOnline, decor)
    }
    print(): string {
        return this.inner?.print() + ", 3-Dimentional";
    }
}

export class BrailleDecor extends PrinterDecorator {
    constructor(decor: Decorator) {
        super(decor.isOnline, decor)
    }
    print(): string {
        return this.inner?.print() + ", Braille";
    }
}

export class BindingDecor extends PrinterDecorator {
    constructor(decor: Decorator) {
        super(decor.isOnline, decor)
    }
    print(): string {
        return this.inner?.print() + ", Binding";
    }
}

export class DuplexDecor extends PrinterDecorator {
    constructor(decor: Decorator) {
        super(decor.isOnline, decor)
    }
    print(): string {
        return this.inner?.print() + ", Duplex";
    }
}

export class WaterMarkDecor extends PrinterDecorator {
    constructor(decor: Decorator) {
        super(decor.isOnline, decor)
    }
    print(): string {
        return this.inner?.print() + ", Water Mark";
    }
}