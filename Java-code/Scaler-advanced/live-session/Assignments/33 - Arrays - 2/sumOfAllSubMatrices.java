import java.util.ArrayList;
import java.util.Arrays;

public class sumOfAllSubMatrices {
    // TC => O(N*M)
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();
        int sumV = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sumV += A.get(i).get(j) * (i + 1) * (j + 1) * (N - i) * (M - j);
            }
        }
        System.out.println(sumV);
        return sumV;
    }
    public static void main(String[] args) {
        sumOfAllSubMatrices sa = new sumOfAllSubMatrices();
        
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
        sa.solve(A);
    }
}
