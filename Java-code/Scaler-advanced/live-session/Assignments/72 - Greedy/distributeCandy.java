import java.util.ArrayList;
import java.util.Arrays;

public class distributeCandy {
    public int candy(ArrayList<Integer> A) {
        int N = A.size();
        if(N == 1) {
            return 1;
        }

        int[] cl = new int[N];
        Arrays.fill(cl, 1);
        for(int i = 1; i < N; i++) {
            if(A.get(i) > A.get(i-1)) {
                cl[i] = cl[i-1]+1;
            }
        }

        int[] cr = new int[N];
        Arrays.fill(cr, 1);

        for(int i = N-2; i >= 0; i--) {
            if(A.get(i) > A.get(i+1)) {
                cr[i] = cr[i+1]+1;
            }
        }

        int res = 0;
        for(int i = 0; i < cr.length; i++) {
            res += Integer.max(cr[i], cl[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        distributeCandy dc = new distributeCandy();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 5, 2, 1));
        dc.candy(A);
    }
}
