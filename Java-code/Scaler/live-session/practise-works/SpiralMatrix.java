import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class SpiralMatrix {

    int[][] generateMatrix(int x, int y) {

        int[][] newArr = new int[y][x];
        int a = x;
        int b = y;
        int ct = 1;

        // interval array creation
        ArrayList<Integer> intervalSize = new ArrayList<Integer>();
        intervalSize.add(x);
        while (a > 0 & b > 0) {
            if (ct % 2 != 1) {
                a-=1;
                intervalSize.add(a);
            } else {
                b-=1;
                intervalSize.add(b);
            }
            ct++;
        }

        // spiral array creation
        boolean goRight = true;
        boolean goDown = false;
        boolean goLeft = false;
        boolean goUp = false;
        int m = 0;
        int n = -1;
        int integer = 1;
        for (int i = 0; i < intervalSize.size(); i++) {
            if (goRight) {
                n++;
                for (int j = 0; j < intervalSize.get(i); j++) {
                    newArr[m][n] = integer;
                    // System.out.println("goRight => " + " " + m + " " + n + " integer => " + integer);
                    integer++;
                    if (j != intervalSize.get(i) - 1) {
                        n++;
                    }
                }
                goRight = false;
                goDown = true;
            }
            else if (goDown) {
                m++;
                for (int j = 0; j < intervalSize.get(i); j++) {
                    newArr[m][n] = integer;
                    // System.out.println("goDown" + " " + m + " " + n + " integer => " + integer);
                    integer++;
                    if (j != intervalSize.get(i) - 1) {
                        m++;
                    }
                }
                goDown = false;
                goLeft = true;
            }
            else if (goLeft) {
                n--;
                for (int j = 0; j < intervalSize.get(i); j++) {
                    newArr[m][n] = integer;
                    // System.out.println("goLeft" + " " + m + " " + n + " integer => " + integer);
                    integer++;
                    if (j != intervalSize.get(i) - 1) {
                        n--;
                    }
                }
                goLeft = false;
                goUp = true;
            }
            else if (goUp) {
                m--;
                for (int j = 0; j < intervalSize.get(i); j++) {
                    newArr[m][n] = integer;
                    // System.out.println("goUp" + " " + m + " " + n + " integer => " + integer);
                    integer++;
                    if (j != intervalSize.get(i) - 1) {
                        m--;
                    }
                }
                goUp = false;
                goRight = true;
            }
        }
        
        return newArr;
    } 


    public static void main(String[] args) {
        
        int col, row;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the row size: ");
        row = scan.nextInt();

        System.out.println("Enter the column size: ");
        col = scan.nextInt();

        SpiralMatrix spiral = new SpiralMatrix();
        int[][] returnArr = spiral.generateMatrix(col, row);
        System.out.println(Arrays.deepToString(returnArr));

        scan.close();

        /*
         *  o/p => 
         *  [[1, 2, 3],
         *  [14, 15, 4],
         *  [13, 16, 5],
         *  [12, 17, 6],
         *  [11, 18, 7],
         *  [10, 9, 8]]
         * 
         */
    }
}