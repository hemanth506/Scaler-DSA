import java.util.ArrayList;
import java.util.Arrays;

public class isAlphaNum {
    public int solve(ArrayList<Character> A) {
        int N = A.size();

        for(int i = 0; i < N; i++) {
            int value = (int) A.get(i);
            if(value >= 0 && value <= 47 || value >= 58 && value <= 64 || value >= 91 && value <= 96 || value >= 123 && value <= 126) {
                return 0;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        isAlphaNum aln = new isAlphaNum();
        ArrayList<Character> A = new ArrayList<Character>(Arrays.asList('S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'));
        aln.solve(A);

    }
}
