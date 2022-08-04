import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class firstRepeatingElt {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < N; i++) {
            if (hm.containsKey(A.get(i))) {
                int value = hm.get(A.get(i)) + 1;
                // System.out.println("Not First time => " + A.get(i) + " " + value);                
                hm.put(A.get(i), value);
            } else {
                hm.put(A.get(i), 1);
                // System.out.println("First time => " + A.get(i) + " " + 1);
            }
        }

        for (int j = 0; j < N; j++) {
            if (hm.get(A.get(j)) != 1) {
                return A.get(j);
            }
        }
        
        return -1;
    }
    public static void main(String args[]) {
        firstRepeatingElt first = new firstRepeatingElt();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(10, 5, 3, 4, 3, 5, 6));
        System.out.println(first.solve(A));
    }
}
