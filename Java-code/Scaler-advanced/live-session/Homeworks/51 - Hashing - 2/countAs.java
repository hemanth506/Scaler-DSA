
public class countAs {
    public int permutations(int N) {
        if (N == 0) {
            return 0;
        }
        return permutations(N - 1) + N;
    }
    public int solve(String A) {
        int N = A.length();
        int ct = 0;
        for(int i = 0; i < N; i++) {
            if(A.charAt(i) == 'a') {
                ct += 1;
            }
        }

        return permutations(ct);
    }
    public static void main(String[] args) {
        countAs as = new countAs();
        String A = "ababababa";
        as.solve(A);
    }
}
