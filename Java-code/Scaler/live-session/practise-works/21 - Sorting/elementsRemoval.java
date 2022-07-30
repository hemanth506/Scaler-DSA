import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class elementsRemoval {
    // This has 2N iteration => O(N)
    public int addAndsolve(ArrayList<Integer> A) {
        int N = A.size();
        Collections.sort(A);
        System.out.println(A);
        int sum = 0;
        for(int i = 0; i< N; i++) {
            sum += A.get(i);
        }
        int total = sum;
        for (int i = N - 1; i >= 0; i--) {
            total += sum -= A.get(i);
        }

        System.out.println(total);
        return total;
    }

    // this has N iteration => O(N)
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        int total = 0;
        Collections.sort(A, Collections.reverseOrder());
        for (int i = 0; i <N; i++) {
            total += A.get(i) * (i+1);
        }
        System.out.println(total);
        return total;
    }
    public static void main(String[] args) {
        elementsRemoval el = new elementsRemoval();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(4,6,2,3));
        el.addAndsolve(A);
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(4,6,2,3));
        el.solve(B);
    }
}
