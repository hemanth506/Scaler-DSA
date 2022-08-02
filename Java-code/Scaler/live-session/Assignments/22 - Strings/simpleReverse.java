// Don't use String in the array, because it will create a duplicate of that and the time complexicity to O(N^2)

public class simpleReverse {
    public String solve(String A) {
        int N = A.length();
        char[] charA = A.toCharArray();
        int l = 0;
        int r = N-1;
        while (l <= r) {
            char temp = charA[l];
            charA[l] = charA[r];
            charA[r] = temp;
            l++;
            r--;
        }
        return new String(charA);
    }
    public static void main(String[] args) {
        simpleReverse sr = new simpleReverse();
        String A = "scaler";
        sr.solve(A);
    }
}
