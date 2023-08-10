import java.util.Arrays;

class findTheValueOfThePartition_Q2740 {
    public int findValueOfPartition(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);

        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < N-1; i++) {
            minVal = Math.min(minVal, nums[i+1] - nums[i]);
        }
        System.out.println(minVal);
        return minVal;   
    }
    public static void main(String[] args) {
        findTheValueOfThePartition_Q2740 ft = new findTheValueOfThePartition_Q2740();
        int[] nums = {100,1};
        ft.findValueOfPartition(nums);
    }
}