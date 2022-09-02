import java.util.ArrayList;
import java.util.Arrays;

public class maximumSubmatrixSum {
    // Don't use Kadane's algorithm - 
    //      Kadane's is used only to find the Max subarray sum.

    // used Suffix sum to solve this problem.
    public Long solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();
        System.out.println(A);

        long[][] d2Prefix = new long[N][M]; 

        for (int i = N-1; i >= 0; i--) {
            d2Prefix[i][M-1] = A.get(i).get(M-1);
            System.out.println(i + " " + (N-1)+ " " + A.get(i).get(N-1));
            for (int j = M-2; j >= 0; j--) {
                d2Prefix[i][j] = A.get(i).get(j) + d2Prefix[i][j+1];
            }
        }

        System.out.println(A);
        System.out.println(Arrays.deepToString(d2Prefix));

        for (int i = M-1; i >= 0; i--) {
            d2Prefix[N-1][i] = d2Prefix[N-1][i];
            for (int j = N-2; j >= 0; j--) {
                d2Prefix[j][i] = d2Prefix[j][i] + d2Prefix[j+1][i];
            }
        }

        System.out.println("==================");
        System.out.println(A);
        System.out.println(Arrays.deepToString(d2Prefix));

        long maxV = Long.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                maxV = Long.max(maxV, d2Prefix[i][j]);
            }
        }
        System.out.println(maxV);

        return maxV;
    }
    
    public static void main(String[] args) {
        maximumSubmatrixSum ms = new maximumSubmatrixSum();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        // A.add(new ArrayList<Integer>(Arrays.asList(-5, -4, -3)));
        // A.add(new ArrayList<Integer>(Arrays.asList(-1, 2, 3)));
        // A.add(new ArrayList<Integer>(Arrays.asList(2, 2, 4)));

        // A.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        // A.add(new ArrayList<Integer>(Arrays.asList(4, 5, 6)));
        // A.add(new ArrayList<Integer>(Arrays.asList(7, 8, 9)));

        // A.add(new ArrayList<Integer>(Arrays.asList(-83, -73, -70, -61)));
        // A.add(new ArrayList<Integer>(Arrays.asList(-56, -48, -13, 4)));
        // A.add(new ArrayList<Integer>(Arrays.asList(38, 48, 71, 71)));

        // A.add(new ArrayList<Integer>(Arrays.asList(-93, 19)));

        A.add(new ArrayList<Integer>(Arrays.asList(-76, -73, -46, -42, -38)));
        A.add(new ArrayList<Integer>(Arrays.asList(-18, -3, 72, 88, 93)));
        ms.solve(A);
    }
}

/*
 * [[-83, -73, -70, -61],
 *  [-56, -48, -13, 4],
 *  [38, 48, 71, 71]]
 * 
[[-226, -143, -70, 0],
 [-117, -61, -13, 0],
  [157, 119, 71, 0]]
 */