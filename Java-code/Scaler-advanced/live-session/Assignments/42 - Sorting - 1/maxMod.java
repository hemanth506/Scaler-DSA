import java.util.ArrayList;
import java.util.Arrays;

public class maxMod {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        int firstHigh = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            firstHigh = Integer.max(firstHigh, A.get(i));
        }

        int secHigh = Integer.MIN_VALUE;
        boolean allSame = true;
        for(int i = 0; i < N; i++) {
            if(A.get(i) != firstHigh) {
                secHigh = Integer.max(secHigh, A.get(i));
                allSame = false;
            }
        }

        int res = allSame ? 0 : secHigh % firstHigh;
        System.out.println(res);
        return res;
    }
    public static void main(String[] args) {
        maxMod mm = new maxMod();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 44, 3));
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5, 5, 5, 5, 5));

        mm.solve(A);
    }
}
