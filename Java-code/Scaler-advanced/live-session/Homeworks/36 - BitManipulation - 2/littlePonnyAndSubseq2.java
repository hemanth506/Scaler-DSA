
public class littlePonnyAndSubseq2 {
    public String solve(String A) {
        int N = A.length();
        char minV = A.charAt(0);
        int ind = 0;
        for(int i = 1 ; i < N; i++) {
            if(minV > A.charAt(i) && i != N-1) {
                minV = A.charAt(i);
                ind = i;
            }
        }
        System.out.println(minV + " " + ind);
        char secMin = A.charAt(ind+1);
        for(int i = ind+1 ; i < N; i++) {
            if(secMin > A.charAt(i)) {
                secMin = A.charAt(i);
            }
        }
        System.out.println(secMin);
        System.out.println(minV+""+secMin);

        return minV+""+secMin;
    }
    public static void main(String[] args) {
        littlePonnyAndSubseq2 lp = new littlePonnyAndSubseq2();
        // String A = "hemanth";
        // String A = "abcdsfhjagj";
        String A = "ksdjgha";
        lp.solve(A);
    }
}
