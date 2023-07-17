import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class convertAnArrayInto2DArray_Q2610 {

    public List<List<Integer>> findMatrix(int[] nums) {
        int N = nums.length;

        List<List<Integer>> finalList = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < N; i++) {
            int index = hm.getOrDefault(nums[i], -1);
            index += 1;
            hm.put(nums[i], index);
            if(finalList.size() >= index+1) {
                finalList.get(index).add(nums[i]);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(nums[i]);
                finalList.add(newList);
            }
        }
        System.out.println(finalList);
        return finalList;
    }

    public static void main(String[] args) {
        convertAnArrayInto2DArray_Q2610 ca = new convertAnArrayInto2DArray_Q2610();
        // int[] nums = { 1, 3, 4, 1, 2, 3, 1 };
        int[] nums = { 1,2,3,4 };

        ca.findMatrix(nums);
    }
}
