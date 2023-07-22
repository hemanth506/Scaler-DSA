import java.util.Arrays;

public class knightProbabilityInChessboard_Q688 {
    double[][][] dp;

    public double knightProbability(int N, int K, int row, int column) {
        if (N == 1) {
            if (K == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        dp = new double[N][N][K + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        double inBoundCt = knightInBoundCount(N, K, row, column);
        System.out.println("inBoundCt = " + inBoundCt);

        double denominator = Math.pow(8, K);
        System.out.println("denominator = " + denominator);

        double probability = (inBoundCt/ denominator);
        System.out.println("probability = " + probability);
        return probability;
    }

    private double knightInBoundCount(int N, int k, int r, int c) {
        if (r >= N || c >= N || r < 0 || c < 0) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }

        // System.out.println(r + "" + c + "" + k);
        if (dp[r][c][k] == -1) {
            double inBoundCt = 0;
            inBoundCt += knightInBoundCount(N, k - 1, r - 1, c - 2);
            inBoundCt += knightInBoundCount(N, k - 1, r - 2, c - 1);
            inBoundCt += knightInBoundCount(N, k - 1, r - 2, c + 1);
            inBoundCt += knightInBoundCount(N, k - 1, r - 1, c + 2);
            inBoundCt += knightInBoundCount(N, k - 1, r + 1, c + 2);
            inBoundCt += knightInBoundCount(N, k - 1, r + 2, c + 1);
            inBoundCt += knightInBoundCount(N, k - 1, r + 2, c - 1);
            inBoundCt += knightInBoundCount(N, k - 1, r + 1, c - 2);
            dp[r][c][k] = inBoundCt;
        }
        return dp[r][c][k];
    }

    public static void main(String[] args) {
        knightProbabilityInChessboard_Q688 kn = new knightProbabilityInChessboard_Q688();
        int N = 3;
        int K = 2;
        int row = 0;
        int column = 0;
        kn.knightProbability(N, K, row, column);
    }
}