import java.util.Arrays;

public class editDistance {
    public int minDistance(String A, String B) {
        int N = A.length();
        int M = B.length();

        int[][] dp = new int[N][M];
        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(Arrays.deepToString(dp));
        int oper = getOperations(A, B, N, M, 0, 0, dp);
        System.out.println(Arrays.deepToString(dp));
        System.out.println(oper);
        return oper;
    }
    public int getOperations(String A, String B, int N, int M, int i, int j, int[][] dp) {
        if(i == N) {
            System.out.println("break in i");
            return M-j;
        }
        if (j == M) {
            System.out.println("break in j");
            return N-i;
        }

        if(dp[i][j] == -1) {
            if(A.charAt(i) == B.charAt(j)) {
                dp[i][j] = getOperations(A, B, N, M, i+1, j+1, dp);
            } else {
                int replace = getOperations(A, B, N, M, i+1, j+1, dp);
                int delete = getOperations(A, B, N, M, i+1, j, dp);
                int insert = getOperations(A, B, N, M, i, j+1, dp);
                int minVal = Integer.min(replace, delete);
                dp[i][j] = 1 + Integer.min(minVal, insert);
            }
        }
        
        return dp[i][j];
    }
    public static void main(String[] args) {
        editDistance ed = new editDistance();
        String A = "Anshuman";
        String B = "Antihuman";
        ed.minDistance(A, B);
    }
}
