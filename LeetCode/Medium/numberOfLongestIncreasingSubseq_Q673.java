import java.util.ArrayList;
import java.util.HashMap;
import Medium.Pair;;

public class numberOfLongestIncreasingSubseq_Q673 {

    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        if (N == 1) {
            return 1;
        }

        int maxLen = Integer.MIN_VALUE;
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int curVal = nums[i];
            int dpVal = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (curVal > nums[j]) {
                    dpVal = Integer.max(dpVal, dp[j]);
                }
            }
            if (dpVal == Integer.MIN_VALUE) {
                dpVal = 0;
            }
            dp[i] = dpVal + 1;
            maxLen = Integer.max(maxLen, dp[i]);
        }

        HashMap<Integer, ArrayList<Pair>> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            ArrayList<Pair> currentLenArr;
            if (hm.containsKey(dp[i])) {
                currentLenArr = hm.get(dp[i]);
            } else {
                currentLenArr = new ArrayList<Pair>();
            }

            // This condition is only for length = 1
            if (!hm.containsKey(dp[i] - 1)) {
                Pair pr = new Pair(nums[i], 1);
                currentLenArr.add(pr);
            } else {
                ArrayList<Pair> previousLenArr = hm.get(dp[i] - 1);
                int len = previousLenArr.size();
                int ct = 0;
                for (int j = 0; j < len; j++) {
                    if (nums[i] > previousLenArr.get(j).key) {
                        ct += previousLenArr.get(j).value;
                    }
                }
                Pair pr = new Pair(nums[i], ct);
                currentLenArr.add(pr);
            }
            hm.put(dp[i], currentLenArr);
        }

        // System.out.println(hm);

        ArrayList<Pair> maxLenArr = hm.get(maxLen);
        int k = maxLenArr.size();
        int totalCt = 0;
        for (int i = 0; i < k; i++) {
            totalCt += maxLenArr.get(i).value;
        }
        System.out.println(totalCt);

        return totalCt;
    }

    public static void main(String[] args) {
        numberOfLongestIncreasingSubseq_Q673 nb = new numberOfLongestIncreasingSubseq_Q673();
        // int[] nums = { 1, 3, 5, 4, 7 };
        // int[] nums = { 2, 2, 2, 2, 2 };
        // int[] nums = { 1, 2, 4, 3, 5, 4, 7, 2 };
        int[] nums = { 84, -48, -33, -34, -52, 72, 75, -12, 72, -45 };
        nb.findNumberOfLIS(nums);
    }
}