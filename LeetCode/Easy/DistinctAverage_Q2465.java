import java.util.Arrays;
import java.util.HashSet;

public class DistinctAverage_Q2465 {
  public int distinctAverages(int[] nums) {
    int N = nums.length;
    Arrays.sort(nums);

    int p1 = 0;
    int p2 = N - 1;

    HashSet<Double> hs = new HashSet<>();
    while (p1 < p2) {
      hs.add(((nums[p1] * 1.0 + nums[p2] * 1.0) / 2) * 1.0);
      p1++;
      p2--;
    }

    System.out.println(hs);

    return hs.size();
  }

  public static void main(String[] args) {
    DistinctAverage_Q2465 da = new DistinctAverage_Q2465();
    int[] nums = { 4, 1, 4, 0, 3, 5 };
    da.distinctAverages(nums);
  }
}
