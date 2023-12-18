import java.util.PriorityQueue;

public class MaxProductAfterKIncrement {
  public int maximumProduct(int[] nums, int k) {
    int N = nums.length;
    long mod = 1000000007;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // O(N)
    for(int i = 0; i < N; i++) { // O(NlogN)
      minHeap.add(nums[i]);
    }

    for(int i = 0; i < k; i++) { // O(2 * KlogK)
      int val = minHeap.poll();
      minHeap.add(val+1);
    }

    long product = 1;
    while(!minHeap.isEmpty()) {
      product = (product%mod * minHeap.poll()%mod)%mod;
    }
    System.out.println(product);
    return (int)product;
  }
  public static void main(String[] args) {
    MaxProductAfterKIncrement mk = new MaxProductAfterKIncrement();
    // int[] nums = {6,3,3,2};
    // int k = 2;

    int[] nums = {0,4};
    int k = 5;
    mk.maximumProduct(nums, k);
  }
}
