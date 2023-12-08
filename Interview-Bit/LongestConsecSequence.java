import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LongestConsecSequence {
  public int longestConsecutive(final List<Integer> A) {
    int N = A.size();
    HashSet<Integer> hs = new HashSet<>();
    for(int i = 0; i < N; i++) {
      hs.add(A.get(i));
    }

    int maxVal = Integer.MIN_VALUE;
    for(int elt: hs) {
      if(!hs.contains(elt-1)) {
        int val = elt;
        int count = 0;
        while (hs.contains(val)) {
          count += 1;
          val++;
        }
  
        maxVal = Integer.max(count, maxVal);
        System.out.println(count + " " + elt);
      }
    }
    System.out.println(maxVal);
    return maxVal;
  }
  public static void main(String[] args) {
    LongestConsecSequence lq = new LongestConsecSequence();
    List<Integer> A = new ArrayList<>(Arrays.asList(100, 4, 200, 1, 2, 3));
    lq.longestConsecutive(A);
  }
}
