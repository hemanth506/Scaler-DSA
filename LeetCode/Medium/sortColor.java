import java.util.Arrays;

public class sortColor {
    public void sortColors(int[] nums) {
        int N = nums.length;
        int one = 0;
        int two = 0;
        int zero = 0;
        for(int i = 0;i < N; i++) {
            if (nums[i] == 1) {
                one += 1;
            } else if (nums[i] == 2) {
                two += 1;
            } else if (nums[i] == 0) {
                zero += 1;
            }
        }

        for(int i = 0; i < zero; i++) {
            nums[i] = 0;
        }

        for(int i = zero; i < zero + one; i++) {
            nums[i] = 1;
        }

        for(int i = zero+one; i < zero + one + two; i++) {
            nums[i] = 2;
        }

        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        sortColor sc = new sortColor();
        int[] nums = {2,0,2,1,1,0};
        sc.sortColors(nums);
    }
}
