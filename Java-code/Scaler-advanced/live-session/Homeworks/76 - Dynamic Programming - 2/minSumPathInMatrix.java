import java.util.ArrayList;
import java.util.Arrays;

public class minSumPathInMatrix {

    public int getMinSum(ArrayList<ArrayList<Integer>> A, int N, int M, int i, int j, int[][] dp) {
        if(i == N-1 && j == M-1) {
            return A.get(i).get(j);
        }
        
        if (i >= N || j >= M) {
            System.out.println(i + " " + j + " return");
            return Integer.MAX_VALUE;
        }
        
        System.out.println(i + " " + j);
        if (dp[i][j] == 1001) {
            int curVal = A.get(i).get(j);
            int rightMin = getMinSum(A, N, M, i, j + 1, dp);
            int downMin = getMinSum(A, N, M, i + 1, j, dp);
            int val = curVal + Integer.min(rightMin, downMin);

            System.out.println(i + " " + j + " val = " + A.get(i).get(j) + " rightMin = " + rightMin + " downMin = " + downMin);
            dp[i][j] = val;
        }

        return dp[i][j];
    }

    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();

        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j] = 1001;
            }
        }
        int minSum = getMinSum(A, N, M, 0, 0, dp);
        System.out.println(Arrays.deepToString(dp));

        System.out.println(minSum);

        return 0;
    }

    

    public static void main(String[] args) {
        minSumPathInMatrix mp = new minSumPathInMatrix();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(new ArrayList<Integer>(Arrays.asList(1, 3, 2)));
        A.add(new ArrayList<Integer>(Arrays.asList(4, 3, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(5, 6, 1)));

        // A.add(new ArrayList<Integer>(Arrays.asList(1, -3, 2)));
        // A.add(new ArrayList<Integer>(Arrays.asList(2, 5, 10)));
        // A.add(new ArrayList<Integer>(Arrays.asList(5, -5, 1)));

        mp.minPathSum(A);
    }
}