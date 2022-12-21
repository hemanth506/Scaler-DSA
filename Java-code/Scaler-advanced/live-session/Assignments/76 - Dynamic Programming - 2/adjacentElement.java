import java.util.ArrayList;
import java.util.Arrays;

public class adjacentElement {
    
    public int getSum(int[] maxArr, int i, int N, int[] dp) {
        if(i >= N) {
            return 0;
        }

        if(dp[i] == -1) {
            dp[i] = Integer.max(getSum(maxArr, i+1, N, dp), getSum(maxArr, i+2, N, dp)+maxArr[i]);
        }

        return dp[i];
    }
    
    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();

        int[] maxArr = new int[M];
        for(int i = 0; i < M; i++) {
            maxArr[i] = A.get(0).get(i);
        } 

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < M; j++) {
                maxArr[j] = Integer.max(maxArr[j], A.get(i).get(j));
            }
        }

        int Nlen = maxArr.length;
        int[] dp = new int[Nlen];
        for(int i = 0; i < Nlen; i++) {
            dp[i] = -1;
        }
        
        System.out.println(Arrays.toString(maxArr));
        
        int totalSum = getSum(maxArr, 0, Nlen, dp);
        System.out.println(totalSum);
        return totalSum;
    }

    public static void main(String[] args) {
        adjacentElement ae = new adjacentElement();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)));
        A.add(new ArrayList<Integer>(Arrays.asList(2, 3, 4, 5)));

        ae.adjacent(A);
    }
}
