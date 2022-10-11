import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class array3Pointers {
    public int maxAbs (int pA, int pB, int pC, List<Integer> A, List<Integer> B, List<Integer> C) {
        int absOne = Math.abs(A.get(pA) - B.get(pB));
        int absTwo = Math.abs(B.get(pB) - C.get(pC));
        int absThree = Math.abs(C.get(pC) - A.get(pA));
        int maxVal = Integer.MIN_VALUE;
        maxVal = Integer.max(maxVal, absOne);
        maxVal = Integer.max(maxVal, absTwo);
        maxVal = Integer.max(maxVal, absThree);
        return maxVal;
    }
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int NA = A.size(); int NB = B.size(); int NC = C.size();
        int p1 = 0; int p2 = 0; int p3 = 0;

        int minVal = Integer.MAX_VALUE;
        while (p1 < NA && p2 < NB && p3 < NC) {
            int maxAbsResult = maxAbs(p1, p2, p3, A, B, C);
            minVal = Integer.min(minVal, maxAbsResult);

            if(A.get(p1) >= C.get(p3) && B.get(p2) >= C.get(p3)) {
                p3++;
                System.out.println("p3");
            } else if (A.get(p1) >= B.get(p2) && C.get(p3) >= B.get(p2)) {
                p2++;
                System.out.println("p2");
            } else {
                p1++;
                System.out.println("p1");
            }
        }
        System.out.println(minVal);
        return minVal;
    }
    public static void main(String[] args) {
        array3Pointers ar = new array3Pointers();
        List<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 4, 10));
        List<Integer> B = new ArrayList<Integer>(Arrays.asList(2, 15, 20));
        List<Integer> C = new ArrayList<Integer>(Arrays.asList(10, 12));

        ar.minimize(A, B, C);
    }
}
