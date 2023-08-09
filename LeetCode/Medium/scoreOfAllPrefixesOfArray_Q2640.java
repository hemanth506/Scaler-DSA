import java.util.Arrays;

public class scoreOfAllPrefixesOfArray_Q2640 {
    public long[] findPrefixScore(int[] nums) {
        int N = nums.length;

        long maxV = nums[0];
        long convArr = 0;
        long[] resArr = new long[N];
        for (int i = 0; i < N; i++) {
            maxV = Math.max(maxV, nums[i]);
            convArr += nums[i] + maxV;
            resArr[i] = convArr;
        }
        System.out.println(Arrays.toString(resArr));
        return resArr;
    }

    public static void main(String[] args) {
        scoreOfAllPrefixesOfArray_Q2640 sr = new scoreOfAllPrefixesOfArray_Q2640();
        // int[] nums = { 2, 3, 7, 5, 10 };
        int[] nums = { 1, 1, 2, 4, 8, 16 };
        sr.findPrefixScore(nums);
    }
}
