import java.util.ArrayList;
import java.util.Arrays;

public class maxSumSubmatrix {
    public int kadane(int[] A) {
        // Always take a copy of an array and then do Kadane's because it may alter the original arr values
        int N = A.length;
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = A[i];
        }

        int kadMaxV = B[0];
        for(int i = 1; i < N; i++) {
            B[i] = Integer.max(B[i] + B[i-1], B[i]);
            kadMaxV = Integer.max(B[i], kadMaxV);
        }
        System.out.println(kadMaxV);
        return kadMaxV;
    }
    
    // contribution and Kadane's
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();

        int maxVal = Integer.MIN_VALUE;
        for(int startRow = 0; startRow < N; startRow++) {
            int[] arr = new int[M]; 
            for(int endRow = startRow; endRow < N; endRow++) {
                // apply contribution technique
                for(int j = 0; j < M; j++) {
                    arr[j] += A.get(endRow).get(j);
                }
                // apply kadane's algo
                int kadaneMax = kadane(arr);
                maxVal = Integer.max(maxVal, kadaneMax);
            }
            System.out.println("========================");
        }
        
        System.out.println(maxVal);
        return maxVal;
    }
    
    
    public static void main(String[] args) {
        maxSumSubmatrix ms = new maxSumSubmatrix();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(new ArrayList<Integer>(Arrays.asList(-6, -6)));
        A.add(new ArrayList<Integer>(Arrays.asList(-29, -8)));
        A.add(new ArrayList<Integer>(Arrays.asList(3, -8)));
        A.add(new ArrayList<Integer>(Arrays.asList(-15, 2)));
        A.add(new ArrayList<Integer>(Arrays.asList(25, 25)));
        A.add(new ArrayList<Integer>(Arrays.asList(20, -5)));
        
        // A.add(new ArrayList<Integer>(Arrays.asList(-6, -21, 27, 19, 19)));
        // A.add(new ArrayList<Integer>(Arrays.asList(0, 0, 5, -21, 19)));
        // A.add(new ArrayList<Integer>(Arrays.asList(18, -27, -2, -7, 13)));
        // A.add(new ArrayList<Integer>(Arrays.asList(-21, -17, -25, -1, 3)));
        // A.add(new ArrayList<Integer>(Arrays.asList(0, -9, -6, -16, -5)));
        // A.add(new ArrayList<Integer>(Arrays.asList(29, 9, -25, -7, -25)));

        // int[] arr = {-6, -21, 27, 19, 19};
        // ms.kadane(arr);
        // ms.kad(arr);

        ms.solve(A);

    }
}

/*
 * [[-6, -12],
 *  [-35, -49],
 *  [-32, -54],
 *  [-47, -67],
 *  [-22, -17],
 *  [-2, -2]]
 */

/*
 * [-6, -21, 27, 19, 19]
  [0, 0, 5, -21, 19]
  [18, -27, -2, -7, 13]
  [-21, -17, -25, -1, 3]
  [0, -9, -6, -16, -5]
  [29, 9, -25, -7, -25]
 */

 /*
  * -6
[-6, -6]
-14
[-35, -14]
-22
[-32, -22]
-20
[-47, -20]
5
[-22, 5]
0
[-2, 0]
========================
-8
[-29, -8]
-16
[-26, -16]
-14
[-41, -14]
11
[-16, 11]
10
[4, 6]
========================
3
[3, -8]
-6
[-12, -6]
32
[13, 19]
47
[33, 14]
========================
2
[-15, 2]
37
[10, 27]
52
[30, 22]
========================
50
[25, 25]
65
[45, 20]
========================
20
[20, -5]
========================
65
  */