import java.util.ArrayList;
import java.util.Arrays;

public class maximumSatisfication {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        int ans = 0;

        // check from 31 to 0, when the set bit count is greater than or equal to 4, make the remaining unset bit values as "0" and add the bit values and return.
        for (int i = 31; i >= 0; i--) {
            int setBitCt = 0;
            for (int j = 0; j < N; j++) {
                if((A.get(j) >> i & 1) == 1) {
                    setBitCt += 1;
                }
            }

            if(setBitCt >= 4) {
                // System.out.println(i + " - " + setBitCt + " " + (1<<i));
                ans += 1<<i;
                for (int j = 0; j < N; j++) {
                    if((A.get(j) >> i & 1) == 0) {
                        A.set(j, 0);
                    }
                }
            }
        }
        System.out.println(ans);
        return ans;
    }
    public static void main(String[] args) {
        maximumSatisfication ms = new maximumSatisfication();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(10, 20, 15, 4, 14));
        ms.solve(A);
    }
}
