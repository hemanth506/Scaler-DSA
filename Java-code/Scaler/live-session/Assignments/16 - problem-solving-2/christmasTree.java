import java.util.ArrayList;
import java.util.Arrays;

public class christmasTree {
    int solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        int N = A.size();
        int totalMin = Integer.MAX_VALUE;
        int currentMin;
        boolean returned = false;
        for (int q = 1; q < N-1; q++) {

            int minLeftValue = 0;
            boolean initialLeft = false;
            boolean validateLeft = false;
            for (int p = 0; p < q; p++) {
                if ((A.get(p) < A.get(q))) {
                    validateLeft = true;
                    if(initialLeft) {
                        if (minLeftValue > B.get(p)) {
                            minLeftValue = B.get(p);
                        }
                    } else {
                        minLeftValue = B.get(p);
                        initialLeft = true;
                    }
                }
            }

            int minRightValue = 0;
            boolean initialRight = false;
            boolean validateRight = false;
            for(int r = q + 1;r < N; r++) {
                if ((A.get(q) < A.get(r))) {
                    validateRight = true;
                    if (initialRight) {
                        if (minRightValue > B.get(r)) {
                            minRightValue = B.get(r);
                        }
                    } else {
                        minRightValue = B.get(r);
                        initialRight = true;
                    }
                }
            }

            if (validateRight & validateLeft) {
                currentMin = minRightValue + B.get(q) + minLeftValue;
                // System.out.println(currentMin);

                if (currentMin < totalMin) {
                    totalMin = currentMin;
                }
                returned = true;
            }
        }
        return returned ? totalMin : -1;
    }

    public static void main(String[] args) {

        christmasTree soln = new christmasTree();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList( 5, 9, 10, 4, 7, 8));
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList( 2, 4, 5, 4, 10));
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(100, 101, 100));
        

        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(5, 6, 4, 7, 2, 5));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(40, 30, 20, 10, 40));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(2, 4, 5));
        
        int length = soln.solve(A,B);
        System.out.println(length);
    }
}
