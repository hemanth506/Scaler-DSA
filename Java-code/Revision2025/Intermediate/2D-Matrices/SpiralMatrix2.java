import java.util.Arrays;

public class SpiralMatrix2 {
    public static void main(String[] args) {
        int A = 4;
        int[][] arr = generateMatrix(A);
        System.out.println(Arrays.deepToString(arr));
    }

    public static int[][] generateMatrix(int A) {
        int[][] arr = new int[A][A];

        int limit = A - 1;
        int i = 0, j = 0;
        int num = 1;

        while (limit > 0) {
            for(int k = 1; k <= limit; k++, j++) {
                arr[i][j] = num++;
            }
            System.out.println(Arrays.deepToString(arr));
            for(int k = 1; k <= limit; k++, i++) {
                arr[i][j] = num++;
            }
            System.out.println(Arrays.deepToString(arr));
            for(int k = 1; k <= limit; k++, j--) {
                arr[i][j] = num++;
            }
            System.out.println(Arrays.deepToString(arr));
            for(int k = 1; k <= limit; k++, i--) {
                arr[i][j] = num++;
            }
            System.out.println(Arrays.deepToString(arr));
            limit -= 2;
            i++;
            j++;

            if(limit <= 1 && A%2 == 1) {
                System.out.println("limit: " + limit);
                break;
            }
        }

        if(A%2 == 1) {
            arr[i][j] = num;
        }

        System.out.println(Arrays.deepToString(arr));
        return arr;
    }
}

/*
 * 
 * [[1, 2, 3, 4], 
 * [12, 13, 14, 5], 
 * [11, 16, 15, 6], 
 * [10, 9, 8, 7]]
 * 
 * [[1, 2, 3, 4],
 *  [12, 13, 14, 5],
 *  [11, 16, 15, 6],
 *  [10, 9, 8, 7]]
 * 
 * 
 * [[1, 2, 3],
 *  [8, 9, 4],
 *  [7, 6, 5]]
 */