import java.util.Arrays;
import java.util.HashMap;

public class combinationSum4_Q377 {

    // Backtracking - TLE
    HashMap<Integer, Integer> hm = new HashMap<>();
    int combinations = 0;
    int digitCount = 0;

    public int combinationSum4_BT(int[] nums, int target) {
        getCombination(nums, target, 0);
        System.out.println(combinations);
        return target;
    }

    private void getCombination(int[] nums, int target, int i) {
        if (i >= nums.length || target < 0) {
            return;
        }

        if (target == 0) {
            System.out.println(hm + " target = " + target + " digitCount = " + digitCount);
            combinations += 1;
            return;
        }

        int count = hm.getOrDefault(nums[i], 0) + 1;
        hm.put(nums[i], count);
        digitCount += 1;
        getCombination(nums, target - nums[i], i);
        count = hm.get(nums[i]) - 1;
        if (count == 0) {
            hm.remove(nums[i]);
        } else {
            hm.put(nums[i], count);
        }
        digitCount -= 1;
        getCombination(nums, target, i+1);
    }


    // Dymanic programming
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        int combinations = getCombinationDP(nums, target);
        System.out.println(Arrays.toString(dp));
        System.out.println(combinations);
        return combinations;
    }

    private int getCombinationDP(int[] nums, int target) {
        if(dp[target] == -1) {
            int res = 0;
            for(int i: nums) {
                if(i <= target) {
                    res += getCombinationDP(nums, target-i);
                }
            }
            dp[target] = res;
        }
        return dp[target];
    }


    public static void main(String[] args) {
        combinationSum4_Q377 cs = new combinationSum4_Q377();
        // int[] nums = { 1, 2, 3 };
        // int target = 4;
        // int[] nums = { 9 };
        // int target = 3;
        int[] nums = { 2,1,3 };
        int target = 35;
        cs.combinationSum4(nums, target);
    }
}
