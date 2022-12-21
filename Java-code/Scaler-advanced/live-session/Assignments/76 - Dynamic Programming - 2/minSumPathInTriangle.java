import java.util.ArrayList;
import java.util.Arrays;

public class minSumPathInTriangle {
    public int getMinTotal(ArrayList<ArrayList<Integer>> a, ArrayList<ArrayList<Integer>> dp, int N, int i, int j) {
        if(i >= N || j >= a.get(i).size()) {
            return 0;
        }

        if(dp.get(i).get(j) == -1) {
            int minVal = Integer.min(getMinTotal(a, dp, N, i+1, j), getMinTotal(a, dp, N, i+1, j+1));
            int val = a.get(i).get(j) + minVal;
            System.out.println(i + " " + j + " " + minVal + " " + val);
            dp.get(i).set(j, val);
        }
        return dp.get(i).get(j);
    }
    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int N = a.size();
        ArrayList<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < N; i++) {
            int M = a.get(i).size();
            ArrayList<Integer> inArr = new ArrayList<Integer>();
            for(int j = 0; j < M; j++) {
                inArr.add(-1);
            }
            dp.add(inArr);
        }
        System.out.println(dp);

        int mintot = getMinTotal(a, dp, N, 0, 0);
        System.out.println(dp);

        System.out.println(mintot);
        return mintot;
	}
    
    public static void main(String[] args) {
        minSumPathInTriangle ms = new minSumPathInTriangle();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(new ArrayList<Integer>(Arrays.asList(2)));
        A.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
        A.add(new ArrayList<Integer>(Arrays.asList(6, 5, 7)));
        A.add(new ArrayList<Integer>(Arrays.asList(4, 1, 8, 3)));

        ms.minimumTotal(A);
    }
}
