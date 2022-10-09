import java.util.ArrayList;
import java.util.Arrays;

public class kthElement {
    public int counter (ArrayList<Integer> A, int M, int N) {
        int ct = 0;
        for(int i = 0; i < N; i++) {
            if (A.get(i) < M) {
                ct += 1;
            }
        }
        return ct;
    }
    public int kthElt (ArrayList<Integer> A, int K) {
        int N = A.size();
        int maxV = Integer.MIN_VALUE;
        int minV = Integer.MAX_VALUE;    
        for(int i = 0; i < N; i++) {
            maxV = Integer.max(maxV, A.get(i));
            minV = Integer.min(minV, A.get(i));
        }
        if (minV == maxV) {
            return 0;
        }

        int l = minV;
        int h = maxV;
        int ans = 0;
        while(l <= h) {
            int m = (l + h) / 2;
            if (counter(A, m, N) <= K) {
                ans = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        System.out.println(ans);
        return ans;
    }
    public static void main(String[] args) {
        kthElement kl = new kthElement();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(4,1,5,15,6,2));
        int K = 4;
        kl.kthElt(A, K);
    }
}
