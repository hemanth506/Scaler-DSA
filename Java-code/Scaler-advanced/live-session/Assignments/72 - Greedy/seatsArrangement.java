import java.util.ArrayList;

public class seatsArrangement {

    public int seats(String A) {
        int N = A.length();
        long mod = 10000003;
        ArrayList<Integer> indArr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if(A.charAt(i) == 'x') {
                indArr.add(i);
            }
        }

        int m = indArr.size();
        int mid = m / 2;
        long res = 0;
        int k = 1;
        while(mid >= k) {
            int ind = mid - k;
            res += (indArr.get(mid) - indArr.get(ind) - k)%mod;
            res %= mod;
            k++;
        }


        k = 1;
        while ((mid+k) < m) {
            int ind = mid + k;
            res += (indArr.get(ind) - indArr.get(mid) - k)%mod;
            res %= mod;
            k++;
        }

        return (int)(res%mod);
    }
    public static void main(String[] args) {
        seatsArrangement sa = new seatsArrangement();
        String A = "x....x..x..x...x....x";
        // String A = "....x..xx...x..";

        sa.seats(A);
    }
}
