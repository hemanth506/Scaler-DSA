import java.util.ArrayList;
import java.util.Arrays;

public class insertionStep {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int N = A.size();
        for(int i = N - 2; i >= 0; i--) {
            System.out.println(A.get(i));
            if(A.get(i) > A.get(N-1)) {
                int temp = A.get(i);
                A.set(i, A.get(N-1));
                A.set(N-1, temp);
            } else {
                break;
            }
        }
        System.out.println(A);
        return A;
    }
    public static void main(String[] args) {
        insertionStep is = new insertionStep();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,3,4,5,6,8,10,5));
        is.solve(A);
    }
}
