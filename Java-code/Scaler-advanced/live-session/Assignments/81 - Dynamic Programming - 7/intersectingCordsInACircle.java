import java.util.Arrays;

public class intersectingCordsInACircle {
    int mod = 1000000007;
    public int chordCnt(int A) {
        int[] dp = new int[A+1]; 
        Arrays.fill(dp, -1);
        int ct = getCount(A, dp);
        System.out.println(ct);
        return ct;
    }
    
    public int getCount(int i, int[] dp) {
        if(i == 0) {
            return 1;
        }

        if(dp[i] == -1) {
            long ans = 0;
            for(int j = i-1; j >= 0; j--) {
                ans = (ans + ((long)getCount(j, dp)%mod * getCount(i-j-1, dp)%mod)%mod)%mod;
            }
            dp[i] = (int)ans;

        }

        return dp[i];
    }
    public static void main(String[] args) {
        intersectingCordsInACircle ic = new intersectingCordsInACircle();
        int A = 4;
        ic.chordCnt(A);
    }
}
