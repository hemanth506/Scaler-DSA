
public class factorial {
    public int fact(int A) {
        if (A == 1) {
            return 1;
        }

        return fact(A - 1) * A;
    }
    public int solve(int A) {
        int res = fact(A);
        // System.out.println(res);
        return res;
    }
    public static void main(String[] args) {
        factorial fc = new factorial();
        int A = 4;
        fc.solve(A);
    }
}
