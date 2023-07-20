import java.util.Arrays;
import java.util.Stack;

public class asteroidCollision_Q735 {
    public int[] asteroidCollision(int[] asteroids) {
        int N = asteroids.length;
        Stack<Integer> stk = new Stack<>();
        stk.add(asteroids[0]);

        for (int i = 1; i < N; i++) {
            int curAsteroid = asteroids[i];
            System.out.println("curAsteroid = " + curAsteroid);

            while (!stk.isEmpty() && curAsteroid < 0 && stk.peek() > 0) {
                int diff = curAsteroid + stk.peek();
                
                if(diff > 0) {
                    curAsteroid = 0;
                } else if (diff < 0) {
                    stk.pop();
                } else {
                    curAsteroid = 0;
                    stk.pop();
                }
            }
            if(curAsteroid != 0) {
                stk.add(curAsteroid);
            }
        }

        int M = stk.size();
        int[] availableAsteroid = new int[M];
        for (int i = M - 1; i >= 0; i--) {
            availableAsteroid[i] = stk.pop();
        }
        System.out.println(Arrays.toString(availableAsteroid));

        return availableAsteroid;
    }

    
    public static void main(String[] args) {
        asteroidCollision_Q735 ac = new asteroidCollision_Q735();
        // int[] asteroids = { 5, 10, -5 };
        // int[] asteroids = { 8,-8 };
        // int[] asteroids = { 10,2,-5 };
        int[] asteroids = { -2, -1, 1, 2 };
        ac.asteroidCollision(asteroids);
    }
}
