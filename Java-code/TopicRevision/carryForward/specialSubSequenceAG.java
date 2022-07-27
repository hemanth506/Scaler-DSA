/*
 * 
 * NOTE: Return the answer modulo 10^9 + 7 as the answer can be very large.
 * 
 */


import java.util.Arrays;

public class specialSubSequenceAG {
    public int solve(String A) {
        char[] arrA = A.toCharArray();
        System.out.println(Arrays.toString(arrA));
        int N = arrA.length;
        int modulo = (int) Math.pow(10, 9) + 7;

        int ct = 0;
        int total = 0;
        for (int i = 0; i < N;i++) {
            if(arrA[i] == 'A') {
                ct += 1;
            } else if (arrA[i] == 'G') {
                total = (total + ct) % modulo;
            }
        }
        System.out.println(total);
        return total;
    }
    public static void main(String[] args) {
        specialSubSequenceAG ag = new specialSubSequenceAG();
        String A = "ADGAGAGFG";
        ag.solve(A);

    }
}
