import java.util.ArrayList;
import java.util.Arrays;

public class timeToEquality {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();

        int maxVal = A.get(0);
        for (int i = 1; i < N; i++) {
            if(maxVal < A.get(i)) {
                maxVal = A.get(i);
            }
        }
        System.out.println(maxVal);

        int total = 0;
        for (int j = 0; j < N; j++) {
            total += maxVal - A.get(j);
        }
        System.out.println(total);
        return total;
    }
    public static void main(String[] args) {
        timeToEquality tq = new timeToEquality();

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList( 731, 349, 490, 781, 271, 405, 811, 181, 102, 126, 866, 16, 622, 492, 194, 735 ));
        tq.solve(A);
    }
}
