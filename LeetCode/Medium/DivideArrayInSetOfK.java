import java.util.HashMap;
import java.util.PriorityQueue;

class Pair {
  int number;
  int freq;

  Pair(int x, int y) {
    this.number = x;
    this.freq = y;
  }
}

public class DivideArrayInSetOfK {
  public boolean isPossibleDivide(int[] nums, int k) {
    int N = nums.length;
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < N; i++) {
      int curVal = hm.getOrDefault(nums[i], 0) + 1;
      hm.put(nums[i], curVal);
    }

    System.out.println(hm);

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int number : hm.keySet()) {
      minHeap.add(number);
    }

    while (!minHeap.isEmpty()) {
      int minNumber = minHeap.poll();
      int curMin = minNumber;
      System.out.println("curMin = " + curMin);

      if (hm.containsKey(curMin) && hm.get(curMin) > 0) {
        for (int i = 0; i < k; i++) {
          int curval = curMin + i;
          System.out.println("curval = " + curval + " hm = " + hm);
          if (hm.containsKey(curval) && hm.get(curval) > 0) {
            int curFreq = hm.get(curval) - 1;
            if (curFreq > 0) {
              hm.put(curval, curFreq);
            } else {
              hm.remove(curval);
            }
          } else {
            System.out.println(false);
            return false;
          }
        }
      }

      if (hm.containsKey(curMin)) {
        minHeap.add(curMin);
      }

    }

    System.out.println(true);
    return true;
  }

  public static void main(String[] args) {
    DivideArrayInSetOfK da = new DivideArrayInSetOfK();
    // int[] nums = { 3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11 };
    // int k = 3;

    // int[] nums = { 1,2,3,4 };
    // int k = 3;


    int[] nums = { 1,5,6 };
    int k = 4;
    da.isPossibleDivide(nums, k);
  }
}
