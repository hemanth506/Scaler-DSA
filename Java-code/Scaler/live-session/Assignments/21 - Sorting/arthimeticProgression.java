import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class arthimeticProgression {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        Collections.sort(A);
        System.out.println(A);

        boolean isNotAggr = false;
        int interval = Math.abs(A.get(0) - A.get(1));
        for (int i = 1; i < N-1; i++) {
            int diff = Math.abs(A.get(i) - A.get(i+1));
            System.out.println(interval + " " + diff);
            if (interval != diff) {
                isNotAggr = true;
                break;
            }
        }
        System.out.println(isNotAggr ? 0 : 1);
        return isNotAggr ? 0 : 1;
    }
    
    public static void main(String[] args) {
        arthimeticProgression ag = new arthimeticProgression();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-251, -305, -323, -53, -215, -143, -107, -161, -179, -431, -449, -17, -341, -413, -35, -125, -197, -377, -269, -71, -359, -89, -233, -287, -395));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 4, 1));

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 39, 324, 267, 96, 77, 248, 58, 229, -18, 191, 172, 134, 286, 305, 210, 115, 20, 153));

        // 

        
        ag.solve(A);
    }
}
