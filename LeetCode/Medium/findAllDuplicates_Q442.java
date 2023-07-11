import java.util.ArrayList;
import java.util.List;

public class findAllDuplicates_Q442 {
    public List<Integer> findDuplicates(int[] nums) {

        int N = nums.length;
        

        for (int i = 0; i < N; i++) {
            while (nums[i] - 1 != i) {
                if (nums[i] == nums[nums[i] - 1]) {
                    break;
                }
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }

        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            if (nums[i] - 1 != i) {
                arr.add(nums[i]);
            }
        }

        if(arr.size() == 2) {
            int t1 = Integer.min(arr.get(0), arr.get(1));
            int t2 = Integer.max(arr.get(0), arr.get(1));
            arr = new ArrayList<Integer>();
            arr.add(t1);
            arr.add(t2);
        }
        return arr;
    }

    public static void main(String[] args) {
        findAllDuplicates_Q442 fd = new findAllDuplicates_Q442();
        // int[] nums = {4,3,2,7,8,2,3,1};
        int[] nums = { 1, 1, 2 };
        fd.findDuplicates(nums);
    }
}
