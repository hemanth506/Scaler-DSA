

public class kthSymbol {
    public int solveBruteForce(int A, int B) {
        StringBuffer strBf = new StringBuffer("0");
        for(int i = 1; i < A; i++) {
            int N = strBf.length();
            StringBuffer strBfOrg = new StringBuffer();
            for (int j = 0; j < N; j++) {
                if(strBf.charAt(j) == '0') {
                    strBfOrg.append("0");
                    strBfOrg.append("1");
                }
                else if (strBf.charAt(j) == '1') {
                    strBfOrg.append("1");
                    strBfOrg.append("0");
                }
            }
            System.out.println(strBfOrg);
            strBf = strBfOrg;
        }

        int val = strBf.charAt(B-1);
        System.out.println(val + " " + val%48);
        return val%48;
    }

    // Using recursion
    public StringBuffer solveKth(int A, StringBuffer strBf) {
        if (A == 0) {
            StringBuffer strBfInitial = new StringBuffer("0");
            return strBfInitial;
        }
        StringBuffer strBfCurrent = solveKth(A - 1, strBf);
        StringBuffer strBfOrgNew = new StringBuffer();
        for (int j = 0; j < strBfCurrent.length(); j++) {
            if(strBfCurrent.charAt(j) == '0') {
                strBfOrgNew.append("0");
                strBfOrgNew.append("1");
            }
            else if (strBfCurrent.charAt(j) == '1') {
                strBfOrgNew.append("1");
                strBfOrgNew.append("0");
            }
        }
        return strBfOrgNew;
    }
    
    public int solve(int A, int B) {
        StringBuffer strBf = new StringBuffer("0");
        StringBuffer finalstrBuf = solveKth(A, strBf);
        int val = finalstrBuf.charAt(B-1)%48;
        System.out.println(finalstrBuf + " " + val);
        return val;
    }
    public static void main(String[] args) {
        kthSymbol kth = new kthSymbol();
        int A = 5;
        int B = 3;

        // int A = 5;
        // int B = 5;
        
        // int A = 6;
        // int B = 18;
        kth.solveBruteForce(A, B);
        kth.solve(A, B);
    }
}
