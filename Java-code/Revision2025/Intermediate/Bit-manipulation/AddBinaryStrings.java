import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AddBinaryStrings {
    public static void main(String[] args) {
        // String A = "10110";
        // String B = "1010";

        String A = "110";
        String B = "10";
        System.out.println(addBinary(A, B));
    }

    public static String addBinary(String A, String B) {
        int N = A.length();
        int M = B.length();

        int maxLen = Math.max(N, M);
        int[] a = new int[maxLen];
        int[] b = new int[maxLen];
        for (int i = 0; i < maxLen; i++) {
            if(i < N) {
                a[maxLen-i-1] = A.charAt(N-i-1) - '0';
            }
            if(i < M) {
                b[maxLen-i-1] = B.charAt(M-i-1) - '0';
            }
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        StringBuilder result = new StringBuilder();

        int carry = 0;
        int i = maxLen - 1;
        while (i >= 0) {
            int sum = a[i] + b[i] + carry / 2;
            result.append(sum % 2);
            carry = sum;
            i--;
        }

        if (carry / 2 > 0) {
            result.append(carry / 2);
        }
        String res = result.reverse().toString();
        System.out.println(res);

        return res;
    }
}
