import java.util.ArrayList;
import java.util.Arrays;

public class countOfPairsWithTheGivenSum2 {
    public int iterateAndGetCt (int st, int ed, ArrayList<Integer> A, int checkVal) {
        st += 1;
        int ct = 0;
        for (int i = st; i < ed; i++) {
            if (A.get(i) == checkVal) {
                ct += 1;
            }
        }
        System.out.println(ct);
        return ct;
    }
    public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        int p1 = 0;
        int p2 = N - 1;
        int count = 0;
        int mod = 1000000007;
        boolean allSame = true;
        int firstVal = A.get(0);
        int allSameVal = 0;
        for(int i = 1; i < N; i++) {
            if(firstVal != A.get(i)) {
                allSame = false;
            } else {
                allSameVal = (allSameVal%mod + i%mod)%mod;
            }
        }
        System.out.println(allSame);

        if (allSame && N != 1) {
            int sumV = A.get(0) + A.get(N - 1);
            if(sumV == B) {
                System.out.println("allSameVal => " + allSameVal);
                return allSameVal;
            } else {
                return 0;
            }
        }

        while (p1 < p2) {
            if (p1 != p2) {
                System.out.println(p1 + " " + p2);
                int sumVal = A.get(p1) + A.get(p2);
                if (sumVal == B) {
                    int newP1 = p1;
                    int newP2 = p2;
                    int iterateCt = iterateAndGetCt(newP1, newP2, A, A.get(p1));
                    p2--;
                    count = (count%mod + iterateCt%mod)%mod + 1;
                }else if(sumVal < B) {
                    p1++;
                } else {
                    p2--;
                }
            }
        }
        System.out.println(count);
        return count;
    }
    public static void main(String[] args) {
        countOfPairsWithTheGivenSum2 cp2 = new countOfPairsWithTheGivenSum2();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1, 1));
        int B = 2;

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1));
        // int B = 2;

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 6, 6, 7, 9, 9));
        // int B = 13;
        cp2.solve(A, B);
    }
}
