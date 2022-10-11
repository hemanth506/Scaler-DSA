import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class pairWithDifferance {
    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        System.out.println(A);
        int N = A.size();
        int p1 = 0;
        int p2 = 1;
        int count = 0;
        // HashSet<Integer>
        int tempVal = 0;
        while (p2 < N && p1 < N) {
            int minusVal = A.get(p2) - A.get(p1);
            if (minusVal == B && A.get(p2) != tempVal && p2 != p1) {
                System.out.println(A.get(p2) + "||" + p2 + " "+A.get(p1) + "||" + p1 + " count ++");
                count += 1;
                tempVal = A.get(p2);
                p2++;
            } else {
                System.out.println(A.get(p2) + "||" + p2 + " "+A.get(p1) + "||" + p1 );
            }

            if (minusVal < B) {
                p2++;
            } else {
                p1++;
            }
        }
        System.out.println(count);
        return count;
    }
    public static void main(String[] args) {
        pairWithDifferance pd = new pairWithDifferance();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,5,3,2,4));
        // int B = 3;

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(8, 5, 1, 10, 5, 9, 9, 3, 5, 6, 6, 2, 8, 2, 2, 6, 3, 8, 7, 2, 5, 3, 4, 3, 3, 2, 7, 9, 6, 8, 7, 2, 9, 10, 3, 8, 10, 6, 5, 4, 2, 3));
        // int B = 3;

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2));
        int B = 0;

        pd.solve(A, B);
    }
}
