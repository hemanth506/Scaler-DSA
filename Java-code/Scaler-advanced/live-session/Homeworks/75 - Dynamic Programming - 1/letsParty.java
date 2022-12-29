import java.util.Arrays;

public class letsParty {
    public int pairCount(int A, int[] dp, int mod) {
        if(A <= 1) {
            return 1;
        }

        if(dp[A] == -1) {
            dp[A] = (pairCount(A-1, dp, mod) + (pairCount(A-2, dp, mod) * (A-1))%mod)%mod;
        }
        return dp[A]%mod;
    }
    public int solve(int A) {
        int[] dp = new int[A+1];
        int mod = 10003;
        Arrays.fill(dp, -1);
        System.out.println(Arrays.toString(dp));
        pairCount(A, dp, mod);
        dp[0] = 0;
        dp[1] = 1;
        int resp = dp[A];
        System.out.println(Arrays.toString(dp) + "  " + resp%mod);
        return resp%mod;
    }
    public static void main(String[] args) {
        letsParty lp = new letsParty();
        int A = 1;
        lp.solve(A);
    }
}
