import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class nobleInteger {

    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        int ct = 0;
        Collections.sort(A, Collections.reverseOrder());
        int less = 0;
        if (A.get(0) == 0) { 
            ct = 1;
        }
        System.out.println(A);
        for(int i = 1; i < N; i++) {
            if(A.get(i) != A.get(i-1)) {
                System.out.println(A.get(i));
                less = i;
            }

            if (less == A.get(i)) {
                ct += 1;
            }
        }
        System.out.println(ct);
        return ct;
    }
    public static void main(String[] args) {
        nobleInteger nb = new nobleInteger();

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-3,0,2,2,5,5,5,5,8,8,10,10,10,14));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 2, 1, 3));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 7, 0, 9, 3, 6, 0, 6));

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-1, -2, 0, 0, 0, -3));

        

        
        
        nb.solve(A);
    }
}
