import java.util.ArrayList;
import java.util.Arrays;

public class minimizeAbsoluteDiff {
    public int getMaxVal(int pA, int pB, int pC, ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        // System.out.println("maxVal " + maxVal);
        int currectSetMax = Integer.MIN_VALUE;
        currectSetMax = Integer.max(currectSetMax, A.get(pA));
        currectSetMax = Integer.max(currectSetMax, B.get(pB));
        currectSetMax = Integer.max(currectSetMax, C.get(pC));
        return currectSetMax;
    }

    public int getMinVal(int pA, int pB, int pC, ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int currectSetMin = Integer.MAX_VALUE;
        currectSetMin = Integer.min(currectSetMin, A.get(pA));
        currectSetMin = Integer.min(currectSetMin, B.get(pB));
        currectSetMin = Integer.min(currectSetMin, C.get(pC));
        return currectSetMin;
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int NA = A.size(); int NB = B.size(); int NC = C.size();
        int p1 = 0; int p2 = 0; int p3 = 0;

        int absMin = Integer.MAX_VALUE;
        while (p1 < NA && p2 < NB && p3 < NC) {
            int maxVal = getMaxVal(p1, p2, p3, A, B, C);
            int minVal = getMinVal(p1, p2, p3, A, B, C);
            absMin = Integer.min(absMin, Math.abs(maxVal - minVal));
            System.out.println(maxVal + " " + minVal + " absMin = " + absMin);
            System.out.println(A.get(p1) + " " + B.get(p2) + " " + C.get(p3));

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
            System.out.println("=================");
        }

        System.out.println(absMin);
        return absMin;
    }
    public static void main(String[] args) {
        minimizeAbsoluteDiff ma = new minimizeAbsoluteDiff();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 4, 5, 8, 10));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(6, 9, 15));
        ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(2, 3, 6, 6));

        ma.solve(A, B, C);
    }
}
