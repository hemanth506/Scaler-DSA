
public class divisibleBy8 {

    public int solve(String A) {
        int N = A.length();

        int result = 0;
        if (N < 3) {
            int newA = Integer.parseInt(A);
            result = newA % 8 == 0 ? 1 : 0; 
            System.out.println("Lesser than 3 => " + newA % 8);
        }
        else {
            String strA = A.substring(A.length() - 3);
            int newA = Integer.parseInt(strA);
            result = newA % 8 == 0 ? 1 : 0; 
            System.out.println("Greater than 3 => " + newA % 8);
        }

        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {
        divisibleBy8 div = new divisibleBy8();
        String A = "123";
        div.solve(A);
    }
}
