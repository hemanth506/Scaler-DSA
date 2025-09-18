// class gives TLE for large inputs
class FoodRatings {
  constructor(foods, cuisines, ratings) {
    this.rateMapping = new Map();
    this.foodMapping = new Map();
    const n = foods.length;
    for (let i = 0; i < n; i++) {
      if (!this.rateMapping.has(cuisines[i])) {
        this.rateMapping.set(cuisines[i], new Set());
      }
      this.rateMapping.get(cuisines[i]).add(ratings[i] + "_" + foods[i]);

      if (!this.foodMapping.has(foods[i])) {
        this.foodMapping.set(foods[i], "");
      }
      this.foodMapping.set(foods[i], cuisines[i] + "_" + ratings[i]);
    }
  }
  changeRating(food, newRating) {
    const [cuisine, currentRating] = this.foodMapping.get(food).split("_");
    this.rateMapping.get(cuisine).delete(currentRating + "_" + food);
    this.rateMapping.get(cuisine).add(newRating + "_" + food);
    this.foodMapping.set(food, cuisine + "_" + newRating);
  }

  highestRated = function (cuisine) {
    const foods = [...this.rateMapping.get(cuisine)].sort((a, b) => {
      const [ratingA, foodA] = a.split("_");
      const [ratingB, foodB] = b.split("_");

      if (ratingA === ratingB) {
        return foodA.localeCompare(foodB);
      }

      return ratingB - ratingA;
    });
    return foods[0].split("_")[1];
  };
}



const fr = new FoodRatings(
  ["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"],
  ["korean", "japanese", "japanese", "greek", "japanese", "korean"],
  [9, 12, 8, 15, 14, 7]
);
console.log(fr.highestRated("korean"));
console.log(fr.highestRated("japanese"));
fr.changeRating("sushi", 16);
console.log(fr.highestRated("japanese"));
fr.changeRating("ramen", 16);
console.log(fr.highestRated("japanese"));


/**
 *  todo leet code provides us the default data structure as polyfill (PriorityQueue)
 * 
 var FoodRatings = function (foods, cuisines, ratings) {
    this.cuisines = {};
    this.foods = {};

    for (let i = 0; i < foods.length; i++) {
        const food = foods[i];
        const cuisine = cuisines[i];
        const rating = ratings[i];

        this.foods[food] = { cuisine, rating };

        if (!this.cuisines[cuisine]) this.cuisines[cuisine] = new PriorityQueue((a, b) => {
            if (a[0] !== b[0]) return b[0] - a[0];
            return a[1].localeCompare(b[1]);
        });

        this.cuisines[cuisine].enqueue([rating, food]);
    }
};

FoodRatings.prototype.changeRating = function (food, newRating) {
    const { cuisine } = this.foods[food];
    this.foods[food].rating = newRating;
    this.cuisines[cuisine].enqueue([newRating, food]);
};

FoodRatings.prototype.highestRated = function (cuisine) {
    const heap = this.cuisines[cuisine];

    while (!heap.isEmpty()) {
        const [rating, name] = heap.front();

        if (this.foods[name].rating === rating) {
            return name;
        } else {
            heap.dequeue();
        }
    }
};
 */