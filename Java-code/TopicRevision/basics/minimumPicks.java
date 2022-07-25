import java.util.ArrayList;
import java.util.Arrays;

public class minimumPicks {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        int evenMax = Integer.MIN_VALUE;
        int oddMin = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if(A.get(i) % 2 == 0) {
                if(A.get(i) > evenMax) {
                    evenMax = A.get(i);
                }
            } else {
                if(A.get(i) < oddMin) {
                    oddMin = A.get(i);
                }
            }
        }
        System.out.println(evenMax + " " + oddMin + " " + (evenMax - oddMin));
        return evenMax - oddMin;
    }
    public static void main(String[] args) {
        minimumPicks pk = new minimumPicks();
        // int[] A = {0,2,9};
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(0,2,9));
        pk.solve(A);
    }
}
