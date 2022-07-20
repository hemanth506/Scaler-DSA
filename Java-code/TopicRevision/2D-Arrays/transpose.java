import java.util.ArrayList;
import java.util.Arrays;

public class transpose {

    public ArrayList<ArrayList<Integer>> rotate90(ArrayList<ArrayList<Integer>> arr) {
        System.out.println("From rotate 90degree");
        int N = arr.size();

        for(int i = 0; i < N; i++) {
            int f = 0;
            int e = arr.get(i).size() - 1;
            int temp = 0;
            while (f < e) {
                temp = arr.get(i).get(f);
                arr.get(i).set(f, arr.get(i).get(e));
                arr.get(i).set(e, temp);
                f++;
                e--;
            }
        }
        return arr;
    }

    public void transposeSquare (ArrayList<ArrayList<Integer>> arr) {
        int N = arr.size();
        int temp = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                temp = arr.get(i).get(j);
                arr.get(i).set(j, arr.get(j).get(i));
                arr.get(j).set(i, temp);
                // System.out.print(arr.get(i).get(j) + " ");
            }
            // System.out.println("");
        }
        System.out.println(arr);
        rotate90(arr);
        System.out.println(arr);
    }

    public void transposeRectangle(ArrayList<ArrayList<Integer>> arr) {
        int N = arr.size();
        int M = arr.get(0).size();
        // System.out.println(arr + " " + N + " " + M);
        ArrayList<ArrayList<Integer>> newArr = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < M; i++) {
            ArrayList<Integer> nestedArr = new ArrayList<Integer>();
            for (int j = 0; j < N; j ++) {
                nestedArr.add(j, arr.get(j).get(i));
            }
            newArr.add(nestedArr);
        }
        System.out.println(newArr);
        rotate90(newArr);
        System.out.println(newArr);
    }


    public static void main(String[] args) {
        transpose  trans = new transpose();

        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(5);

        ArrayList<Integer> innerArr1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        arr.add(innerArr1);

        ArrayList<Integer> innerArr2 = new ArrayList<Integer>(Arrays.asList(6,7,8,9,10));
        arr.add(innerArr2);

        ArrayList<Integer> innerArr3 = new ArrayList<Integer>(Arrays.asList(11,12,13,14,15));
        arr.add(innerArr3);

        ArrayList<Integer> innerArr4 = new ArrayList<Integer>(Arrays.asList(16,17,18,19,20));
        arr.add(innerArr4);

        ArrayList<Integer> innerArr5 = new ArrayList<Integer>(Arrays.asList(21,22,23,24,25));
        arr.add(innerArr5);

        // trans.transposeSquare(arr);

        /* I/P
         * [[1, 2, 3, 4, 5],
         *  [6, 7, 8, 9, 10],
         *  [11, 12, 13, 14, 15],
         *  [16, 17, 18, 19, 20],
         *  [21, 22, 23, 24, 25]]
         * 
         * O/P
         * [[1, 6, 11, 16, 21],
         *  [2, 7, 12, 17, 22],
         *  [3, 8, 13, 18, 23],
         *  [4, 9, 14, 19, 24],
         *  [5, 10, 15, 20, 25]]
         * 
         * [[21, 16, 11, 6, 1],
         *  [22, 17, 12, 7, 2],
         *  [23, 18, 13, 8, 3],
         *  [24, 19, 14, 9, 4],
         *  [25, 20, 15, 10, 5]]
         */

        ArrayList<ArrayList<Integer>> arrRect = new ArrayList<ArrayList<Integer>>(3);

        ArrayList<Integer> innerArrRect1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        arrRect.add(innerArrRect1);

        ArrayList<Integer> innerArrRect2 = new ArrayList<Integer>(Arrays.asList(10,11,12,13,14,15,16,17,18));
        arrRect.add(innerArrRect2);

        ArrayList<Integer> innerArrRect3 = new ArrayList<Integer>(Arrays.asList(19,20,21,22,23,24,25,26,27));
        arrRect.add(innerArrRect3);

        trans.transposeRectangle(arrRect);

        /*
         * I/p
         * [[1, 2, 3, 4, 5, 6, 7, 8, 9],
         *  [10, 11, 12, 13, 14, 15, 16, 17, 18],
         *  [19, 20, 21, 22, 23, 24, 25, 26, 27]]
         * 
         * o/p
         * [[1, 10, 19],
         *  [2, 11, 20],
         *  [3, 12, 21],
         *  [4, 13, 22],
         *  [5, 14, 23],
         *  [6, 15, 24],
         *  [7, 16, 25],
         *  [8, 17, 26],
         *  [9, 18, 27]]
         * 
         * 
         * [[19, 10, 1],
         *  [20, 11, 2],
         *  [21, 12, 3],
         *  [22, 13, 4],
         *  [23, 14, 5],
         *  [24, 15, 6],
         *  [25, 16, 7],
         *  [26, 17, 8],
         *  [27, 18, 9]]
         */
    }
}