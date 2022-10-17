
public class hiddenPattern {
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
        return lps;
    }
    public int solve(final String A, final String B) {
        int M = B.length();
        String text = B + "@" + A;
        int[] lpsArr = LPS(text);
        int ct = 0;
        for(int i = 0; i < text.length(); i++) {
            ct += lpsArr[i] == M ? 1 : 0;
        }
        System.out.println(ct);
        return ct;
    }
    public static void main(String[] args) {
        hiddenPattern hp = new hiddenPattern();
        // String A = "abababa";
        // String B = "aba";

        // String A = "mississipi";
        // String B = "ss";

        String A = "hello";
        String B = "hi";
        hp.solve(A, B);
    }
}
