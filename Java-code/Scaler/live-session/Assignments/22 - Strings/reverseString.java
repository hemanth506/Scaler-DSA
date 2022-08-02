
public class reverseString {
    public String solve(String A) {
        String[] words = A.split(" ");
        int N = words.length;
        int l = 0;
        int r = N-1;
        while (l < r) {
            String temp = words[l];
            words[l] = words[r];
            words[r] = temp;
            l++;
            r--;
        }
        String finalElt = String.join(" ", words);
        System.out.println(finalElt);
        return finalElt;
    }
    public static void main(String[] args) {
        reverseString rs = new reverseString();
        String A = "the sky is blue";
        rs.solve(A);
    }
}
