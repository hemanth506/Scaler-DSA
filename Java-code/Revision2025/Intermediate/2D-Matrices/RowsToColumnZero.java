import java.util.ArrayList;
import java.util.HashSet;

public class RowsToColumnZero {
    public static void main(String[] args) {
        int[][] A = {{1,2}, {3,4}, {5,6}, {7,8}};
        System.out.println(solve(A));
    }

    public static int[][] solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;

        HashSet<Integer> rows = new HashSet<Integer>();
        HashSet<Integer> cols = new HashSet<Integer>();

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(A[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(rows.contains(i) || cols.contains(j)) {
                    A[i][j] = 0;
                }
            }
        }

        return A;
    }
}
