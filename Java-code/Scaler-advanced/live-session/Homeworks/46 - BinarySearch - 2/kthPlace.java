import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kthPlace {
    public int solve(final List<Integer> A, int B) {
        int N = A.size();
        int maxElt = Integer.MIN_VALUE;
        int minElt = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            maxElt = Integer.max(maxElt, A.get(i));
            minElt = Integer.min(minElt, A.get(i));
        }
        System.out.println(" === " + maxElt + " " + minElt + " === ");

        int l = minElt;
        int h = maxElt;
        int value = 0;
        while (l <= h) {
            int m = (l + h) / 2;
            int ans = counter(A, m);
            System.out.println(ans + " " + B + " " + m);
            if (ans < B) {
                System.out.println("lessthan l = " + l + " h = " + h + " m = " + m);
                l = m + 1;
            } else if (ans >= B) {
                System.out.println("greatThan l = " + l + " h = " + h + " m = " + m);
                h = m - 1;
                value = m;
            }
        }
        System.out.println(value);
        return value;
    }

    public int counter(List<Integer> A, int M) {
        int N = A.size();
        int ct = 0;
        for(int i = 0; i < N; i++) {
            if (A.get(i) <= M) {
                ct++;
            }
        }
        return ct;
    }
    public static void main(String[] args) {
        kthPlace kp = new kthPlace();
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 1, 4, 3, 2));
        // int B = 3;

        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92));
        // int B = 9;

        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(74, 90, 85, 58, 69, 77, 90, 85, 18, 36));
        // int B = 1;


        List<Integer> A = new ArrayList<Integer>(Arrays.asList(60, 94, 63, 3, 86, 40, 93, 36, 56, 48, 17, 10, 23, 43, 77, 1, 1, 93, 79, 4, 10, 47, 1, 99, 91, 53, 99, 18, 52, 61, 84, 10, 13, 52, 3, 9, 78, 16, 7, 62));
        int B = 22;

        kp.solve(A, B);
    }
}
