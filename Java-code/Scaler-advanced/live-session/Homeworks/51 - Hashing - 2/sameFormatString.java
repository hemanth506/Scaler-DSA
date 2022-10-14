
public class sameFormatString {
    public int solveOLD(final String A, final String B) {
        int NA = A.length();
        int NB = B.length();

        if(NB < NA) {
            return 0;
        }

        System.out.println(B);
        
        char firstChar = B.charAt(0);
        if(firstChar != A.charAt(0)) {
            return 0;
        }
        
        boolean isSame = false;
        int j;
        for(j = 1; j < NB; j++) {
            if(firstChar != B.charAt(j)) {
                break;
            }
        }
        System.out.println("j = " + j);

        
        int k = 1;
        for(int i = j; i < NB; i++) {
            if(B.charAt(i - 1) != B.charAt(i)) {
                System.out.println(B.charAt(i) + " " + A.charAt(k) + " " + k + " ");
                if(B.charAt(i) != A.charAt(k)) {
                    // isSame = true;
                    break;
                }
                k++;
            }
        }
        // if(k < NA) {
        //     isSame = true;
        // }

        char lastChar = B.charAt(NB - 1);
        if(lastChar != A.charAt(NA-1)) {
            return 0;
        }
        

        System.out.println(NA +  " " + isSame);
        return isSame ? 0 : 1;
    }
    
    public int solve(final String A, final String B) {
        int NA = A.length();
        int NB = B.length();

        if(B.charAt(0) != A.charAt(0)) {
            System.out.println("First not equal");
            return 0;
        }
        int j;
        for(j = 1; j < NB; j++) {
            if(B.charAt(0) != B.charAt(j)) {
                break;
            }
        }
        System.out.println(j);

        int k = 1;
        for(int i = j; i < NB; i++) {
            if(B.charAt(i - 1) != B.charAt(i)) {
                System.out.println(B.charAt(i));
                if(k == NA) {
                    System.out.println("extra");
                    return 0;
                }
                if(B.charAt(i) != A.charAt(k)) {
                    // isSame = true;
                    break;
                }
                k++;
            }
        }
        System.out.println(k + " " + NA);
        return k == NA ? 1 : 0;
    }
    
    
    public static void main(String[] args) {
        sameFormatString ss = new sameFormatString();
        // String A = "HIRED";
        // String B = "HHHIIIRRRRREEEEEDDDDD";

        // String A = "HIRE";
        // String B = "HHIIIRRE";

        // String A = "HIR";
        // String B = "HIRE";

        // String A = "HIRE";
        // String B = "HIR";

        // String A = "HIRE";
        // String B = "HHIIIR";
        
        // String A = "HIRE";
        // String B = "HIRE";

        String A = "A";
        String B = "B";

        ss.solve(A, B);
    }
}
