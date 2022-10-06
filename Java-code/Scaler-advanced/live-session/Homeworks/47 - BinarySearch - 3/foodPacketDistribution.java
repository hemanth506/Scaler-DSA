import java.util.ArrayList;
import java.util.Arrays;

public class foodPacketDistribution {
    public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        int minV = Integer.MAX_VALUE;
        long sumV = 0;
        for(int i = 0; i<N; i++) {
            minV = Integer.min(minV, A.get(i));
            sumV += A.get(i);
        }
        System.out.println(minV + " " + sumV);

        if (sumV < B) {
            System.out.println("Gives food to people = " + 0);
            return 0;
        } else if (N > B) {
            System.out.println("Gives food to people = " + minV);
            return minV;
        }

        int l = 1;
        int h = minV;
        int ans = 0;
        while (l <= h) {
            int m = (l + h) / 2;
            Boolean checkVal = check(A, B, m);
            if (checkVal) {
                ans = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        System.out.println("ans = " + ans);
        return ans;
    }

    public boolean check (ArrayList<Integer> A, int B, int M) {
        int offices = 0;
        int N = A.size();
        for(int i = 0; i < N; i++) {
            offices += (A.get(i) / M);
            System.out.println("offices = " + offices);
        }

        if (offices >= B) {
            return true;
        } else {
            return false;
        }
    }

    
    public static void main(String[] args) {
        foodPacketDistribution fp = new foodPacketDistribution();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(8,7,15,5,10,10,1,5,3));
        // int B = 17; // ans=1

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,1,1));
        // int B = 4; // ans=0

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 9, 5, 4));
        // int B = 13; // ans=1

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(20,20,30,3,10,25,30));
        int B = 30; // ans=3

        fp.solve(A, B);
    }
}
