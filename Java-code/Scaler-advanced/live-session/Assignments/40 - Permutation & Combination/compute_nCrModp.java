
public class compute_nCrModp {
    // At some point recursion is not useful for large inputs because it increases the stack size, so at that point do it iteratively.
    public long factorialRecursion(long n, int p) {
        if(n == 0) {
            return 1;
        }
        System.out.println(n);
        return (factorialRecursion(n - 1, p)%p * n%p)%p;
    }

    public long factorial(long n, int p) {
        if(n == 0) {
            return 1;
        }
        long res = 1;
        for(int i = 2; i <= n; i++) {
            res = (res * i)%p;
        }
        return res;
    }

    public long inverseNumber(long num, int mod) {
        return binPow(num, mod-2, mod);
    }

    public long binPow(long num, int i, int mod) {
        if(i <= 1) {
            return 1;
        }
        long val = binPow(num, i/2, mod);
        if(i%2 == 0) {
            return (val%mod * val%mod)%mod;
        } else {
            return (val%mod * val%mod * num)%mod;
        }
    }

    // nCr % p = (n! / ((n-r)! * r!)) % p.
    // Should use fermatt's little theorem
    public int solve(int A, int B, int C) {
        int n = A; int r = B; int p = C;
        System.out.println("n = " + n + " r = " + r + " p = " + p);


        long NminusRVal = (n%p - r%p + p)%p;
        System.out.println("NminusRVal => " + NminusRVal);

        long NmRFact = factorial(NminusRVal, p);
        System.out.println("NmRFact => " + NmRFact);

        long RFact = factorial(r, p);
        System.out.println("RFact => " + RFact);

        long NmRIntoR = (NmRFact%p * RFact%p)%p;
        System.out.println("NmRIntoR => " + NmRIntoR);

        long NFact = factorial(n, p);
        long finalVal = (NFact%p * inverseNumber(NmRIntoR, p)%p) %p;
        // inverseNumber(NmRIntoR, p)
        System.out.println("inverseNumber => " + inverseNumber(NmRIntoR, p));

        System.out.println("finalVal => " + finalVal);

        int finalInt = (int) finalVal;
        System.out.println("finalInt => " + finalInt);

        return finalInt;
    }
    public static void main(String[] args) {
        compute_nCrModp nCr = new compute_nCrModp();
        // int A = 5;
        // int B = 2;
        // int C = 13;

        // int A = 1;
        // int B = 1;
        // int C = 1;

        int A = 1000000;
        int B = 1;
        int C = 1000000007;

        nCr.solve(A, B, C);
    }
}
