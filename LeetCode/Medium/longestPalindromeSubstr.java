public class longestPalindromeSubstr {

    public int[] expand(String s, int id, int ind) {
        int N = s.length();
        int start = 0;
        int end = 0;
        int f = id;
        int l = ind;
        while (f >=0 && l < N) {
            System.out.println(N + " " + f + " " + l);
            if (s.charAt(f) == s.charAt(l)){
                start = f;
                end = l;
                f--;
                l++;
            } else {
                break;
            }
        }

        int arr[] = {start, end};
        return arr;
    }
    public String longestPalindrome(String s) {

        int N = s.length();
        int maxLen = 0;
        int startInd = 0;
        int endInd = 0;

        for(int i = 0; i < N-1; i++) {
            int[] indexes = expand(s, i, i);
            int lengthStr = 0;
            if(indexes[1] != indexes[0]) {
                lengthStr = indexes[1] - indexes[0] + 1;
                if (lengthStr > maxLen) {
                    maxLen = lengthStr;
                    System.out.println("MaxLen => " + maxLen);
                    startInd = indexes[0];
                    endInd = indexes[1];
                }
            }
        }

        // System.out.println("============================================");

        for(int i = 0; i < N-1; i++) {
            int[] indexes = expand(s, i, i+1);
            
            if(indexes[1] != indexes[0]) {
                int lengthStr = indexes[1] - indexes[0] + 1;
                if (lengthStr > maxLen) {
                    maxLen = lengthStr;
                    System.out.println("MaxLen => " + maxLen);
                    startInd = indexes[0];
                    endInd = indexes[1];
                }
            }
        }
        System.out.println("Final => " + s.substring(startInd, endInd+1));
        return s.substring(startInd, endInd+1);
    }

    public static void main(String[] args) {
        longestPalindromeSubstr lg = new longestPalindromeSubstr();
        String s = "babad";
        // String s = "aadamma";
        // String s = "asdf";
        // String s = "s";
        lg.longestPalindrome(s);
    }
}
