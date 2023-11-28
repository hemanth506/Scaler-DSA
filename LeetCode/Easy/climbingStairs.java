import java.util.Arrays;

public class climbingStairs {
  int dp[];

  public int climbStairsFunction(int n) {
    if (n <= 2) {
      return n;
    }
    if (dp[n] == -1) {
      dp[n] = climbStairsFunction(n - 1) + climbStairsFunction(n - 2);
    }
    return dp[n];
  }

  public int climbStairs(int n) {
    dp = new int[n + 1];
    System.out.println(Arrays.toString(dp));
    Arrays.fill(dp, -1);
    int val = climbStairsFunction(n);
    System.out.println(val);
    return val;
  }

  public static void main(String[] args) {
    climbingStairs cs = new climbingStairs();
    int n = 4;
    cs.climbStairs(n);
  }
}
