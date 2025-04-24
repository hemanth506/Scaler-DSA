import {
  CHCheese,
  CHDough,
  Cheese,
  CHSauce,
  Dough,
  NYCheese,
  NYDough,
  NYSauce,
  Sauce,
} from "./Components";


interface IPizzaStore {
  prepare(): void;
  bake(): void;
  cut(): void;
  box(): void;
  getPizzaIngredientFactory(): IPizzaIngredientFactory;
}

class PizzaStore implements IPizzaStore {
  city: string;
  constructor(city: string) {
    this.city = city;
  }
  prepare(): void {
    console.log("Preparing...");
  }
  bake(): void {
    console.log("Baking...");
  }
  cut(): void {
    console.log("Cutting...");
  }
  box(): void {
    console.log("Packing...");
  }
  getPizzaIngredientFactory(): IPizzaIngredientFactory {
    return PizzaIngredientFactory.pickCityIngredient(this.city);
  }
}

// Practical Factory
class PizzaIngredientFactory {
  public static pickCityIngredient(city: string) {
    switch (city.toLowerCase()) {
      case "new-york":
        return new NewYorkPizzaIngredientFactory();
      case "chicago":
        return new ChicagoPizzaIngredientFactory();
      default:
        throw new Error(`No pizza Ingredient store found for city: ${city}`);
    }
  }
}

/* 
Abstract factory -> IPizzaIngredientFactory
    It is a collection of factory methods
*/
interface IPizzaIngredientFactory {
  createDough(): Dough; // factory method
  createSauce(): Sauce; // factory method
  createCheese(): Cheese; // factory method
}

class NewYorkPizzaIngredientFactory implements IPizzaIngredientFactory {
  createDough(): Dough {
    return new NYDough();
  }
  createSauce(): Sauce {
    return new NYSauce();
  }
  createCheese(): Cheese {
    return new NYCheese();
  }
}

class ChicagoPizzaIngredientFactory implements IPizzaIngredientFactory {
  createDough(): Dough {
    return new CHDough();
  }
  createSauce(): Sauce {
    return new CHSauce();
  }
  createCheese(): Cheese {
    return new CHCheese();
  }
}

const nyPizza = new PizzaStore("new-york");
console.log(nyPizza.getPizzaIngredientFactory().createCheese().getOrigin());
nyPizza.bake()

const chPizza = new PizzaStore("chicago");
console.log(chPizza.getPizzaIngredientFactory().createCheese().getOrigin());
chPizza.prepare()
