
public class primeModuloInverse {
    // Fermatt's little theorem
    public int binPow(int A, int mod, int mod2) {
        if(mod == 0) {
            return 1;
        }
        int val = binPow(A, mod/2, mod2);
        if(mod%2 == 0) {
            return (val%mod2 * val%mod2) %mod2;
        } else {
            return (val%mod2 * val%mod2 * A) %mod2;
        }
    }

    public int solve(int A, int B) {
        int result = binPow(A, B-2, B);
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {
        primeModuloInverse pmi = new primeModuloInverse();
        int A = 3;
        int B = 5;

        // int A = 6;
        // int B = 23;

        // int A = 7;
        // int B = 2;
        pmi.solve(A, B);
    }
}
