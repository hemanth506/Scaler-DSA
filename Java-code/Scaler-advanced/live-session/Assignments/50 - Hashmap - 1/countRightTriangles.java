import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class countRightTriangles {
    public boolean checkForTriangleN3(int x1, int y1, int x2, int y2, int x3, int y3) {
        if ((x1 == x3 && y1 == y3) || (x1 == x2 && y1 == y3)) {
            System.out.println("condition 1");
            return true;
        } else if ((x2 == x3 && y2 == y1) || (x1 == x2 && y2 == y3)) {
            System.out.println("condition 2");
            return true;
        } else if ((x3 == x1 && y3 == y2) || (x3 == x2 && y3 == y1)) {
            System.out.println("condition 3");
            return true;
        }
        return false;
    }

    public int solveN3(ArrayList<Integer> A, ArrayList<Integer> B) {
        int N = A.size();
        int ct = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (checkForTriangleN3(A.get(i), B.get(i), A.get(j), B.get(j), A.get(k), B.get(k))) {
                        ct += 1;
                    }
                }
            }
        }
        System.out.println(ct);
        return ct;
    }

    // same logic to find rectangle with some minor modification
    public int solveN2(ArrayList<Integer> A, ArrayList<Integer> B) {
        int N = A.size();
        HashSet<String> hs = new HashSet<String>();
        for (int i = 0; i < N; i++) {
            String str = A.get(i) + "|" + B.get(i);
            hs.add(str);
        }
        System.out.println(hs);

        int ct = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int x1 = A.get(i); int y1 = B.get(i);
                int x2 = A.get(j); int y2 = B.get(j);
                if (x1 != x2 && y1 != y2) {
                    String s1 = x1 + "|" + y2;
                    String s2 = x2 + "|" + y1;

                    if (hs.contains(s1)) {
                        ct += 1;
                    }

                    if (hs.contains(s2)) {
                        ct += 1;
                    }
                }
            }
        }
        System.out.println(ct);
        return ct;
    }

    // Final optimization
    public int solveN(ArrayList<Integer> A, ArrayList<Integer> B) {
        int N = A.size();
        HashMap<Integer, Integer> xHm = new HashMap<Integer, Integer>();
        for(int i = 0; i < N; i++) {
            if(xHm.containsKey(A.get(i))) {
                int val = xHm.get(A.get(i)) + 1;
                xHm.put(A.get(i), val);
            } else {
                xHm.put(A.get(i), 1);
            }
        }
        System.out.println(xHm);
        HashMap<Integer, Integer> yHm = new HashMap<Integer, Integer>();
        for(int i = 0; i < N; i++) {
            if(yHm.containsKey(B.get(i))) {
                int val = yHm.get(B.get(i)) + 1;
                yHm.put(B.get(i), val);
            } else {
                yHm.put(B.get(i), 1);
            }
        }
        System.out.println(yHm);

        int finalAns = 0;
        for(int i = 0; i < N; i++) {
            int xVal = 0;
            if(xHm.containsKey(A.get(i))) {
                xVal = xHm.get(A.get(i)) - 1;
            }
            int yVal = 0;
            if(yHm.containsKey(B.get(i))) {
                yVal = yHm.get(B.get(i)) - 1;
            }

            finalAns += xVal*yVal;
        }
        System.out.println(finalAns);
        return finalAns;
    }

    public static void main(String[] args) {
        countRightTriangles cr = new countRightTriangles();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1, 2, 3, 3));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1, 2, 1, 2, 1));
        // cr.solveN3(A, B);
        // cr.solveN2(A, B);
        cr.solveN(A, B);


    }
}
