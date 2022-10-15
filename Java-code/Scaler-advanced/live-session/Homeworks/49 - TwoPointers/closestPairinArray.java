import java.util.ArrayList;
import java.util.Arrays;

public class closestPairinArray {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {        
        int N = A.size();
        int M = B.size();

        int minVal = Integer.MAX_VALUE;
        int elt1 = 0;
        int elt2 = 0;
        for(int i = 0;i < N; i++) {
            int l = 0;
            int h = M-1;
            while (l <= h) {
                int m = (l + h)/2;
                int pairVal = A.get(i) + B.get(m);
                System.out.println(i + "|" + A.get(i) + "  " + m + "|" + B.get(m));
                int diff = Math.abs(C - pairVal);
                System.out.println(pairVal + " " + diff);
                if(minVal > diff) {
                    System.out.println(i + " ============= " + m);
                    minVal = diff;
                    elt1 = i;
                    elt2 = m;
                }
                if(pairVal < C) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            }
        }

        ArrayList<Integer> finalOutPut = new ArrayList<Integer>();
        System.out.println(elt1 + " " + elt2);
        finalOutPut.add(A.get(elt1));
        finalOutPut.add(B.get(elt2));
        System.out.println(finalOutPut);
        return finalOutPut;
    }
    public static void main(String[] args) {
        closestPairinArray ca = new closestPairinArray();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(2, 4, 6, 8));
        int C = 9;
        ca.solve(A, B, C);
    }
}
