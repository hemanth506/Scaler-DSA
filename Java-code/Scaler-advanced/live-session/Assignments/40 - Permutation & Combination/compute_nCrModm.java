
public class compute_nCrModm {
    public int solve(int A, int B, int C) {
        int n = A+1;
        int r = B+1;

        int[][] matrix = new int[n][r];
        // System.out.println(Arrays.deepToString(matrix));

        for(int i = 0; i < n; i++) {
            matrix[i][0] = 1;
            for(int j = 1; j < r; j++) {
                if(i < j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = (matrix[i-1][j]%C + matrix[i-1][j-1]%C)%C;
                }
            }
            // System.out.println(Arrays.deepToString(matrix));
        }
        // System.out.println(matrix[A][B]%C);

        return matrix[A][B]%C;
    }

    public static void main(String[] args) {
        compute_nCrModm nCr = new compute_nCrModm();
        int A = 5;
        int B = 2;
        int C = 13;
        nCr.solve(A, B, C);
    }
}