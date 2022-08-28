import java.util.Arrays;

public class removeDuplicatesFromSortedArr {
    public int removeDuplicates(int[] nums) {
        int N = nums.length;
        int index = 0;
        int tempI = nums[0];
        nums[index] = tempI;
        index++;
        int i;
        for(i = 1; i < N; i++) {
            if(tempI != nums[i]) {
                nums[index] = nums[i];
                index++;
            }
            tempI = nums[i];
        }
        System.out.println(index + " " + i);
        if (index != i) {
            nums[index] = nums[N-1];
        }
        System.out.println(Arrays.toString(nums) + " " + index);
        return index;
    }

    public static void main(String[] args) {
        removeDuplicatesFromSortedArr rd = new removeDuplicatesFromSortedArr();
        // int[] nums = {0,0,1,1,1,2,2,3,3,4};
        // int[] nums = {1,1,2};
        int[] nums = {1,2};


        rd.removeDuplicates(nums);
    }
}
