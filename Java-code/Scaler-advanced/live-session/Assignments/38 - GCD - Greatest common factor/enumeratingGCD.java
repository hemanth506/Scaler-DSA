
/* Question: 
 * You are given a number A and a number B. Greatest Common Divisor (GCD) of all numbers between A and B inclusive is taken (GCD(A, A+1, A+2 ... B)).
 */

/* Observation:
 * Since the constraints are given as GCD(A, A+1, A+2 ... B) such that
 * EG1: A = 1, B = 5
 *      GCD(1,2,3,4,5) => 
 *          GCD(1,2) = 1
 *              GCD(1,3) = 1
 *                  GCD(1, 4) = 1
 *                      GCD(1,5) = 1
 * 
 * So if the value are different the GCD will be 1.
 * 
 * EG2: A = 10, A = 10
 *      GCD(10, 10) => 10
 * So if value A and B are same then the GCD with be A.
 * 
 */
public class enumeratingGCD {
    public String solve(String A, String B) {
        if(B.equals(A)) {
            System.out.println("Return " + A);
            return A;
        } else {
            return "1";
        }
    }
    public static void main(String[] args) {
        enumeratingGCD en = new enumeratingGCD();
        // String A = "1";
        // String B = "3";

        String A = "678728391838182039102";
        String B = "678728391838182039103";
        System.out.println(en.solve(A, B));
    }
}
