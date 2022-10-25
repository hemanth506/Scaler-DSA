
public class closestPalindromeByChangingOneChar {
    // two pointer technique
    public String solve(String A) {
        int N = A.length();
        int p1 = 0;
        int p2 = N - 1;

        int ct = 0;
        while (p1 <= p2) {
            System.out.println(p1 + " " + p2);
            if(A.charAt(p1) != A.charAt(p2)) {
                ct += 1;
            }
            p1++; p2--;
        }

        if(ct > 1) {
            System.out.println("Absolutly No");
            return "NO";
        }

        if(N%2 == 0 && ct == 0) {
            System.out.println("Even No");
            return "NO";
        }

        System.out.println(ct);
        return "YES";
    }
    public static void main(String[] args) {
        closestPalindromeByChangingOneChar cp = new closestPalindromeByChangingOneChar();
        String A = "abbba";
        // String A = "abba";

        // String A = "adaddb";

        cp.solve(A);
    }
}
