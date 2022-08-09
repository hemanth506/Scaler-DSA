/*
 * If the prefix value is zero then increment count.
 * if the key is alreafy present in the hashmap, increment the count with the value.
 */



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class countSubArraySumEqualZero {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        int[] prefix = new int[N];
        prefix[0] = A.get(0);
        for (int i = 1; i < N; i++) {
            prefix[i] = prefix[i - 1] + A.get(i);
        }
        System.out.println(Arrays.toString(prefix));

        int ct = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (prefix[i] == 0) {
                ct += 1;
            }
            if(hm.containsKey(prefix[i])) {
                ct += hm.get(prefix[i]);
            }

            if (hm.containsKey(prefix[i])) {
                int val = hm.get(prefix[i]) + 1;
                hm.put(prefix[i], val);
            } else {
                hm.put(prefix[i], 1);
            }
        }
        System.out.println(ct);
        return ct%1000000007;
    }
    public static void main(String[] args) {
        countSubArraySumEqualZero ct = new countSubArraySumEqualZero();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, -1, -2, 2));
        ct .solve(A);
    }
}
