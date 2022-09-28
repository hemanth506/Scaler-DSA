import java.util.ArrayList;
import java.util.Arrays;

public class peakElement {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        if (N == 1) {
            return A.get(0);
        }
        if (A.get(0) > A.get(1)) {
            return A.get(0);
        } else if(A.get(N - 1) > A.get(N - 2)) {
            return A.get(N-1);
        }

        int l = 1;
        int h = N - 2;
        while (l <= h) {
            int m = (l + h) / 2;
            System.out.println(m);
            if (A.get(m - 1) < A.get(m) && A.get(m + 1) <= A.get(m)) {
                System.out.println("peak elt => " + A.get(m));
                return A.get(m);
            }

            if(A.get(m - 1) > A.get(m)) {
                h = m - 1;
            } else if (A.get(m + 1) > A.get(m)) {
                l = m + 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        peakElement pe = new peakElement();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 3, 2, 5, 4));
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1000000000, 1000000000));
        pe.solve(A);
    }
}
