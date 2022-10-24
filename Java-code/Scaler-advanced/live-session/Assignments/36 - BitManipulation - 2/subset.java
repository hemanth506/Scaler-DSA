import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;



public class subset {
    // Used Bit-Masking - lexicographically
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        int N = A.size();
        ArrayList<ArrayList<Integer>> total = new ArrayList<ArrayList<Integer>>();

        // LeftShift -> 1<<N = 2^N
        for (int i = 0; i < (1 << N); i++) {
            ArrayList<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < N; j++) {
                // RightShift -> (i>>j)
                if (((i >> j) & 1) == 1) {
                    System.out.println(i + " " + ((i >> j) & 1) + " " + j);
                    sub.add(A.get(j));
                }
            }
            System.out.println(sub);
            total.add(sub);
            System.out.println("-----------");
        }
        System.out.println(total);
        Collections.sort(total, new compareComparator());
        System.out.println(total);
        return total;
    }

    public static void main(String[] args) {
        subset sb = new subset();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        sb.subsets(A);
    }
}
class compareComparator implements Comparator<ArrayList<Integer>> {
    @Override
    public int compare(ArrayList<Integer> left, ArrayList<Integer> right) {
        int nL = left.size();
        int nR = right.size();
        for(int i = 0; i < nL; i++) {
            if(i == nR) {
                return 0;
            }
            if(left.get(i) < right.get(i)) {
                return -1;
            } else if (left.get(i) > right.get(i)) {
                return 1;
            }
        }

        return 0;
    }
}
