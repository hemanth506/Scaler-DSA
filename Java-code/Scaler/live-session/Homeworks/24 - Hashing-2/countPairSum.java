import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class countPairSum {
    public int solveBruteForce(ArrayList<Integer> A, int B) {
        int N = A.size();
        int ct = 0;
        for (int i = 0; i < N; i++) {
            for(int j = i+ 1; j < N;j++) {
                if(A.get(i) + A.get(j) == B) {
                    ct += 1;
                }
            }
        }
        System.out.println(ct);
        return ct;
    }

    public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        int ct = 0;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int a = A.get(i); 
            int b = B - a;
            if (hs.containsKey(b)) {
                ct += hs.get(b);
            }
            if (hs.containsKey(a)) {
                int val = hs.get(a) + 1;
                hs.put(a, val);
            } else {
                hs.put(a, 1);
            }
        }
        System.out.println(ct);
        return ct;
    }

    public static void main(String[] args) {
        countPairSum cp = new countPairSum();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 5, 1, 2));
        // int B = 8;

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 1, 2)); 
        // int B = 3; 
        // Ans => 4 (1, 2), (1, 4), (2, 3) and (3, 4)

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1, 16, 16, 7, 7, 16, 4, 19)); // 
        // int B = 5;

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(11, 19, 11, 9, 1, 2, 1, 1)); // 0
        int B = 2;
        cp.solve(A, B);
    }
}
