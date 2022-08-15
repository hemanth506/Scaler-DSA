import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class subArraySumEqualsK {
    public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        int prefix[] = new int[N];
        prefix[0] = A.get(0);
        for (int i = 1; i < N; i++) {
            prefix[i] = prefix[i - 1] + A.get(i);
        }

        System.out.println(Arrays.toString(prefix));
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int ct = 0;
        for(int i = 0; i < N; i++) {
            int a = prefix[i]; 
            int C = a - B;
            if (hm.containsKey(C)) {
                ct += hm.get(C);
            }

            if (hm.containsKey(a)) {
                int value = hm.get(a) + 1;
                hm.put(a, value);
            } else {
                hm.put(a , 1);
            }
        }
        System.out.println(ct);
        return ct;
    }
    public static void main(String[] args) {
        subArraySumEqualsK ek = new subArraySumEqualsK();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-20, -13, 4, 2, 18, -17, 17));
        int B = 11;
        ek.solve(A, B);
    }
}
