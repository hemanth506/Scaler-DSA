import java.util.ArrayList;
import java.util.Arrays;

public class differentBitSumXOR {
    public int cntBits(ArrayList<Integer> A) {
        int N = A.size();
        int mod = 1000000007;
        long totalSum = 0;
        for (int bit = 0; bit < 32; bit++) {
            long setCt = 0;
            for(int i = 0; i < N; i++) {
                if (((A.get(i) >> bit) & 1) == 1) {
                    setCt += 1;
                }
            }

            // we need to check of for the required bit, not for the entire 32 bit which doesn't have any one in that bit. SO we are multiplying it by setBt.
            totalSum += ((setCt * (N - setCt))% mod);
            System.out.println(N + " " + setCt + " " + (setCt * (N - setCt)) + " " + totalSum);
            totalSum %= mod;
        }
        
        // we are checking that only for each bit in "totalSum" but if we want to make it as pair wise, we have to multiple by 2, since pair is a combo of 2.
        int diffBit = (int) (totalSum*2) % mod;
        System.out.println(diffBit);
        return diffBit;
    }

    public static void main(String[] args) {
        differentBitSumXOR df = new differentBitSumXOR();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 3, 5));
        df.cntBits(A);
    }
}
