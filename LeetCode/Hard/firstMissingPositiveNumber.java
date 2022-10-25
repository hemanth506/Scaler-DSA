import java.util.Arrays;

public class firstMissingPositiveNumber {
    public void swap(int[] nums, int id1, int id2) {
        int temp = nums[id1];
        nums[id1] = nums[id2];
        nums[id2] = temp;
    }
    public int firstMissingPositive(int[] nums) {
        int N = nums.length;
        for(int i = 0; i < N; i++) {
            if(nums[i]-1 < N && (nums[i]-1) != i && nums[i] > 0 &&  nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
                i--;
            }
        }
        System.out.println(Arrays.toString(nums));

        int i;
        for(i = 0; i < N; i++) {
            if(i != (nums[i]-1)) {
                int val = i+1;
                System.out.println(val);
                return val;
            }
        }
        int val = i+1;
        System.out.println(val);
        return val;
    }
    public static void main(String[] args) {
        firstMissingPositiveNumber fm = new firstMissingPositiveNumber();
        // int[] nums = {3,4,8,1,6,5,2,7};
        // int[] nums = {7,8,9,11,12};
        int[] nums = {2};


        fm.firstMissingPositive(nums);
    }
}
