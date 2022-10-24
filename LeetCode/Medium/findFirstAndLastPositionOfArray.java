public class findFirstAndLastPositionOfArray {
    public int[] searchRange(int[] nums, int target) {
        int N = nums.length;
        int l = 0; int h = N - 1;
        int start = -1;
        while (l <= h) {
            int m = (l + h) / 2;
            if(nums[m] == target) {
                start = m;
            }
            if(nums[m] >= target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        System.out.println("start = " + start);


        l = 0; h = N - 1;
        int end = -1;
        while (l <= h) {
            int m = (l + h) / 2;
            if(nums[m] == target) {
                end = m;
            }
            if(nums[m] <= target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        System.out.println("end = " + end);

        int[] result = new int[2];
        result[0] = start;
        result[1] = end;

        return result;
    }

    public static void main(String[] args) {
        findFirstAndLastPositionOfArray ff = new findFirstAndLastPositionOfArray();
        int[] nums = {5,7,7,8,8,8,10};
        int target = 6;

        // int[] nums = {};
        // int target = 8;
        ff.searchRange(nums, target);
    }
}
