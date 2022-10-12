import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class longestConsecutiveSequence {
    public int longestConsecutive(final List<Integer> A) {
        int N = A.size();
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < N; i++) {
            hs.add(A.get(i));
        }

        int maxLen = Integer.MIN_VALUE;
        for(int uniqueElt : hs) {
            System.out.println("uniqueElt = " + uniqueElt);
            if(!hs.contains(uniqueElt - 1)) {
                int ct = 1; int x = uniqueElt;
                while(hs.contains(x + 1)) {
                    ct += 1;
                    x += 1;
                }
                maxLen = Integer.max(maxLen, ct);
            }
        }
        System.out.println(maxLen);
        return maxLen;
    }
    public static void main(String[] args) {
        longestConsecutiveSequence lc = new longestConsecutiveSequence();
        List<Integer> A = new ArrayList<Integer>(Arrays.asList(100, 4, 200, 1, 3, 2));
        lc.longestConsecutive(A);
    }
}
