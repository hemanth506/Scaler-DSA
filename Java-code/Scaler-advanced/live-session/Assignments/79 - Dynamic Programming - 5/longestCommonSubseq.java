import java.util.Arrays;

public class longestCommonSubseq {
    public int solve(String A, String B) {
        int N = A.length();
        int M = B.length();
        int[][] dp = new int[N][M];
        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(Arrays.deepToString(dp));
        int length = getSubseqLength(A, B, N, M, 0, 0, dp);
        System.out.println("length = " + length);
        return length;
    }
    public int getSubseqLength(String A, String B, int N, int M, int i, int j, int[][] dp) {
        if(i == N || j == M) {
            return 0;
        }

        if(dp[i][j] == -1) {
            if(A.charAt(i) == B.charAt(j)) {
                dp[i][j] = getSubseqLength(A, B, N, M, i+1, j+1, dp) + 1;
            } else {
                int case1 = getSubseqLength(A, B, N, M, i, j+1, dp);
                int case2 = getSubseqLength(A, B, N, M, i+1, j, dp);

                dp[i][j] = Integer.max(case1, case2);
            }
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        longestCommonSubseq lcs = new longestCommonSubseq();
        String A = "abbcdgf";
        String B = "bbadcgf";
        lcs.solve(A, B);
    }
}
