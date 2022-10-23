
public class veryLargeNumber {
    public long factorial(int B, long mod) {
        if(B == 1) {
            return 1;
        }
        long val = (factorial(B-1, mod)% mod * B% mod) % mod;
        System.out.println(val);
        return val;
    }

    public long pow(long A, long B, long mod) {
        if (B == 0) {
            return 1;
        }
        long val = pow(A, B/2, mod);
        if (B % 2 == 0) {
            return (val% mod * val% mod)% mod;
        } else {
            return ((val% mod * val% mod)% mod * A) % mod;
        }
    }
    
    public int solve(int A, int B) {
        long mod = 1000000007;
        long factB = factorial(B, mod - 1);
        System.out.println("factB => " + factB);
        long longA = A;
        long powVal = pow(longA, factB, mod) % mod;
        System.out.println("powVal => " + powVal);
        return (int) powVal;
    }

    public static void main(String[] args) {
        veryLargeNumber vl = new veryLargeNumber();
        // int A = 2;
        // int B = 5;

        int A = 2;
        int B = 27;
        System.out.println(vl.solve(A, B));
    }
}
