import java.util.ArrayList;
import java.util.Arrays;

public class countOfPairsWithTheGivenSum {
    public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        int p1 = 0;
        int p2 = N - 1;
        int count = 0;
        while (p1 < p2) {
            if (p1 != p2) {
                int sumVal = A.get(p1) + A.get(p2);
                if(sumVal == B) {
                    count += 1;
                    p2--;
                }

                if (sumVal > B) {
                    p2--;
                } else {
                    p1++;
                }
            }
        }
        System.out.println(count);
        return count;
    }
    public static void main(String[] args) {
        countOfPairsWithTheGivenSum cp = new countOfPairsWithTheGivenSum();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        int B = 5;
        cp.solve(A, B);
    }
}
