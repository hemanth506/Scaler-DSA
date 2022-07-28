/* ABCDE => Should minus with 64
* will start => 65
*      end  =>  90
*
*
*  abcde => should minus with 96
* will start => 97 
*      end  =>  122
*/

public class excelColumnNumber {
    public int titleToNumber(String A) {
        int N = A.length();

        int p = 26;
        int t = 1;
        int sum = 0;
        int asciiNum = 0;
        for (int i = N - 1; i >= 0; i--) {
            asciiNum = (A.charAt(i) - 64);
            sum = sum + t * asciiNum;
            t = t * p;
            System.out.println(A.charAt(i) + " " + asciiNum + " " + sum);
        }
        System.out.println(sum);
        return sum;
    }
    public static void main(String[] args) {
        excelColumnNumber ex = new excelColumnNumber();
        String A = "abCdE";
        ex.titleToNumber(A);
    }
}
