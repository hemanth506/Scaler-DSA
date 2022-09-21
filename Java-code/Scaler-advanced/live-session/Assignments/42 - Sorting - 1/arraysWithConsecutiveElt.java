import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class arraysWithConsecutiveElt {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        System.out.println(A);
        int N = A.size();
        for(int i = 0; i < N-1; i++) {
            if(A.get(i+1) != A.get(i)+1){
                System.out.println("not consecutive");
                return 0;
            }
        }
        System.out.println("consecutive");
        return 1;
    }
    public static void main(String[] args) {
        arraysWithConsecutiveElt elt = new arraysWithConsecutiveElt();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(7,6,8,5,9));
        elt.solve(A);
    }
}
