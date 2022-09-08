import java.util.ArrayList;
import java.util.Arrays;

// Size of an subsequence array = 2^N. i,e.1<<N 
// It can be represented in the sent bits of numbers from 0 to 1<<N.
// If you find the subsequence sum == B, then return 1.
public class sumSubsequence {
    public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();

        for(int i = 0; i < 1<<N; i++) {
            int total = 0;
            for(int j = 0; j < N; j++) {
                if((i>>j & 1) == 1) {
                    total += A.get(j);
                }
            }
            if (total == B) {
                System.out.println(1);
                return 1;
            }
        }
        System.out.println(0);

        return 0;
    }
    public static void main(String[] args) {
        sumSubsequence ss = new sumSubsequence();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,20,13,4,5));
        int B = 18;
        ss.solve(A, B);
    }
}
