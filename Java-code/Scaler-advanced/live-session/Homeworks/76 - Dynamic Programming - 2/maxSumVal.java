import java.util.ArrayList;
import java.util.Arrays;

public class maxSumVal {
    public int solveBF(ArrayList<Integer> A, int B, int C, int D) {
        int N = A.size();
        int maxV = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                for (int k = j; k < N; k++) {
                    int val = (A.get(i) * B) + (A.get(j) * C) + (A.get(k) * D);
                    System.out.println(val);
                    maxV = Integer.max(maxV, val);
                }
            }
        }
        System.out.println(maxV);
        return maxV;
    }

    public int solve(ArrayList<Integer> A, int B, int C, int D) {
        int N = A.size();
        int[] dp = new int[N];
        int maxVal = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            maxVal = Integer.max(maxVal, A.get(i)*B);
            dp[i] = maxVal;
        }
        System.out.println(Arrays.toString(dp));

        int maxVal2 = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            maxVal2 = Integer.max(maxVal2, A.get(i)*C + dp[i]);
            dp[i] = maxVal2;
        }
        System.out.println(Arrays.toString(dp));

        int maxVal3 = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            maxVal3 = Integer.max(maxVal3, A.get(i)*D + dp[i]);
            dp[i] = maxVal3;
        }
        System.out.println(Arrays.toString(dp));
        return dp[N-1];
    }
    
    public static void main(String[] args) {
        maxSumVal ms = new maxSumVal();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 5, -3, 4, -2));
        int B = 2;
        int C = 1;
        int D = -1;

        // ms.solveBF(A, B, C, D);
        ms.solve(A, B, C, D);
    }
}
