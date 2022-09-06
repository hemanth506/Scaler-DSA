import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class minXORVal {
    public int findMinXor(ArrayList<Integer> A) {
        int N = A.size();
        Collections.sort(A);
        int minV = Integer.MAX_VALUE;
        for(int i = 0; i < N-1; i++) {
            int XOR = A.get(i) ^ A.get(i + 1);
            minV = Integer.min(minV, XOR);
        }
        System.out.println(minV);
        return minV;
    }
    
    public static void main(String[] args) {
        minXORVal minXor = new minXORVal();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(0, 2, 5, 7));
        minXor.findMinXor(A);
    }
}
