import java.util.Arrays;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] A = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
        int[][] B = { { 9, 10 }, { 11, 12 }, { 13, 14 }, { 15, 16 } };

        System.out.println(Arrays.deepToString(solve(A, B)));
    }

    public static int[][] solve(int[][] A, int[][] B) {
        int N = A.length;
        int M = B.length;
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < M; k++) {
                    sum = sum + A[i][k] * B[k][j];
                }
                arr[i][j] = sum;
            }
        }
        return arr;
    }
}
