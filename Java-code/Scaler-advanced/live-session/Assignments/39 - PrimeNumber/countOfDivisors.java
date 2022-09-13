import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * when compared with sqrt, log is the optimised one.
 */
public class countOfDivisors {
    public int factors(int A) {
        int ct = 0;
        for(int i = 1; i*i <= A; i++) {
            if(A%i == 0) {
                if (A/i == i) {
                    ct += 1;
                } else {
                    ct += 2;
                }
            }
        }
        return ct;
    }

    // TC: O(NsqrtN)
    public ArrayList<Integer> solve_N_sqrt_N(ArrayList<Integer> A) {
        int N = A.size();
        for(int i = 0; i < N; i++) {
            int val = factors(A.get(i));
            A.set(i, val);
        }
        System.out.println(A);
        return A;
    }

    // TC: O(NlogN)
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int index = A.size();
        int N = Collections.max(A) + 1;
        int[] fact = new int[N+1];
        Arrays.fill(fact, 1);
        System.out.println(Arrays.toString(fact));

        for(int i = 2; i <= N; i++) {
            for(int j = i; j <= N; j+=i) {
                fact[j] += 1;
            }
        }
        System.out.println(Arrays.toString(fact));

        for(int k = 0; k < index; k++) {
            A.set(k, fact[A.get(k)]);
        }
        System.out.println(A);
        return A;
    }
    public static void main(String[] args) {
        countOfDivisors cd = new countOfDivisors();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5));
        cd.solve(A);
    }
}
