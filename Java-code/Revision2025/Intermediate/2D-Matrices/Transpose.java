import java.util.Arrays;

public class Transpose {
    public static void main(String[] args) {
        int[][] A = {{1,2}, {3,4}, {5,6}, {7,8}};
        System.out.println(Arrays.deepToString(solve(A)));
    }
            
    public static int[][] solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int[][] arr = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[j][i] = A[i][j];
            }
        }

        return arr;
    }
}
