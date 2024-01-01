public class MakeArrayZero {
  public int minimumOperations(int[] nums) {
    int minVal = Integer.MAX_VALUE;
    int N = nums.length;

    boolean hasNonZero = false;
    int ct = 0;
    while (!hasNonZero) {
      minVal = Integer.MAX_VALUE;
      hasNonZero = true;
      for (int i = 0; i < N; i++) {
        if (nums[i] != 0) {
          minVal = Integer.min(minVal, nums[i]);
          hasNonZero = false;
        }
      }

      for (int i = 0; i < N; i++) {
        if (nums[i] != 0) {
          nums[i] = nums[i] - minVal;
        }
      }
      ct++;
    }

    if (ct != 0) {
      ct -= 1;
    }
    System.out.println(ct);
    return ct;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 5, 0, 3, 5 };
    MakeArrayZero ma = new MakeArrayZero();
    ma.minimumOperations(nums);
  }
}
