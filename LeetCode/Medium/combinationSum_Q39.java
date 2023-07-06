// Solved using Backtracking, but we can solve this in DP as well.

import java.util.ArrayList;
import java.util.List;

public class combinationSum_Q39 {
    List<List<Integer>> resultArr = new ArrayList<>();
    int[] candidates;
    int N;
    public void returnArr(int i, int target, List<Integer> arr) {
        if(target == 0) {
            List<Integer> temp = new ArrayList<>(arr);
            resultArr.add(temp);
            return;
        }

        if (i >= N || target < 0) {
            return;
        }
        // System.out.println(i);
        returnArr(i+1, target, arr);
        arr.add(candidates[i]);
        returnArr(i, target-candidates[i], arr);
        arr.remove(arr.size()-1);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.N = candidates.length;
        this.candidates = candidates;
        List<Integer> arr = new ArrayList<>();
        returnArr(0, target, arr);
        System.out.println(resultArr);
        return resultArr;
    }
    
    public static void main(String[] args) {
        combinationSum_Q39 cs = new combinationSum_Q39();
        int[] candidates = {2,3,6,7};
        int target = 7;
        cs.combinationSum(candidates, target);
    }
}
