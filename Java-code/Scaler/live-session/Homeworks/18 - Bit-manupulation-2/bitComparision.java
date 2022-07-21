import java.util.ArrayList;
import java.util.Arrays;

public class bitComparision {
    public int compressBits(ArrayList<Integer> A) {
        int N = A.size();
        int XOR = 0;
        for (int i = 0; i < N; i++) {
            XOR ^= A.get(i);
        }
        System.out.println(XOR);
        return XOR;
    }

    public static void main(String[] args) {
        bitComparision bit = new bitComparision();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 3, 5));
        bit.compressBits(A);
    }
}
