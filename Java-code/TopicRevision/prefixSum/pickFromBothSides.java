/*
 * First initially pick all the three balls from left side.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class pickFromBothSides {
    public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        int sumVal = 0;
        ArrayList<Integer> prefix = new ArrayList<Integer>();
        prefix.add(0, A.get(0));
        for (int i = 1; i < N; i++) {
            sumVal = prefix.get(i - 1) + A.get(i);
            prefix.add(i, sumVal);
        }

        /*
         * query = [[1,4], [2,7], [3,8], [0,4]]
         * query = [[2,8], ]
         * 
         * prefix = [];
         * prefix[0] = 0;
         * for(i = 1; i< N; i++) {
         *      if (l % 2 != 0) {
         *          prefix[i] = prefix[i-1] + arr[i]; 
         *      } else {
         *          prefix[i] = prefix[i-1];
         *      }
         * }
         * 
         * for (int q = 0; q < 4; q++) {
         *      int l = query[q][0];
         *      int r = query[q][1];
         * 
         *      int value = prefix[r] ;
         *      if (l != 0) {
         *          value -= prefix[l - 1];
         *      }
         * 
         *      print(value);
         * }
         * 
         */

        if (B == N) {
            return prefix.get(N - 1);
        }
        int maxVal = 0;
        for(int k = 0; k < B; k++) {
            maxVal = prefix.get(B - 1);
        }

        System.out.println("total left => " + maxVal);

        int p = B - 1;
        int q = 1;
        int total = 0;
        while(p >= 0 && q <= B ) {
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
            System.out.println("left => " + left + " right => " + right + " total => " + total + " maxVal => " + maxVal);
            p--;
            q++;
        }

        return maxVal;
    }
    public static void main(String[] args) {
        pickFromBothSides pk = new pickFromBothSides();

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5, -2, 3 , 1, 2));
        int B = 3;
        pk.solve(A, B);
    }
}
