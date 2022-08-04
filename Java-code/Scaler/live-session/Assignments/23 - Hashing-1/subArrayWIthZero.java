import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class subArrayWIthZero {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        long[] prefix = new long[N];
        prefix[0] = A.get(0);
        for (int i = 1; i < N; i++) {
            prefix[i] = prefix[i - 1] + A.get(i);
        }

        System.out.println(Arrays.toString(prefix));

        HashMap<Long, Integer> hm = new HashMap<>();
        for(int i = 0; i < N; i++) {
            if(hm.containsKey(prefix[i])) {
                return 1;
            } else {
                hm.put(prefix[i], 1);
            }

            if (prefix[i] == 0) {
                return 1;
            }
        }

        /* can do this part in HashMap or in HashSet
         *
         *  HashSet<Long> hs = new HashSet<>();
            for(int i = 0; i < N; i++) {
                hs.add(prefix[i]);

                if (prefix[i] == 0) {
                    return 1;
                }
            }
            if (hs.size() < N) {
                return 1;
            }
         */

        return 0;
    }
    public static void main(String[] args) {
        subArrayWIthZero zero = new subArrayWIthZero();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2,2,1,-3,4,3,1,-2,-3,2));    

        zero.solve(A);
    }
}
