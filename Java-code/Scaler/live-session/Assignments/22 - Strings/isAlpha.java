import java.util.ArrayList;
import java.util.Arrays;

public class isAlpha {

    public int solve(ArrayList<Character> A) {
        int N = A.size();

        for(int i = 0; i < N; i++) {
            int value = (int) A.get(i);
            System.out.println(value);
            if(value >= 0 && value <=64 || value >= 91 && value <= 96) {
                System.out.println("return => " + value);
                return 0;
            }
        }
        System.out.println(A);
        return 1;
    }
    public static void main(String[] args) {
        isAlpha lw = new isAlpha();
        ArrayList<Character> A = new ArrayList<Character>(Arrays.asList('S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0'));
        lw.solve(A);
    }
}
