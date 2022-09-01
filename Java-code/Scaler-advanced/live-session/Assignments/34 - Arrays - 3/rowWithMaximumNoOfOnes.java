import java.util.ArrayList;
import java.util.Arrays;

public class rowWithMaximumNoOfOnes {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < M; j++) {
                int value = A.get(i).get(j-1) + A.get(i).get(j);
                A.get(i).set(j, value);
            }
        }

        int maxV = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (A.get(i).get(M-1) > maxV) {
                maxV = A.get(i).get(M-1);
                index = i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        rowWithMaximumNoOfOnes rm = new rowWithMaximumNoOfOnes();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 0, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1)));


        rm.solve(A);
    }
}
