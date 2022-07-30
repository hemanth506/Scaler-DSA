import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class elementRemoval {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        Collections.sort(A, Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A.get(i) * (i + 1);
        }

        return sum;
    }
    public static void main(String[] args) {
        elementRemoval el = new elementRemoval();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(4,6,2,3));
        el.solve(A);
    }
}
