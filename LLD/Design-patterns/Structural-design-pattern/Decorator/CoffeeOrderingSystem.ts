interface Ingredient {
  getCost(): number;
  getDescription(): string;
}

abstract class IceCreamDecorator implements Ingredient {
  abstract getCost(): number;
  abstract getDescription(): string;
}

// can act as add-on or base ingredient
class VanillaCone extends IceCreamDecorator {
  private ing?: Ingredient;
  constructor(ing?: Ingredient) {
    super();
    this.ing = ing;
  }
  getCost(): number {
    return (Number(this.ing?.getCost()) || 0) + 5;
  }
  getDescription(): string {
    const inner = this.ing?.getDescription() ?? "";
    return (inner.length ? inner + ", " : "") + "Vanilla Cone";
  }
}

// can act as add-on or base ingredient
class ChocolateCone extends IceCreamDecorator {
  private ing?: Ingredient;
  constructor(ing?: Ingredient) {
    super();
    this.ing = ing;
  }
  getCost(): number {
    return (Number(this.ing?.getCost()) || 0) + 5;
  }
  getDescription(): string {
    const inner = this.ing?.getDescription() ?? "";
    return (inner.length ? inner + ", " : "") + "Chocolate Cone";
  }
}

class WhiteChocolate extends IceCreamDecorator {
  private ing: Ingredient;
  constructor(ing: Ingredient) {
    super();
    this.ing = ing;
  }
  getCost(): number {
    return Number(this.ing?.getCost()) + 3;
  }
  getDescription(): string {
    return this.ing.getDescription() + ", White Chocolate";
  }
}

class Waffles extends IceCreamDecorator {
  private ing: Ingredient;
  constructor(ing: Ingredient) {
    super();
    this.ing = ing;
  }
  getCost(): number {
    return Number(this.ing?.getCost()) + 1;
  }
  getDescription(): string {
    return this.ing.getDescription() + ", Waffles";
  }
}

class ChocoChips extends IceCreamDecorator {
  private ing: Ingredient;
  constructor(ing: Ingredient) {
    super();
    this.ing = ing;
  }
  getCost(): number {
    return Number(this.ing.getCost()) + 4;
  }
  getDescription(): string {
    return this.ing.getDescription() + ", Choco chips";
  }
}

class ButterScotchScoop extends IceCreamDecorator {
  private ing: Ingredient;
  constructor(ing: Ingredient) {
    super();
    this.ing = ing;
  }
  getCost(): number {
    return Number(this.ing.getCost()) + 2.5;
  }
  getDescription(): string {
    return this.ing.getDescription() + ", ButterScotch Scoop";
  }
}

const icecream: Ingredient = new ButterScotchScoop(
  new WhiteChocolate(
    new ChocoChips(
      new Waffles(new WhiteChocolate(new ButterScotchScoop(new ChocolateCone())))
    )
  )
);

console.log(icecream.getCost());
console.log(icecream.getDescription());
