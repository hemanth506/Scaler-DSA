import java.util.ArrayList;
import java.util.Arrays;

public class toLower {

    public ArrayList<Character> to_lower(ArrayList<Character> A) {
        int N = A.size();

        for(int i = 0; i < N; i++) {
            if(A.get(i) >= 65 && A.get(i) <=90) {
                A.set(i, (char) (A.get(i) ^ 32));
            }
        }
        System.out.println(A);
        return A;
    }
    public static void main(String[] args) {
        toLower lw = new toLower();
        ArrayList<Character> A = new ArrayList<Character>(Arrays.asList('S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0'));
        lw.to_lower(A);
    }
}
