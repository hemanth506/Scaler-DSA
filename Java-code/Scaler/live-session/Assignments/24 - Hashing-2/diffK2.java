import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class diffK2 {
    public int diffPossible(final List<Integer> A, int B) {
        int N = A.size();

        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < N; i++) {
            int x = A.get(i);
            int y = x - B;
            int z = x + B;
            if (hs.contains(z)) {
                return 1;
            }
            if (hs.contains(y)) {
                return 1;
            }
            hs.add(x);
        }
        System.out.println("doesn't exist");
        return 0;
    }

    public int diffPossibleBruteForce(final List<Integer> A, int B) {
        int N = A.size();
        outerloop:
        for(int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                // System.out.println(A.get(i) + " " +A.get(j));
                if (A.get(i) - A.get(j) == B) {
                    System.out.println(A.get(i) +"("+i + ") " +A.get(i) +"("+j+")");
                    break outerloop;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        diffK2 d2 = new diffK2();
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 5, 3));
        // int B = 2;

        List<Integer> A = new ArrayList<Integer>(Arrays.asList(34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96, 18, 2, 53, 100, 24, 47, 98, 69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15, 43, 73, 68, 29));
        int B = 97;
        
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(77, 28, 19, 21, 67, 15, 53, 25, 82, 52, 8, 94, 50, 30, 37, 39, 9, 43, 35, 48, 82, 53, 16, 20, 13, 95, 18, 67, 77, 12, 93, 0));
        // int B = 53;
        
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96, 18, 2, 53, 100, 24, 47, 98, 69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15, 43, 73, 68, 29));
        // int B = 97;

        d2.diffPossible(A, B);
        System.out.println("=======================");
        d2.diffPossibleBruteForce(A, B);
    }
}
