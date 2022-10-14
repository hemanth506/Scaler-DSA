import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class countRectangles {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int N = A.size();
        HashSet<String> hs = new HashSet<String>();
        for (int i = 0; i < N; i++) {
            String str = A.get(i) + "|" + B.get(i);
            hs.add(str);
        }
        System.out.println(hs);

        int ct = 0;
        for (int i = 0; i < N; i++) {
            HashSet<String> hsInitial = new HashSet<String>();
            int x1 = A.get(i); int y1 = B.get(i);
            String c1 = x1 + "|" + y1;
            for(int j = i+1; j < N; j++) {
                int x2 = A.get(j); int y2 = B.get(j);
                String c2 = x2 + "|" + y2;
                if (x1 != x2 && y1 != y2) {
                    String s1 = x1 + "|" + y2;
                    String s2 = x2 + "|" + y1;

                    if(hs.contains(s1) && hs.contains(s2)) {
                        if(!hsInitial.contains(c2)) {
                            ct += 1;
                            hsInitial.add(c1);
                            hsInitial.add(c2);
                            hsInitial.add(s1);
                            hsInitial.add(s2);
                        }
                    }
                }
            }
            System.out.println("i = " + i);
            System.out.println(hsInitial);
            System.out.println("===================================");
        }
        /* 
         * Since we are calculating for both the diagonals: 
         * Bottom Left to top right => a = (1,1) b = (2,2)
         * Top left to botton left => a = (1,2) b = (2,1)
         * we have to divide by 2. 
         */
        ct /= 2;
        System.out.println(ct);
        return ct;
    }
    public static void main(String[] args) {
        countRectangles cr = new countRectangles();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1, 2, 2, 3, 3));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1, 2, 1, 2, 1, 2));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1, 2, 2));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1, 2, 1, 2));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(6, 5, 7, 3, 8, 1, 7, 6, 9, 1, 9));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(9, 6, 5, 6, 9, 4, 2, 10, 10, 9, 6)); 
        cr.solve(A, B);
    }
}
