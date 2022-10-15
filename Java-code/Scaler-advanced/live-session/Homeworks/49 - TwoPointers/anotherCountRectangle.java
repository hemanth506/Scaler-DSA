import java.util.ArrayList;
import java.util.Arrays;

public class anotherCountRectangle {
    public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        int p1 = 0;
        int p2 = N-1;
        long totalRect = 0;
        int mod = 1000000007;
        while (p1 <= p2) {
            long sumVal = 1L* A.get(p1) * A.get(p2);
            if(sumVal >= B) {
                p2--;
            } else {
                int size = p2-p1+1;
                // Making minus 1 if p1 and p2 are same [ 2X2 and 2X2 are same ]
                totalRect = totalRect%mod + ((1L * 2 * size) - 1);
                p1++;
            }
        }

        // System.out.println(totalRect);
        return (int)(totalRect%mod);
    }
    public static void main(String[] args) {
        anotherCountRectangle ar = new anotherCountRectangle();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,3,5,7,9));
        // int B = 10;

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2));
        // int B = 5;

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 29, 33, 40, 44, 49));
        int B = 72;
        ar.solve(A, B);
    }
}
