import java.util.ArrayList;
import java.util.List;

public class subsetsGenerator {
    public List<List<Integer>> subsets(int[] nums) {
        int N = nums.length;
        List<List<Integer>> finalArr = new ArrayList<List<Integer>>();
        for(int i = 0; i < 1<<N; i++) {
            List<Integer> arr = new ArrayList<Integer>();
            for(int j = 0; j < 31; j++) {
                System.out.println(i + "<<"+j+ " = "+(i>>j));
                if((i>>j & 1) == 1) {
                    arr.add(nums[j]);
                }
            }
            System.out.println(arr);
            finalArr.add(arr);
        }
        System.out.println(finalArr);
        return finalArr;
    }

    public static void main(String[] args) {
        subsetsGenerator ss = new subsetsGenerator();
        // int[] nums = { 1, 2, 3 };
        int[] nums = { 0 };
        ss.subsets(nums);
    }
}
