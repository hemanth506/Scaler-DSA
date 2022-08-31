import java.util.ArrayList;
import java.util.Arrays;

public class maxSumSpuareSubmatrix {
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int N = A.size();

        for(int row = 0; row < N; row++) {
            for (int col = 1; col < N; col++) {
                int pfVal = A.get(row).get(col - 1) + A.get(row).get(col);
                A.get(row).set(col, pfVal);
            }
        }

        for (int col = 0; col < N; col++) {
            for(int row = 1; row < N; row++) {
                int pfVal = A.get(row - 1).get(col) + A.get(row).get(col);
                A.get(row).set(col, pfVal);
            }
        }

        System.out.println(A);

        int maxV = Integer.MIN_VALUE;
        for (int row = 0; row <= N - B; row++) {
            for (int col = 0; col <= N - B; col++) {
                System.out.println(row + ", " + col + " " + (row + B - 1) + ", " + (col + B - 1));
                int matrxRow = row + B - 1;
                int matrxCol = col + B - 1;

                int value = A.get(matrxRow).get(matrxCol);
                if ((col - 1) >= 0) {
                    value -= A.get(matrxRow).get(col - 1);
                } 
                if ((row - 1) >= 0) {
                    value -= A.get(row - 1).get(matrxCol);
                }
                if ((row - 1) >= 0 && (col - 1) >= 0) {
                    value += A.get(row - 1).get(col - 1);
                }
                maxV = Integer.max(maxV, value);
            }
        }
        System.out.println(maxV);

        return maxV;
    }
    public static void main(String[] args) {
        maxSumSpuareSubmatrix sm = new maxSumSpuareSubmatrix();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2, 2)));
        A.add(new ArrayList<Integer>(Arrays.asList(3, 8, 6, 7, 3)));
        A.add(new ArrayList<Integer>(Arrays.asList(4, 4, 4, 4, 4)));
        A.add(new ArrayList<Integer>(Arrays.asList(5, 5, 5, 5, 5)));

        int B = 3;
        sm.solve(A, B);
    }
}

/*
 * [[1, 2, 3, 4, 5],
 *  [3, 6, 9, 12, 15],
 *  [6, 17, 26, 36, 42],
 *  [10, 25, 38, 52, 62],
 *  [15, 35, 53, 72, 87]]
 */