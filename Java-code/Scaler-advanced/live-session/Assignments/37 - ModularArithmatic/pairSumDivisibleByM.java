import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class pairSumDivisibleByM {
    public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        int mod = 1000000007;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < N; i++) {
            int val = A.get(i) % B;
            if(hm.containsKey(val)) {
                int item = hm.get(val) + 1;
                hm.put(val, item);
            } else {
                hm.put(val, 1);
            }
        }
        System.out.println(hm);

        // formula used (A[i] * (A[i] - 1)) / 2
        long count = 0;
        if(hm.containsKey(0)) {
            int val = hm.get(0);
            System.out.println(val);
            count += (1L * val * (val - 1) / 2L) % mod;
        }
        System.out.println("=============");

        // formula used (A[i] * (A[i] - 1)) / 2
        if(B % 2 == 0 && hm.containsKey(B/2)) {
            int val = hm.get(B/2);
            count += (1L * val * (val - 1) / 2L) % mod;
            System.out.println(val);
        }
        System.out.println("=============");

        // formula used (N * N)
        for (int i = 1; i <= B / 2; i++) {
            if(hm.containsKey(B - i) && hm.containsKey(i)) {
                if (i != (B-i)) {
                    System.out.println(i + " hemanth Raaj " + (B - i) + " " + (hm.get(i) * hm.get(B - i)));
                    count += (hm.get(i)%mod * hm.get(B - i)%mod)%mod;
                }
            }
        }
        System.out.println(count);
        return (int) (count + mod) % mod;
    }
    public static void main(String[] args) {
        pairSumDivisibleByM pm = new pairSumDivisibleByM();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(29,11,21,17,2,5,4,6,23,13,26,14,18,15,30,35,50,20,40,9));
        // int B = 10;

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        // int B = 2;

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5, 17, 100, 11));
        // int B = 28;

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(93, 9, 46, 79, 56, 24, 10, 26, 9, 93, 31, 93, 75, 7, 4, 80, 19, 67, 49, 84, 62, 100, 17, 40, 35, 84, 14, 81, 99, 31, 100, 66, 70, 2, 11, 84, 60, 89, 13, 57, 47, 60, 59, 60, 42, 67, 89, 29, 85, 83, 42, 47, 66, 80, 88, 85, 83, 82, 16, 23, 21, 55, 26, 2, 21, 92, 85, 26, 46, 3, 7, 95, 50, 22, 84, 52, 57, 44, 4, 23, 25, 55, 41, 49));
        int B = 37;

        pm.solve(A, B);
    }
}
