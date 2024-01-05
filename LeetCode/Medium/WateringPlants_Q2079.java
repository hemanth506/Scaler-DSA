public class WateringPlants_Q2079 {
  public int wateringPlants(int[] plants, int capacity) {
    int N = plants.length;
    int initCapacity = capacity;
    int steps = 0;

    for (int i = 0; i < N; i++) {
      if (capacity >= plants[i]) {
        steps++;
        System.out.println("steps = " + steps);
        capacity -= plants[i];
      } else {
        i--;
        capacity = initCapacity;
        int stepsConsumed = ((i + 1) * 2);
        steps += stepsConsumed;
        System.out.println(i + " refill stepsConsumed = " + stepsConsumed + " steps = " + steps);
      }
    }
    System.out.println(steps);
    return steps;
  }

  public static void main(String[] args) {
    WateringPlants_Q2079 wp = new WateringPlants_Q2079();
    // int[] plants = {1,1,1,4,2,3};
    // int capacity = 4;

    // int[] plants = {7,7,7,7,7,7,7};
    // int capacity = 8;

    int[] plants = {2,2,3,3};
    int capacity = 5;
    wp.wateringPlants(plants, capacity);
  }
}
