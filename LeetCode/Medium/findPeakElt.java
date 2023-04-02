public class findPeakElt {
    public int findPeakElement(int[] nums) {
        int N = nums.length;

        if(nums[0] > nums[1]) {
            return 0;
        }

        if (nums[N-1] > nums[N-2]) {
            return N-1;
        }

        int l = 1;
        int h = N-2;
        int ind = 1;
        while (l <= h) {
            int m = (l+h)/2;

            if(nums[m] > nums[m-1] && nums[m] > nums[m+1]) {
                ind = m;
                break;
            }

            if(nums[m] > nums[m-1] && nums[m] < nums[m+1]) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        System.out.println(ind);
        return ind;
    }

    public static void main(String[] args) {
        findPeakElt fp = new findPeakElt();
        int[] nums = { 1, 2, 1, 3, 5, 6, 4 };
        fp.findPeakElement(nums);
    }
}
