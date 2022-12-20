import java.util.Arrays;

public class minNumberOfSquares {
    public int countSquares(int A, int[] dp) {
        if (A == 0) {
            return 0;
        }
        System.out.println((A+1));
        if(dp[A] == N) {
            for(int i = 1; (i*i) <= A; i++) {
                dp[A] = Integer.min(countSquares(A-(i*i), dp) + 1, dp[A]);
            }
        }
        return dp[A];
    }
    int N = 0;
    public int countMinSquares(int A) {
        int[] dp = new int[A+1];
        Arrays.fill(dp, A+1);
        N = A+1;
        System.out.println(Arrays.toString(dp));
        int res = countSquares(A, dp);
        System.out.println(Arrays.toString(dp));

        System.out.println(res);
        return res;
    }
    public static void main(String[] args) {
        minNumberOfSquares ms = new minNumberOfSquares();
        int A = 6;
        ms.countMinSquares(A);
    }
}
