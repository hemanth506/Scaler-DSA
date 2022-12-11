import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class assignMiceToHoles {
    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A);
        Collections.sort(B);

        int total = 0;
        for(int i = 0; i < A.size(); i++) {
            total = Integer.max(total, Math.abs(A.get(i) - B.get(i)));
        }
        System.out.println(total);
        return total;
    }
    public static void main(String[] args) {
        assignMiceToHoles mc = new assignMiceToHoles();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-4, 2, 3));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(0, -2, 4));
        mc.mice(A, B);
    }
}
