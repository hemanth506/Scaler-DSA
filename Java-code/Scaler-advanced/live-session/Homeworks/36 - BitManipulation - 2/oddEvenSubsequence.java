import java.util.ArrayList;
import java.util.Arrays;

public class oddEvenSubsequence {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();

        boolean evenFlag = false;
        boolean oddFlag = false;

        int count = 0; 
        if(A.get(0) % 2 == 0) {
            count += 1;
            oddFlag = true;
        } else {
            count += 1;
            evenFlag = true;
        }
        
        for(int i = 1; i < N; i++) {
            if(evenFlag && A.get(i)%2 == 0) {
                count += 1;
                evenFlag = false;
                oddFlag = true;
            } else if (oddFlag && A.get(i)%2 == 1) {
                count += 1;
                oddFlag = false;
                evenFlag = true;
            }
        }
        System.out.println(count);
        return count;
    }
    public static void main(String[] args) {
        oddEvenSubsequence oe = new oddEvenSubsequence();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 2, 5, 6));
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2, 2, 2));

        oe.solve(A);
    }
}
