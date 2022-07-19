import java.util.ArrayList;
import java.util.Arrays;

public class bitCompression {

    public int compressBits(ArrayList<Integer> A) {
        int N = A.size();
        int XORoper = 0;
        for (int i = 0; i < N; i++) {
            XORoper ^= A.get(i); 
        }

        return XORoper;
    }
    public static void main(String[] args) {
        bitCompression bit = new bitCompression();

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 3, 5));
        System.out.println(bit.compressBits(A));
    }
}
