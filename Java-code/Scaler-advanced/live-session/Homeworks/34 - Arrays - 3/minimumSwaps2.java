import java.util.ArrayList;
import java.util.Arrays;

public class minimumSwaps2 {
    public ArrayList<Integer> swap(ArrayList<Integer> A, int id1, int id2) {
        int temp = A.get(id1);
        A.set(id1, A.get(id2));
        A.set(id2, temp);
        return A;
    }
    // Used send home technique
    public int solve(ArrayList<Integer> A) {

        int N = A.size();
        int swapCt = 0;
        for (int i = 0; i < N; i++) {
            if (A.get(i) == i) {
                continue;
            } else {
                swap(A, i, A.get(i));
                swapCt += 1;
                i--;
            }
        }
        System.out.println(swapCt);
        return swapCt;
    }
    public static void main(String[] args) {
        minimumSwaps2 ms2 = new minimumSwaps2();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,3,4,0));
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 0, 1, 3));
        
        ms2.solve(A);
    }
}
