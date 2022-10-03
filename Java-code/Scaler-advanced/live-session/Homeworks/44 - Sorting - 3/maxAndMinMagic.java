import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class maxAndMinMagic {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int N = A.size();
        ArrayList<Integer> B = new ArrayList<Integer>();
        int mod = 1000000007;

        int minV = 0;
        for(int i = 0; i < N; i+=2) {
            int val = Math.abs(A.get(i) - A.get(i + 1)) % mod;
            minV += (val % mod);
        }
        // System.out.println(minV);

        int maxV = 0;
        int j = N / 2;
        for(int i = 0; i < N /2; i++) {
            int minusVal = ((A.get(i) % mod) - (A.get(j) % mod)) % mod;
            int val = Math.abs(minusVal) % mod;
            maxV = (maxV % mod) + (val % mod);
            j++;
        }
        // System.out.println(maxV);
        B.add(maxV % mod);
        B.add(minV % mod);
        System.out.println(B);
        return B;
    }
    public static void main(String[] args) {
        maxAndMinMagic mm = new maxAndMinMagic();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(8,12,2,24,-3,13,14,-6));
        mm.solve(A);
    }
}
