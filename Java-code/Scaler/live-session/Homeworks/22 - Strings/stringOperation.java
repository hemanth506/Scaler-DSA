import java.util.ArrayList;

public class stringOperation {
    public String solve(String A) {
        String doubleA = A+A;
        // System.out.println(doubleA);

        char[] doubleAarr = doubleA.toCharArray();
        ArrayList<Character> deleteA = new ArrayList<Character>();
        for (int i = 0; i < doubleAarr.length; i++) {
            if ((int) doubleAarr[i] < 65 || (int) doubleAarr[i] > 90) {
                if(doubleAarr[i] == 'a' || doubleAarr[i] == 'e' || doubleAarr[i] == 'i' || doubleAarr[i] == 'o' || doubleAarr[i] == 'u') {
                    deleteA.add('#');
                } else {
                    deleteA.add(doubleAarr[i]);
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for (Character s : deleteA) {
            sb.append(s);
        }

        // System.out.println(sb.toString());
        return sb.toString();
    }
    public static void main(String[] args) {
        stringOperation so = new stringOperation();
        String A = "AbcaZeoB";
        so.solve(A);
    }
}
