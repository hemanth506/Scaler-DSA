import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class fourSumInteger {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int N = nums.length;

        HashSet<String> hs = new HashSet<String>();
        List<List<Integer>> finalList = new ArrayList<>();
        for(int k = 0; k < N; k++) {
            for(int i = k+1; i < N; i++) {
                int pk = k;
                int p1 = i;
                int p2 = i+1;
                int p3 = N-1;
                while(p2 < p3) {
                    long total = nums[pk];
                    total += nums[p1];
                    total += nums[p2];
                    total += nums[p3];
                    // System.out.println(total + " " + target);
                    if(total == target) {
                        String str = nums[pk] + "|" + nums[p1] + "|" + nums[p2] + "|" + nums[p3];
                        if(!hs.contains(str)) {
                            List<Integer> newList = new ArrayList<Integer>(Arrays.asList(nums[pk], nums[p1], nums[p2], nums[p3]));
                            finalList.add(newList);
                            hs.add(str);
                        }
                        p2++;
                    } else if (total < target) {
                        p2++;
                    } else if (total > target) {
                        p3--;
                    }
                }
            }
        }

        System.out.println(finalList);
        return finalList;
    }
    public static void main(String[] args) {
        fourSumInteger fs = new fourSumInteger();
        // int[] nums = {1,0,-1,0,-2,2};
        // int target = 0;

        // int[] nums = {2,2,2,2,2};
        // int target = 8;

        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;

        fs.fourSum(nums, target);
    }
}
