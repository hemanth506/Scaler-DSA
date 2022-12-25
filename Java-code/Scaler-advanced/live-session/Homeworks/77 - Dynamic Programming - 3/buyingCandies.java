import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class buyingCandies {

    public int sweetyPie(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C, int D, int i, HashMap<String, Integer> hm) {
        if (i < 0) {
            System.out.println("return");
            return 0;
        }
        String st = D + "_" + i;
        System.out.println("Hemanth = " + st);
        if (!hm.containsKey(st)) {
            int leaveIt = sweetyPie(A, B, C, D, i - 1, hm);
            int takeIt = 0;
            if (D >= C.get(i)) {
                takeIt = sweetyPie(A, B, C, D-C.get(i), i, hm) + (B.get(i)*A.get(i));
            }
            int maxSwt = Integer.max(leaveIt, takeIt);
            System.out.println("i = " + i + " " + leaveIt + " " + takeIt + " " + D + " " + maxSwt);
            hm.put(st, maxSwt);
        }

        return hm.get(st);
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C, int D) {
        int N = A.size();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        int resSweet = sweetyPie(A, B, C, D, N - 1, hm);
        System.out.println("resSweet = " + resSweet);
        return D;
    }

    public static void main(String[] args) {
        buyingCandies bc = new buyingCandies();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(2, 2, 10));
        ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(2, 3, 9));
        int D = 8;

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(5));
        // ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(10));
        // int D = 99;

        bc.solve(A, B, C, D);
    }
}
