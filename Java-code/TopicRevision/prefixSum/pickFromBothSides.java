/*
 * First initially pick all the three balls from left side.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class pickFromBothSides {
    public int solveOLD(ArrayList<Integer> A, int B) {
        int N = A.size();
        int sumVal = 0;
        ArrayList<Integer> prefix = new ArrayList<Integer>();
        prefix.add(0, A.get(0));
        for (int i = 1; i < N; i++) {
            sumVal = prefix.get(i - 1) + A.get(i);
            prefix.add(i, sumVal);
        }

        if (B == N) {
            return prefix.get(N - 1);
        }
        int maxVal = 0;
        for (int k = 0; k < B; k++) {
            maxVal = prefix.get(B - 1);
        }

        System.out.println("total left => " + maxVal);

        int p = B - 1;
        int q = 1;
        int total = 0;
        while (p >= 0 && q <= B) {
            int left = 0;
            if (p > 0) {
                left = prefix.get(p - 1);
            }

            int right = 0;
            if (q <= B) {
                right = prefix.get(N - 1) - prefix.get(N - q - 1);
            }
            total = left + right;
            if (maxVal < total) {
                maxVal = total;
            }
            System.out.println(p + " " + q);
            System.out
                    .println("left => " + left + " right => " + right + " total => " + total + " maxVal => " + maxVal);
            p--;
            q++;
        }

        return maxVal;
    }

    public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        int prefix[] = new int[N];
        prefix[0] = A.get(0);
        for (int i = 1; i < N; i++) {
            prefix[i] = prefix[i - 1] + A.get(i);
        }

        System.out.println(Arrays.toString(prefix));

        if (B == N) {
            return prefix[N - 1];
        }

        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i <= B; i++) {
            int left = 0;
            if (i != 0) {
                left = prefix[i - 1];
            }

            int right = 0;
            int j = B - i;
            if (j != N - 1) {
                right += prefix[N - 1] - prefix[N - j - 1];
            }
            System.out.println("index i = " + (i-1) + " " + left + " || index j = " + (N - j - 1) + " " + right);

            int val = left + right;
            maxVal = Integer.max(val, maxVal);
        }
        System.out.println(maxVal);

        return maxVal;
    }

    public static void main(String[] args) {
        pickFromBothSides pk = new pickFromBothSides();

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5, -2, 3, 1, 2));
        // int B = 3;

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2,3,-1,4,2,1));
        int B = 4;
        pk.solve(A, B);
    }
}
