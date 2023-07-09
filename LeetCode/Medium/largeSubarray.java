public class largeSubarray {
    public int maxSubArray(int[] nums) {
        int N = nums.length;

        int currMax = nums[0];
        int overAllMax = nums[0]; 
        for(int i = 1; i < N; i++) {
            currMax = Integer.max((currMax + nums[i]), nums[i]);
            overAllMax = Integer.max(overAllMax, currMax);
        }
        System.out.println(overAllMax);
        return overAllMax;
    }
    public static void main(String[] args) {
        largeSubarray ls = new largeSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        ls.maxSubArray(nums);
        

    }
}
