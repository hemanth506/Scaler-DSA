import java.util.Arrays;

public class findTheDuplicate {

    private void swap(int[] nums, int i, int ind) {
        int temp = nums[i];
        nums[i] = nums[ind];
        nums[ind] = temp;
    }
    public int findDuplicate(int[] nums) {
        int N = nums.length;
        System.out.println(N);
        int ans = 0;
        for(int i = 0; i < N; i++) {
            if(i != nums[i] - 1) {
                ans = nums[i];
            }
            if(nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i]-1);
                i--;
            }
            
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(ans);

        return ans;
    }

    public static void main(String[] args) {
        findTheDuplicate fd = new findTheDuplicate();
        int[] nums = {6,5,3,4,3,1,2,3,3};
        fd.findDuplicate(nums);
    }
}
