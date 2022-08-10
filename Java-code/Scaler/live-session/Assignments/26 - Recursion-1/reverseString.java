import java.util.Scanner;

public class reverseString {
    public void reverse(char[] sChar, int start, int end) {
        if (start >= end) {
            String string = new String(sChar); 
            System.out.println(string);
            return;
        }
        char charElt = sChar[start];
        sChar[start] = sChar[end];
        sChar[end] = charElt;
        reverse(sChar, start += 1, end -= 1);
        return;
    }
    public static void main(String[] args) {
        reverseString rs = new reverseString();

        Scanner  sc = new Scanner(System.in);
        // System.out.println("Enter string: ");
        String S = sc.nextLine();
        char[] sChar = S.toCharArray();
        int start = 0;
        int end = S.length() - 1;
        rs.reverse(sChar, start, end);
        sc.close();
    }
}
