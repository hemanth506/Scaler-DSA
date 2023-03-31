import java.util.Arrays;

public class removeElt {
    public int removeElement(int[] nums, int val) {
        int N = nums.length;
        Arrays.sort(nums);
        int freq = 0;
        for (int i = 0; i < N; i++) {
            if (nums[i] == val) {
                freq += 1;
            }
        }

        for (int i = 0; i < N; i++) {
            if (nums[i] == val && (i + freq) < N) {
                swap(nums, i, i + freq);
            }
        }
        System.out.println(freq);
        System.out.println(Arrays.toString(nums));
        return N - freq;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        removeElt re = new removeElt();
        int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int val = 2;
        re.removeElement(nums, val);
    }
}
