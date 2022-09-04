import java.util.ArrayList;
import java.util.Arrays;

// used Prefix sum with 1's and 0's, and then used sliding window with len = noOfOnes
public class minimumSwaps {
    public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        if (N == 1 || N == 0) {
            return 0;
        }

        int lessThanBct = 0;
        for (int i = 0; i < N; i++) {
            if (A.get(i) <= B) {
                A.set(i, 0);
                lessThanBct += 1;
            } else {
                A.set(i, 1);
            }
        }

        if (lessThanBct == 0) {
            return 0;
        }

        for (int i = 1; i < N; i++) {
            A.set(i, A.get(i - 1) + A.get(i));
        }
        System.out.println(A + " " + lessThanBct);

        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < N - lessThanBct + 1; i++) {
            System.out.print("i= " + i + " window => " + (i + lessThanBct - 1)  + " ");
            if (i != 0) {
                System.out.println(A.get(i + lessThanBct - 1) + " - " + A.get(i-1) + " = " + (A.get(i + lessThanBct - 1) - A.get(i-1)));
                minVal = Integer.min(minVal, A.get(i + lessThanBct - 1) - A.get(i - 1));
            } else {
                System.out.println((A.get(i + lessThanBct - 1)));
                minVal = Integer.min(minVal, A.get(i + lessThanBct - 1));
            }
        }

        System.out.println(minVal);

        return minVal;
    }
    public static void main(String[] args) {
        minimumSwaps min = new minimumSwaps();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 12, 10, 3, 14, 10, 5));
        int B = 8;

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5,17,100,95,11,12,13,14,98,17,23,19));
        // int B = 20;
        
        min.solve(A, B);
    }
}
