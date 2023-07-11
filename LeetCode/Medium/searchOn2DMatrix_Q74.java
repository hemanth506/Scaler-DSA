public class searchOn2DMatrix_Q74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int N = matrix.length;
        int M = matrix[0].length;

        int i = 0;
        int j = M - 1;

        while (i < N && j >= 0) {
            System.out.println(i + " " + j);
            if (matrix[i][j] == target) {
                System.out.println("found");
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target) {
                j--;
            }
        }
        System.out.println("Not found");

        return false;
    }

    public static void main(String[] args) {
        searchOn2DMatrix_Q74 sm = new searchOn2DMatrix_Q74();
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 3;
        sm.searchMatrix(matrix, target);
    }
}
