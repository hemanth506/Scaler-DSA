import java.util.ArrayList;
import java.util.Arrays;

public class dungeonPrincess {

    public int minimumHP(ArrayList<ArrayList<Integer>> A, int N, int M, int i, int j, int[][] dp) {
        
        if (i >= N || j >= M) {
            return Integer.MAX_VALUE;
        }

        if(i == N-1 && j == M-1) {
            return Integer.max(1, 1- A.get(i).get(j));
        }

        System.out.println(i + " " + j);
        if(dp[i][j] == 101) {
            /* Main equation
             *  H + X = Integer.min(minimumHP(i+1, j), minimumHP(i, j+1));
             */
            int down = minimumHP(A, N, M, i+1, j, dp);
            int left = minimumHP(A, N, M, i, j+1,dp);
            int minVal = Integer.min(down , left) - A.get(i).get(j);
            dp[i][j] = Integer.max(1, minVal);
        }

        return dp[i][j];
    }
    
    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();
        int[][] dp = new int[N][M];
        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], 101);
        }
        int res = minimumHP(A, N, M, 0, 0, dp);
        System.out.println(Arrays.deepToString(dp));
        System.out.println(res);
        return res;
    }
    public static void main(String[] args) {
        dungeonPrincess dp = new dungeonPrincess();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<Integer>(Arrays.asList(-2, -3, 3)));
        A.add(new ArrayList<Integer>(Arrays.asList(-5, -10, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(10, 30, -5)));

        dp.calculateMinimumHP(A);
    }
}
