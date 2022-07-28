/*
 * Lets assume A > B
    A % M = B % M;
    A % M - B % M = 0;
    A % M - B % M + M = M;  //Adding M on both sides
    (A % M - B % M + M) % M = M % M;    //Taking Mode on both sides
    (A - B) % M = M % M;    //Since (A - B) % M = (A % M - B % M + M) % M
    A - B = M;  //Cancelling % M From both sides;

 */
public class AandBMod {
    public int solve(int A, int B) {
        int absol = Math.abs(A-B);
        return absol;
    }

    
    public static void main(String[] args) {
        AandBMod ab = new AandBMod();
        int A = 24;
        int B = 76;
        ab.solve(A, B);

    }
}
