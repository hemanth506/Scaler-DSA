import java.util.Arrays;
import java.util.Scanner;

public class fibonacciNumber {
    public static int getFib (int A, int[] dp) {
        if(A <= 2) {
            dp[A] = 1;
            return 1;
        }

        if(dp[A] == -1) {
            dp[A] = getFib(A-1, dp) + getFib(A-2, dp);
        }
        return dp[A];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int[] dp = new int[A+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        getFib(A, dp);
        // System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[A]);
        sc.close();
    }
}
