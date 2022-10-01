import java.util.ArrayList;
import java.util.Arrays;

public class singleEltInSortedArr {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        if (N == 1) {
            return A.get(0);
        }
        int index1 = A.get(0);
        int index2 = A.get(1);
        int indexN1 = A.get(N - 1);
        int indexN2 = A.get(N - 2);
        if (index1 != index2)  {
            System.out.println("Edge case 1 " + A.get(0));
            return A.get(0);
        } else if (indexN1 != indexN2) {
            System.out.println("Edge case 2 " + A.get(N-1));
            return A.get(N-1);
        }
        int l = 1; 
        int h = N - 2;
        while (l <= h) {
            int m = (l + h) / 2;
            System.out.println("Middle => " + m);
            int AmM1 = A.get(m - 1);
            int Am = A.get(m);
            int AmP1 = A.get(m + 1);
            if(AmM1 != Am && AmP1 != Am) {
                System.out.println("Value " + Am);
                return Am;
            }
            if (AmM1 == Am) {
                m = m - 1;
            }

            if (m % 2 == 0) {
                l = m + 2;
                System.out.println("low => " + l);
            } else {
                h = m - 1;
                System.out.println("high => " + h);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        singleEltInSortedArr sa = new singleEltInSortedArr();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,1,2,2,4,4,6,6,9,10,10,11,11,13,13));

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(13, 13, 21, 21, 27, 50, 50, 102, 102, 108, 108, 110, 110, 117, 117, 120, 120, 123, 123, 124, 124, 132, 132, 164, 164, 166, 166, 190, 190, 200, 200, 212, 212, 217, 217, 225, 225, 238, 238, 261, 261, 276, 276, 347, 347, 348, 348, 386, 386, 394, 394, 405, 405, 426, 426, 435, 435, 474, 474, 493, 493));
        sa.solve(A);
    }
}
