
public class checkPalindrome {

    public boolean isPal(char[] Achar, int s, int e) {
        if (s > e) {
            return true;
        }
        if (Achar[s] == Achar[e] && isPal(Achar, s+=1, e-=1)) {
            System.out.println(Achar[s] + " " + Achar[e]);
            return true;
        }
        return false;
    }

    public int solve(String A) {
        int N = A.length();
        char[] Achar = A.toCharArray();
        int s = 0;
        int e = N - 1;

        int res = isPal(Achar, s, e) ? 1: 0;
        System.out.println(res);
        return res;
    }
    public static void main(String[] args) {
        checkPalindrome ch = new checkPalindrome();
        // String A = "naman";
        String A = "strings";

        ch.solve(A);
    }
}
