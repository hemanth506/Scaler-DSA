
public class longestPalindromeSubString {
    int[] expand(char[] charArr, int p1, int p2, int N) {
        while (p1 >= 0 && p2 <= N-1 && charArr[p1] == charArr[p2]) {
            System.out.println(charArr[p1] + " " + p1 +" " + charArr[p2] + " " + p2);
            p1--;
            p2++;
        }
        System.out.println("p1 => " + (p1+1) + " p2 => " + (p2-1));
        int[] values = new int[3];
        values[0] = (p2 - p1 - 1);
        values[1] = (p1+1);
        values[2] = (p2);

        return values;
    }
    public String longestPalindrome(String A) {
        char[] charArr = A.toCharArray();
        int N = charArr.length;

        if (N == 2) {
            if (charArr[0] == charArr[1]) {
                return A;
            }
            else {
                return "" + A.charAt(0);
            }
        } else if (N == 1) {
            return A;
        }
        int maxLen = 0;
        int start = 0;
        int end = 0;

        for(int i = 1; i < N; i++) {
            int p1, p2;
            p1 = i; p2 = i;
            System.out.println("========"+i+"=======");
            int[] returnValue = expand(charArr, p1, p2, N);
            if (maxLen < returnValue[0]) {
                maxLen = returnValue[0];
                start = returnValue[1];
                end = returnValue[2];
            }
        }
        
        for(int i = 1; i < N-1; i++) {
            int p1, p2;
            p1 = i; p2 = i+1;
            System.out.println("========"+i+"=======");
            int[] returnValue = expand(charArr, p1, p2, N);
            if (maxLen < returnValue[0]) {
                maxLen = returnValue[0];
                start = returnValue[1];
                end = returnValue[2];
            }
        }
        String result = A.substring(start, end);
        System.out.println("Final => " + maxLen + " " + result);
        return result;
    }
    public static void main(String[] args) {
        longestPalindromeSubString lps = new longestPalindromeSubString();
        // String A = "zybdyzydx";
        // String A = "xbdyzzydbdyzydx";
        String A = "b";

        lps.longestPalindrome(A);
    }
}
