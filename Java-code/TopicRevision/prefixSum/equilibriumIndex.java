import java.util.ArrayList;
import java.util.Arrays;

public class equilibriumIndex {
    public int equilibrium(ArrayList<Integer> A) {
        int N = A.size();

        int sumValue = 0;
        ArrayList<Integer> prefixSum = new ArrayList<Integer>();
        prefixSum.add(0, A.get(0));
        for(int i = 1; i < N; i++) {
            sumValue = prefixSum.get(i - 1) + A.get(i);
            prefixSum.add(i, sumValue);
        }
        System.out.println(prefixSum);

        for (int j = 0; j < N; j++) {
            int leftSide = 0;
            if (j > 0) {
                leftSide = prefixSum.get(j - 1);
            }

            int rightSide = prefixSum.get(N-1) - prefixSum.get(j);

            System.out.println(leftSide + " " + rightSide);
            if (leftSide == rightSide) {
                System.out.println(j);
                return j;
            }
        }
        return -1;
    }  
    public static void main(String[] args) {
        equilibriumIndex eq = new equilibriumIndex();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-7, 1, 5, 2, -4, 3, 0));
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 13, 1, 2, 3, 4, 5, 6));
        
        eq.equilibrium(A);
    }  
}
