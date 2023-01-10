import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bestTimeToBuyAndSellStock1 {
    public int maxProfit(final List<Integer> A) {
        int N = A.size();
        if(N == 0) {
            return 0;
        }
        int[] dp = new int[N];
        int maxV = Integer.MIN_VALUE;
        for(int i = N-1; i >= 0; i--) {
            maxV = Integer.max(maxV, A.get(i));
            dp[i] = maxV;
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(A);
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            maxProfit = Integer.max(maxProfit, dp[i]-A.get(i));
        }
        System.out.println(maxProfit);
        return maxProfit;
    }
    public static void main(String[] args) {
        bestTimeToBuyAndSellStock1 bst1 = new bestTimeToBuyAndSellStock1();
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 4, 5, 2, 4));
        List<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2));

        bst1.maxProfit(A);
    }
}
