import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge2SortedArr {
    public ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> C = new ArrayList<Integer>();
        int N = A.size();
        int M = B.size();

        int p1 = 0; int p2 = 0; int p3 = 0;
        while(p1 < N && p2 < M) {
            System.out.println(p1 + " " + p2);
            if(A.get(p1) <= B.get(p2)) {
                System.out.println(A.get(p1) + " <= " + B.get(p2));
                C.add(p3, A.get(p1));
                p1++; p3++;
            } else {
                System.out.println(A.get(p1) + " > " + B.get(p2));
                C.add(p3, B.get(p2));
                p2++; p3++;
            }
        }

        while(p1 < N) {
            C.add(p3, A.get(p1));
            p1++; p3++;
        }

        while(p2 < M) {
            C.add(p3, B.get(p2));
            p2++; p3++;
        }
        System.out.println(C);
        return C;
    }
    public static void main(String[] args) {
        merge2SortedArr mg = new merge2SortedArr();
        List<Integer> A = new ArrayList<Integer>(Arrays.asList(4, 7, 9 ));
        List<Integer> B = new ArrayList<Integer>(Arrays.asList(2, 11, 19 ));

        mg.solve(A, B);
    }
}
