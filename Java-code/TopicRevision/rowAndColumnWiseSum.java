public class rowAndColumnWiseSum {
    void columnWise(int[][] arr) {
        int outerN = arr.length;
        int innerN = arr[0].length;

        for (int i = 0; i < outerN; i++) {
            int sum = 0;
            for (int j = 0; j < innerN; j++) {
                sum += arr[i][j];
            }
            System.out.println(sum);
        }
    }

    void rowWise(int[][] arr) {
        int outerN = arr.length;
        int innerN = arr[0].length;

        for (int i = 0; i < innerN; i++) {
            int sum = 0;
            for (int j = 0; j < outerN; j++) {
                sum += arr[j][i];
            }
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        rowAndColumnWiseSum rc = new rowAndColumnWiseSum();
        int[][] arr = {{4,3,1,7}, {6,2,3,4}, {5,3,2,7}};
        rc.columnWise(arr);
        rc.rowWise(arr);
    }
}
