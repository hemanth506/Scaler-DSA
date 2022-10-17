import java.util.Arrays;

public class makeStringPalindrome {
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
    public int solve(String A) {
        int N = A.length();
        // String reverseStr = "";
        StringBuilder reverseStr = new StringBuilder();
        for(int i = N-1; i >= 0; i--) {
            reverseStr.append(A.charAt(i));
        }
        System.out.println(reverseStr);
        String text = A + "$" + reverseStr;
        System.out.println(text);
        int[] intArr = LPS(text);
        System.out.println(Arrays.toString(intArr));
        int charToAdd = N - intArr[2*N];
        System.out.println(charToAdd);
        return charToAdd;
    }
    public static void main(String[] args) {
        makeStringPalindrome msp = new makeStringPalindrome();
        // String A = "abc";
        // String A = "bb";
        String A = "babb";

        msp.solve(A);
    }
}
