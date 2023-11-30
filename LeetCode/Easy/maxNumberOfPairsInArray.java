import java.util.HashMap;

public class maxNumberOfPairsInArray {

  public int[] numberOfPairs(int[] nums) {
    int N = nums.length;
    HashMap<Integer, Integer> hm = new HashMap<>();

    for (int i = 0; i < N; i++) {
      int freq = hm.getOrDefault(nums[i], 0) + 1;
      hm.put(nums[i], freq);
    }

    int pairs = 0;
    int elt = 0;
    for (HashMap.Entry<Integer, Integer> entry : hm.entrySet()) {
      int val = entry.getValue();
      pairs += val / 2;
      elt += val % 2;
    }

    System.out.println(hm + " " + pairs + " " + elt);
    int[] result = new int[2];
    result[0] = pairs;
    result[1] = elt;

    return result;
  }

  public static void main(String[] args) {
    maxNumberOfPairsInArray mx = new maxNumberOfPairsInArray();
    int[] nums = new int[] { 1, 3, 2, 1, 3, 2, 2 };
    mx.numberOfPairs(nums);
  }
}
