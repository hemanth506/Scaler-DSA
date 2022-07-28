
public class modString {
    public int findMod(String A, int P) {
        int N = A.length();

        long t = 1;
        long sum = 0;
        for (int i = N - 1;i >= 0; i--) {
            long parInt = Integer.parseInt(String.valueOf(A.charAt(i)));
            sum = (sum + parInt * t) % P;
            t = (t * 10) % P;
        }
        // System.out.println(sum);
        return (int) sum;
    }
    public static void main(String[] args) {
        modString md = new modString();
        String A = "43535321";
        int P = 47;
        md.findMod(A, P);
    }
}
