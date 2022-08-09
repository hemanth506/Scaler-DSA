import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class longestSubarrayWithSumZero {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        long[] prefix = new long[N];
        prefix[0] = A.get(0);
        for (int i = 1; i < N; i++) {
            prefix[i] = prefix[i - 1] + A.get(i);
        }
        System.out.println(Arrays.toString(prefix));

        long len = 0;
        long currentLen = 0;
        HashMap<Long, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (prefix[i] == 0) {
                currentLen = i + 1;
                if (currentLen > len) {
                    len = currentLen;
                }
            }

            if (hm.containsKey(prefix[i])) {
                long val = hm.get(prefix[i]);
                currentLen = i - val;
                System.out.println("pair exists" + currentLen);
                if (currentLen > len) {
                    len = currentLen;
                    System.out.println("length => " + len);
                }
            } else {
                hm.put(prefix[i], i);
            }
        }

        System.out.println(len);
        return (int) len;
    }
    public static void main(String[] args) {
        longestSubarrayWithSumZero lg = new longestSubarrayWithSumZero();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, -2, 1, 2));
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(9, -20, -11, -8, -4, 2, -12, 14, 1));
        
        lg.solve(A);
    }
}
