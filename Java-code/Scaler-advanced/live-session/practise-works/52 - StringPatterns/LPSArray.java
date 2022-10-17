import java.util.Arrays;

public class LPSArray {
    public int[] LPS (String str) {
        int N = str.length();
        int[] lps = new int[N];
        lps[0] = 0;
        for(int i = 1; i < N; i++) {
            int x = lps[i-1];
            while(str.charAt(i) != str.charAt(x)) {
                if(x == 0) {
                    x = -1; break;
                }
                x = lps[x-1];
            }
            lps[i] = x+1;
        }
        System.out.println(Arrays.toString(lps));
        return lps;
    }
    public static void main(String[] args) {
        LPSArray lps = new LPSArray();
        String A = "aabaaba";
        lps.LPS(A);
    }
}
