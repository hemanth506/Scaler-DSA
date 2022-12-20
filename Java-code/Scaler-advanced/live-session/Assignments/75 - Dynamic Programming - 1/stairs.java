import java.util.Arrays;

public class stairs {
    public int steps(int A, int[] dp, int mod) {
        if(A <= 1) {
            return 1;
        }
        if(dp[A] == -1) {
            dp[A] = (steps(A-1, dp, mod) + steps(A-2, dp, mod))%mod;
        }
        return dp[A]%mod;
    }
    public int climbStairs(int A) {
        int[] dp = new int[A+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        int mod = 1000000007;
        int res = steps(A, dp, mod);
        System.out.println(Arrays.toString(dp));
        System.out.println(res);
        return res;
    }
    public static void main(String[] args) {
        stairs st = new stairs();
        int A = 4;
        st.climbStairs(A);
    }
}
