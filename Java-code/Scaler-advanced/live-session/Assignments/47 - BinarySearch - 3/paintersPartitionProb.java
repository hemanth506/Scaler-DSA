import java.util.ArrayList;
import java.util.Arrays;

public class paintersPartitionProb {

    public boolean check(ArrayList<Integer> C, int A, int M, int N) {
        int amt = 0;
        int person = 0;
        for(int i = 0; i < N; i++) {
            amt += C.get(i);
            if (amt > M) {
                System.out.println();

                amt = C.get(i);
                person += 1;
                if (person == A) {
                    return false;
                }
            }
            System.out.print(amt + " + ");
        }
        System.out.println();
        return true;
    }

    public int paint(int A, int B, ArrayList<Integer> C) {
        int N = C.size();
        int maxVal = Integer.MIN_VALUE;
        int totalSum = 0;
        int mod = 10000003;
        for (int i = 0; i < N; i++) {
            totalSum += C.get(i);
            maxVal = Integer.max(maxVal, C.get(i));
        }
        System.out.println(totalSum + " " + maxVal);
        int l = maxVal;
        int h = totalSum;
        long ans = 0;
        while (l <= h) {
            int m = (l + h) / 2;
            boolean checkFun = check(C, A, m, N);
            System.out.println("l = " + l + " h = " + h + " m = " + m + " checkFun = " + checkFun);
            System.out.println("===================");
            if (checkFun) {
                ans = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        System.out.println(ans);
        int totalWork = (int) (ans%mod * B%mod) % mod;
        System.out.println(totalWork);
        return totalWork;
    }
    public static void main(String[] args) {
        paintersPartitionProb pp = new paintersPartitionProb();
        // int A = 10;
        // int B = 1;
        // ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(1, 8, 11, 3));

        // int A = 2;
        // int B = 5;
        // ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(1, 10));

        // int A = 3;
        // int B = 10;
        // ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(185, 186, 938, 558, 655, 461, 441, 234, 902, 681));

        int A = 1;
        int B = 1000000;
        ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(1000000, 1000000));
        pp.paint(A, B, C);
    }
}
