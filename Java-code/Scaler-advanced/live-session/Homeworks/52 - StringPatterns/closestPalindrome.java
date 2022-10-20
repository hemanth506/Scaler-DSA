import java.util.Arrays;

public class closestPalindrome {
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
    public String solve(String A) {
        int N = A.length();
        int[] AlpsArr = LPS(A);
        System.out.println(Arrays.toString(AlpsArr)); 
        int ct = 0;
        for(int i = 0; i< N; i++) {
            ct += AlpsArr[i] != 0 ? 1 : 0;
        }
        System.out.println("ct : " + ct);
        // if(ct == 1) {
        //     return "Yes";
        // }
        // return "No";

        StringBuilder reverseStr = new StringBuilder();
        for(int i = N-1; i >= 0; i--) {
            reverseStr.append(A.charAt(i));
        }
        System.out.println(reverseStr);
        String text = A + "$" + reverseStr;
        int[] lpsArr = LPS(text);
        System.out.println(Arrays.toString(lpsArr)); 
        return A;
    }
    public static void main(String[] args) {
        closestPalindrome cp = new closestPalindrome();
        String A = "abbba";
        // String A = "abba";

        // String A = "adaddb";

        cp.solve(A);
    }
}
