public class predictTheWinner_Q486 {
    int[][][] dp;

    public boolean PredictTheWinner(int[] nums) {
        int N = nums.length;
        int p2Score = 0;
        for (int i = 0; i < N; i++) {
            p2Score += nums[i];
        }
        dp = new int[N][N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }

        int p1Score = predict(nums, 0, N - 1, 0);
        System.out.println(p1Score);
        p2Score -= p1Score;

        boolean didP1Win = p1Score >= p2Score;
        System.out.println(didP1Win);
        
        return didP1Win;
    }

    private int predict(int[] nums, int i, int j, int turn) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j][turn] == -1) {
            if (turn == 0) {
                int way1 = nums[i] + predict(nums, i + 1, j, 1);
                int way2 = nums[j] + predict(nums, i, j - 1, 1);
                dp[i][j][turn] = Integer.max(way1, way2);
                return dp[i][j][turn];
            } else {
                int way1 = predict(nums, i + 1, j, 0);
                int way2 = predict(nums, i, j - 1, 0);
                dp[i][j][turn] = Integer.min(way1, way2);
                return dp[i][j][turn];
            }
        }
        return dp[i][j][turn];
    }

    public static void main(String[] args) {
        predictTheWinner_Q486 pw = new predictTheWinner_Q486();
        int[] nums = { 1, 5, 233, 7 };
        // int[] nums = {1,5,2};

        pw.PredictTheWinner(nums);
    }
}
