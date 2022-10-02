import java.util.ArrayList;
import java.util.Arrays;

public class subMatrixSumQueries {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E) {
        System.out.println(A);
        int N = A.size();
        int M = A.get(0).size();
        int mod = 1000000007;
        for(int row = 0; row < N; row++) {
            for (int col = 1; col < M; col++) {
                int val = A.get(row).get(col)%mod + A.get(row).get(col - 1)%mod;
                val%=mod;
                if (val < 0) {
                    val += mod;
                }
                A.get(row).set(col, val);
            }
        }
        System.out.println(A);

        for(int col = 0; col < M; col++) {
            for (int row = 1; row < N; row++) {
                int val = A.get(row).get(col)%mod + A.get(row - 1).get(col)%mod;
                val%=mod;
                if (val < 0) {
                    val += mod;
                }
                A.get(row).set(col, val);
            }
        }
        System.out.println(A);
        ArrayList<Integer> allQueries = new ArrayList<Integer>();
        int q = B.size();
        for(int i = 0;i < q; i++) {
            int lx = B.get(i) - 1; int ly = C.get(i) - 1;
            int rx = D.get(i) - 1; int ry = E.get(i) - 1;

            int sumVal = A.get(rx).get(ry)%mod;
            if((ly - 1) >= 0) {
                sumVal -= A.get(rx).get(ly - 1)%mod;
            }

            if ((lx - 1) >= 0) {
                sumVal -= A.get(lx - 1).get(ry)%mod;
            }

            if ((lx - 1) >= 0 && (ly - 1) >= 0) {
                sumVal += A.get(lx - 1).get(ly - 1)%mod;
            }
            sumVal %= mod;
            if (sumVal < 0) {
                sumVal += mod;
            }
            allQueries.add(sumVal);
        }
        System.out.println(allQueries);
        return allQueries;
    }
    public static void main(String[] args) {
        subMatrixSumQueries sm = new subMatrixSumQueries();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        A.add(new ArrayList<Integer>(Arrays.asList(4, 5, 6)));
        A.add(new ArrayList<Integer>(Arrays.asList(7, 8, 9)));

        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1, 2));
        ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(1, 2));
        ArrayList<Integer> D = new ArrayList<Integer>(Arrays.asList(2, 3));
        ArrayList<Integer> E = new ArrayList<Integer>(Arrays.asList(2, 3));
        sm.solve(A, B, C, D, E);
    }
}
