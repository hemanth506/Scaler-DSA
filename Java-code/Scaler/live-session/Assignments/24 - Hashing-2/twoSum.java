import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class twoSum {
    public ArrayList<Integer> twoSum2(final List<Integer> A, int B) {
        int N = A.size();

        int startId = 0;
        int endId = N - 1;
        boolean exists = false;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < N; i++) {
            int a = A.get(i);
            int b = B - a;
            // System.out.println("values => " + b + " " + a );
            if (hm.containsKey(b)) {
                System.out.println(hm.get(b) + " " + i);
                if (i < endId) {
                    startId = hm.get(b);
                    endId = i;
                    System.out.println(startId + " " + endId);
                    exists = true;
                }
            }
            // System.out.println("put => " + a + " index => " + i);
            if (!hm.containsKey(a)) {
                hm.put(a, i);
            }
        }

        System.out.println(hm);

        ArrayList<Integer> C = new ArrayList<>();
        if (exists) {
            C.add(startId + 1);
            C.add(endId + 1);
        } 
        System.out.println(C);
        return C;
    }
    public static void main(String[] args) {
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 7, 11, 15));
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8));
        // int B = -3;

        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(-10, -10, -10));
        // int B = -5;

        List<Integer> A = new ArrayList<Integer>(Arrays.asList(-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3));
        int B = -1;
        twoSum tw = new twoSum();
        tw.twoSum2(A, B);
    }
}
