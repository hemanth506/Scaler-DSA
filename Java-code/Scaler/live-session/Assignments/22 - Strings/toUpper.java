import java.util.ArrayList;
import java.util.Arrays;

public class toUpper {

    public ArrayList<Character> to_upper(ArrayList<Character> A) {
        int N = A.size();

        for(int i = 0; i < N; i++) {
            if(A.get(i) >= 97 && A.get(i) <=122) {
                A.set(i, (char) (A.get(i) ^ 32));
            }
        }
        System.out.println(A);
        return A;
    }
    public static void main(String[] args) {
        toUpper lw = new toUpper();
        ArrayList<Character> A = new ArrayList<Character>(Arrays.asList('S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0'));
        lw.to_upper(A);
    }
}
