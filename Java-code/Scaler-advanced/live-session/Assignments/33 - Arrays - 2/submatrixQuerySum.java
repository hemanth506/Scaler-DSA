import java.util.ArrayList;
import java.util.Arrays;

public class submatrixQuerySum {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E) {
        
        int N = A.size();
        int M = A.get(0).size();
        int modVal = 1000000007;
        // 2-D Prefix sum - row-wise
        for (int i = 0; i < N; i++) {
            for(int j = 1; j < M; j++) {
                int curV = A.get(i).get(j-1) + A.get(i).get(j);
                int curMod = curV%modVal;
                if (curMod < 0) {
                    curMod += modVal;
                }
                A.get(i).set(j, curMod);
            }
        }
        // System.out.println(A);

        // 2-D Prefix sum - column-wise
        for (int i = 0; i < M; i++) {
            for(int j = 1; j < N; j++) {
                int curV = A.get(j-1).get(i) + A.get(j).get(i);
                int curMod = curV%modVal;
                if (curMod < 0) {
                    curMod += modVal;
                }
                A.get(j).set(i, curMod);
            }
        }
        System.out.println(A);


        ArrayList<Integer> finalArr = new ArrayList<Integer>();

        // queries
        for (int q = 0; q < B.size(); q++) {
            int lx = B.get(q) - 1; int ly = C.get(q) - 1;
            int rx = D.get(q) - 1; int ry = E.get(q) - 1;
            System.out.println(lx + ", " + ly);
            System.out.println(rx + ", " + ry);

            int value = A.get(rx).get(ry)%modVal;
            if ((ly - 1) >= 0) {
                value -= A.get(rx).get(ly-1)%modVal;
            }

            if ((lx-1) >= 0) {
                value -= A.get(lx-1).get(ry)%modVal;
            }

            if ((lx-1) >= 0 && (ly-1) >= 0) {
                value += A.get(lx-1).get(ly-1)%modVal;
            }

            value %= modVal;
            value += modVal;

            value = (value < 0) ? value += modVal : value;

            System.out.println(value);
            System.out.println("==============");
            finalArr.add(value);
        }
        System.out.println(finalArr);
        
        return finalArr;
    }
    public static void main(String[] args) {
        submatrixQuerySum sq = new submatrixQuerySum();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(new ArrayList<Integer>(Arrays.asList(5, 17, 100, 11)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 0, 2, 8)));

        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1, 1));
        ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(1, 4));
        ArrayList<Integer> D = new ArrayList<Integer>(Arrays.asList(2, 2));
        ArrayList<Integer> E = new ArrayList<Integer>(Arrays.asList(2, 4));

        // A.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        // A.add(new ArrayList<Integer>(Arrays.asList(4, 5, 6)));
        // A.add(new ArrayList<Integer>(Arrays.asList(7, 8, 9)));

        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1, 2));
        // ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(1, 2));
        // ArrayList<Integer> D = new ArrayList<Integer>(Arrays.asList(2, 3));
        // ArrayList<Integer> E = new ArrayList<Integer>(Arrays.asList(2, 3));
        sq.solve(A, B, C, D, E);

    }
}

/*
 * [[5, 22, 122, 133],
 *  [5, 22, 124, 143]]
 */
