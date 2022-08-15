import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class subArraySumEqualsK {
    // O(N^3)
    public int solveBruteForce(ArrayList<Integer> A, int B) {
        int N = A.size();
        int ct = 0;
        for (int l = 0; l < N; l++) {
            for (int r = l; r < N; r++) {
                int sum = 0;
                for (int k = l; k <= r; k++) {
                    sum += A.get(k);
                }
                if (sum == B) {
                    System.out.println(l + " " + r);
                    ct += 1;
                }
            }
        }
        System.out.println(ct);
        return ct;
    }

    // O(N^2)
    public int solvePrefixSum(ArrayList<Integer> A, int B) {
        // prefixSum
        int N = A.size();
        System.out.println(N);
        int[] prefix = new int[N];
        prefix[0] = A.get(0);
        for(int i = 1; i < N; i++) {
            prefix[i] = prefix[i - 1] + A.get(i);
        }
        System.out.println(Arrays.toString(prefix));

        int ct = 0;
        for (int l = 0; l <= N; l++) {
            for (int r = l; r < N; r++) {
                if (l == 0) {
                    if (prefix[r] == B) {
                        System.out.println(l + " " + r + " => " + prefix[l] + " => " + B);
                        ct += 1;
                    }
                } else {
                    int value = prefix[r] - prefix[l - 1];
                    if (value == B) {
                        System.out.println(l + " " + r);
                        ct += 1;
                    }
                }
            }
        }
        System.out.println(ct);
        return ct;
    }
    
    // O(N)
    public int solvePrefixSumWithHashMap(ArrayList<Integer> A, int B) {
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
        subArraySumEqualsK sk = new subArraySumEqualsK();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(19, -10, -13, 10, -13, 6, 7, 2, 18, -19, -4));
        // int B = 19;

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-42, -30, -8, 9, 10, -28, 22, -35, -10, -41, -16, 31, 36, -18, 43, -45, 40, -38, -31, -12, -48, 32, 9, 43, 37, 18, -14, -8, 37, -20, -47, -26, -9, -22, -41, 24, -39, 9, 34, 35, -49, -26, -26, -3, -11, -37, 43, -9, 36, 32, 45, 3, 20, 26, 44, 31, 22, 26, -19, 48, 32, 46, 40, -4, 27, 4, -3, -50, -10, -28, 15, 41, -19, -27, -44, -22, 43, 0, 35, -36, 0, 45, -26, -24));
        // int B = -24;
        // sk.solveBruteForce(A, B);

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-42, -30, -8, 9, 10, -28, 22, -35, -10, -41, -16, 31, 36, -18, 43, -45, 40, -38, -31, -12, -48, 32, 9, 43, 37, 18, -14, -8, 37, -20, -47, -26, -9, -22, -41, 24, -39, 9, 34, 35, -49, -26, -26, -3, -11, -37, 43, -9, 36, 32, 45, 3, 20, 26, 44, 31, 22, 26, -19, 48, 32, 46, 40, -4, 27, 4, -3, -50, -10, -28, 15, 41, -19, -27, -44, -22, 43, 0, 35, -36, 0, 45, -26, -24));
        int B = -24;
        sk.solveBruteForce(A, B);

        System.out.println("=======================");
        sk.solvePrefixSumWithHashMap(A, B);
    }
}
