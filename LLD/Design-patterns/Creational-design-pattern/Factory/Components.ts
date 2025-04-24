export interface Cheese {
    getOrigin(): string
    isVegan(): boolean
}

export interface Sauce {
    getFlavor(): string
    isSpicy(): boolean
}

export interface Dough {
    getThickness(): string
    bakeTemperature(): number
}

export class NYCheese implements Cheese {
    getOrigin(): string {
        return "Ethiopia"
    }
    isVegan(): boolean {
        return false
    }
}

export class NYSauce implements Sauce {
    getFlavor(): string {
        return "White Garlic"
    }
    isSpicy(): boolean {
        return false
    }
}

export class NYDough implements Dough {
    getThickness(): string {
        return "3cm"
    }
    bakeTemperature(): number {
        return 240
    }
}


export class CHCheese implements Cheese {
    getOrigin(): string {
        return "Norway"
    }
    isVegan(): boolean {
        return true
    }
}

export class CHSauce implements Sauce {
    getFlavor(): string {
        return "Spicy BBQ"
    }
    isSpicy(): boolean {
        return true
    }
}

export class CHDough implements Dough {
    getThickness(): string {
        return "5cm"
    }
    bakeTemperature(): number {
        return 320
    }
}