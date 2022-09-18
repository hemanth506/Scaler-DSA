import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class distinctPrime {
    // ========================================================
    // my code 
    public int factors(int A) {
        int ct = 0;
        for (int i = 1; i * i <= A; i++) {
            if (A % i == 0) {
                if (A / i == i) {
                    ct += 1;
                } else {
                    ct += 2;
                }
            }
        }
        return ct;
    }

    public HashSet<Integer> lcmVal(HashSet<Integer> hs, int A) {
        outerWhile: while (A != 1) {
            int prevA = A;
            int currentA = A;
            innerFor: for (int i = 2; i*i <= A; i++) {
                // checks if the "A" already exist in hashset.
                if (hs.contains(A)) {
                    break outerWhile;
                }
                // checks if "A" is itself a prime number, if yes, break and add "A" to hashset.
                else if (factors(A) == 2) {
                    hs.add(A);
                    break outerWhile;
                }

                if (A % i == 0) {
                    A = A / i;
                    // System.out.println(A);
                    hs.add(i);
                    currentA = A;
                    break innerFor;
                }
            }

            // If the "A" is not divisible within any of the numbers from 2 to A/2, then it is a prime number.
            if (prevA == currentA) {
                hs.add(A);
                break outerWhile;
            }
            // System.out.println(A);
        }
        return hs;
    }

    public int solveTLE(ArrayList<Integer> A) {
        int N = A.size();
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < N; i++) {
            // if the number of factors are just 2, then it is prime, so adding that directly in the SET. If it is not a prime
            if (!hs.contains(A.get(i)) && factors(A.get(i)) == 2) {
                hs.add(A.get(i));
            } else {
                lcmVal(hs, A.get(i));
            }
        }
        System.out.println(hs.size());
        return hs.size();
    }

    // ========================================================

    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < N; i++) {
            int val = A.get(i);
            for(int div = 2; div*div <= val; div++) {
                if(val % div == 0) {
                    hs.add(div);
                }
                while (val%div == 0) {
                    val = val/div;
                }
            }
            if(val > 1) {
                hs.add(val);
            }
        }
        System.out.println(hs.size());
        return hs.size();
    }
    
    public static void main(String[] args) {
        distinctPrime dp = new distinctPrime();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(96, 98, 5, 41, 80));

        dp.solveTLE(A);
        dp.solve(A);
    }
}
