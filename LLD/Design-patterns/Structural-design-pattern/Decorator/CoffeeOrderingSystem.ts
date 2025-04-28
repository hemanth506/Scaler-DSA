interface Ingredient {
  getCost(): number;
  getDescription(): string;
}

class SimpleCoffee implements Ingredient {
  getCost(): number {
    return 5;
  }
  getDescription(): string {
    return "Simple Coffee";
  }
}

abstract class CoffeeDecorator implements Ingredient {
  abstract getCost(): number;
  abstract getDescription(): string;
}

class MilkDecorator extends CoffeeDecorator {
  ing: Ingredient;
  constructor(ing: Ingredient) {
    super();
    this.ing = ing;
  }
  getCost(): number {
    return Number(this.ing?.getCost()) + 3;
  }
  getDescription(): string {
    return this.ing?.getDescription() + ", Milk";
  }
}

class SugarDecorator extends CoffeeDecorator {
  ing: Ingredient;
  constructor(ing: Ingredient) {
    super();
    this.ing = ing;
  }
  getCost(): number {
    return Number(this.ing?.getCost()) + 1;
  }
  getDescription(): string {
    return this.ing?.getDescription() + ", Sugar";
  }
}

class ChocolateDecorator extends CoffeeDecorator {
  ing: Ingredient;
  constructor(ing: Ingredient) {
    super();
    this.ing = ing;
  }
  getCost(): number {
    return Number(this.ing?.getCost()) + 4;
  }
  getDescription(): string {
    return this.ing?.getDescription() + ", Chocolate";
  }
}

class WhippedCreamDecorator extends CoffeeDecorator {
  ing: Ingredient;
  constructor(ing: Ingredient) {
    super();
    this.ing = ing;
  }
  getCost(): number {
    return Number(this.ing?.getCost()) + 2.5;
  }
  getDescription(): string {
    return this.ing?.getDescription() + ", Whipped Cream";
  }
}

const coffee: Ingredient = new WhippedCreamDecorator(
  new ChocolateDecorator(
    new SugarDecorator(
      new MilkDecorator(new ChocolateDecorator(new SimpleCoffee()))
    )
  )
);

console.log(coffee.getCost());
console.log(coffee.getDescription());
