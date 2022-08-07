import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class pairsWithGivenXOR {
    public int solveBruteForce(ArrayList<Integer> A, int B) {
        int N = A.size();
        int ct = 0;
        for(int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (j != i && (A.get(i)^A.get(j)) == B) {
                    ct += 1;
                }
            }
        }
        System.out.println(ct);
        return ct;
    }
    public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        HashSet<Integer> hs = new HashSet<>();
        int ct = 0;
        for(int i = 0; i < N; i++) {
            if (hs.contains(A.get(i))) {
                ct += 1;
            }
            int val = A.get(i) ^ B;
            hs.add(val);
        }
        System.out.println(ct);
        return 1;
    }
    public static void main(String[] args) {
        pairsWithGivenXOR pXOR = new pairsWithGivenXOR();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5, 4, 10, 15, 7, 6));
        int B = 5;
        pXOR.solve(A, B);
    }
}
