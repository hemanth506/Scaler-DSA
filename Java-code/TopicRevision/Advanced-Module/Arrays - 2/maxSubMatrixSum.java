import java.util.ArrayList;
import java.util.Arrays;

public class maxSubMatrixSum {
    public int kadanes(int[] A) {
        int N = A.length;
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = A[i];
        }
        int maxV = B[0];
        int sumV = 0;
        for(int i = 1; i < N; i++) {
            sumV = Integer.max(B[i] + B[i - 1], B[i]);
            B[i] = sumV;
            maxV = Integer.max(maxV, sumV);
        }
        System.out.println(maxV);
        return maxV;
    }
    public int solve(ArrayList<ArrayList<Integer>> A) {
        System.out.println(A);
        int N = A.size();
        int M = A.get(0).size();

        int maxArr = Integer.MIN_VALUE;
        for(int strId = 0; strId < N; strId++) {
            int arr[] = new int[M];
            for(int i = strId; i < N; i++) {
                System.out.println(A.get(i));
                for(int j = 0; j < M; j++) {
                    arr[j] = A.get(i).get(j) + arr[j];
                }
    
                int newMaxArr = kadanes(arr);
                maxArr = Integer.max(maxArr, newMaxArr);
                System.out.println(Arrays.toString(arr));
                System.out.println("=============");
            }
        }
        System.out.println(maxArr);
        return maxArr;
    }
    public static void main(String[] args) {
        maxSubMatrixSum ms = new maxSubMatrixSum();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(new ArrayList<Integer>(Arrays.asList(2,-4,1,3,-1,2)));
        A.add(new ArrayList<Integer>(Arrays.asList(1,3,2,-7,3,3)));
        A.add(new ArrayList<Integer>(Arrays.asList(0,-1,1,3,4,-7)));
        A.add(new ArrayList<Integer>(Arrays.asList(1,-1,-6,4,-4,6)));
        ms.solve(A);
    }
}
