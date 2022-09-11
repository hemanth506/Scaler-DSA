// Finding Factors.
public class abModulo {
    public int solve(int A, int B) {
        if (A > B) {
            return A - B;
        } else {
            int val = B - A;
            if (A % val == B % val) {
                return val;
            }
            // System.out.println(val);
            int maxPossibleM = 0;
            for (int i = 1; i <= (val / 2); i++) {
                // System.out.println(i);
                if (val % i == 0) {
                    // System.out.println(i + " " + val / i);
                    maxPossibleM = Integer.max(maxPossibleM, val / i);
                }
            }
            // System.out.println(maxPossibleM);
            return maxPossibleM;
        }
    }
    public static void main(String[] args) {
        abModulo ab = new abModulo();
        int A = 5;
        int B = 10;
        ab.solve(A, B);
    }
}
