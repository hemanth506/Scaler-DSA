import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class countPairDIfference {
    public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (hm.containsKey(A.get(i))) {
                int val = hm.get(A.get(i)) + 1;
                hm.put(A.get(i), val);
            } else {
                hm.put(A.get(i), 1);
            }
        }
        System.out.println(hm);

        int ct = 0;
        for (int i = 0; i < N; i++) {
            int C = A.get(i) - B;
            if (hm.containsKey(C)) {
                ct += hm.get(C);
            }
        }
        System.out.println(ct);
        return ct;
    }
    public static void main(String[] args) {
        countPairDIfference ctd = new countPairDIfference();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 5, 1, 2));
        int B = 4;

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 1, 2, 1, 2, 1, 2, 1, 2));
        // int B = 1;

        // 
        ctd.solve(A, B);
    }
}
