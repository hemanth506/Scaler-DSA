import java.util.Arrays;

public class cyclicPermutation {
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
    public int solve(String A, String B) {
        int M = B.length();
        String newStr = B + "@" + A + A;
        System.out.println(newStr);
        int[] lpsArr = LPS(newStr);
        int ct = 0;
        for(int i = 0; i < newStr.length(); i++) {
            ct += lpsArr[i] == M ? 1 : 0;
        }
        if(A.compareTo(B) == 0) {
            ct -= 1;
        }
        System.out.println(ct);
        return ct;
    }
    public static void main(String[] args) {
        cyclicPermutation cp = new cyclicPermutation();
        // String A = "1001";
        // String B = "0011";

        String A = "111";
        String B = "111";
        cp.solve(A, B);
    }
}
