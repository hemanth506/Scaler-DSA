/* Method 1: Transpose and reverse
 * Method 2: switching the values [Currently implemeted]
 */


/* Important : 
 * Either ROW or COLUMN should only traverse from 0 to N/2 - including N/2
 * if not traversing for both COLUMN and ROW, then it will alter twice the same number, so the result will be wrong some thing like the below:
 * [[21, 16, 23, 6, 1],
 *  [22, 17, 18, 7, 2],
 *  [15, 14, 13, 12, 11],
 *  [24, 19, 8, 9, 4],
 *  [25, 20, 3, 10, 5]]
 */

import java.util.ArrayList;
import java.util.Arrays;

public class rotate90Degree {
    public ArrayList<ArrayList<Integer>> rotate(ArrayList<ArrayList<Integer>> A) {
        System.out.println("Initial array => " + A);

        int N = A.size();
        int B = N/2;
        System.out.println(N + " " + B);

        // the comment which is metioned above is related to this.
        for (int row = 0; row <= B; row++) {
            for (int col = 0; col < B; col++) {
                int tempI = row;
                int tempJ = col;
                int times = 0;
                int toChange = A.get(tempI).get(tempJ);
                while (times < 4) {
                    // System.out.println("initial id => " + tempI + " " + tempJ + " toChange => " + toChange);
                    int tempToChange = A.get(tempJ).get(N - tempI - 1);
                    A.get(tempJ).set(N - tempI - 1, toChange);
                    toChange = tempToChange;
                    int tTempJ = tempJ;
                    int tTempI = tempI;
                    tempJ = N - tTempI - 1;
                    tempI = tTempJ;
                    times++;
                }
                // System.out.println("=================");
            }
        }

        System.out.println("Final array => " + A);

        return A;
    }
    public static void main(String[] args) {
        rotate90Degree rt = new rotate90Degree();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5)));
        A.add(new ArrayList<Integer>(Arrays.asList(6,7,8,9,10)));
        A.add(new ArrayList<Integer>(Arrays.asList(11,12,13,14,15)));
        A.add(new ArrayList<Integer>(Arrays.asList(16,17,18,19,20)));
        A.add(new ArrayList<Integer>(Arrays.asList(21,22,23,24,25)));

        rt.rotate(A);
    }
}
/* Actual array:
 * [[1, 2, 3, 4, 5],
 *  [6, 7, 8, 9, 10],
 *  [11, 12, 13, 14, 15],
 *  [16, 17, 18, 19, 20],
 *  [21, 22, 23, 24, 25]]
 */

/* Result when ROW goes from 0 to N/2 - including N/2
 * [[21, 16, 11, 6, 1],
 *  [22, 17, 12, 7, 2],
 *  [23, 18, 13, 8, 3],
 *  [24, 19, 14, 9, 4],
 *  [25, 20, 15, 10, 5]]
 */

/* Result when COLUMN goes from 0 to N/2 - including N/2
 * [[21, 16, 11, 6, 1],
 *  [22, 17, 12, 7, 2],
 *  [23, 18, 13, 8, 3],
 *  [24, 19, 14, 9, 4],
 *  [25, 20, 15, 10, 5]]
 */