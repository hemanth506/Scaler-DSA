import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class threeSum2Ptr {
    public List<List<Integer>> threeSum(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        HashSet<String> hs = new HashSet<>();
        for(int i = 0; i < N; i++) {
            int p1 = i;
            int p2 = i+1;
            int p3 = N-1;
            while (p2 < p3) {
                int sumV = nums[p1] + nums[p2] + nums[p3];
                // System.out.println("nums[p1] = " + nums[p1] + " || nums[p2] = " + nums[p2] + " || nums[p3] = " + nums[p3] + " || sumV = " + sumV);
                String str = nums[p1] + "|" + nums[p2] + "|" + nums[p3];
                if(sumV == 0 && !hs.contains(str)) {
                    arr.add(new ArrayList<Integer>(Arrays.asList(nums[p1],nums[p2],nums[p3])));
                    hs.add(str);
                }

                if(sumV > 0) {
                    p3--;
                } else {
                    p2++;
                }
            }
        }
        // System.out.println(arr);
        return arr;
    }
    public static void main(String[] args) {
        threeSum2Ptr tp = new threeSum2Ptr();
        int[] nums = {-1,0,1,2,-1,-4};
        tp.threeSum(nums);

    }
}
