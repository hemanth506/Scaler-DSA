
public class findSubsequence {
    public String solve(String A, String B) {
        int NA = A.length();
        int NB = B.length();

        int AI = 0;
        if (NA <= NB) {
            for (int i = 0; i < NB; i++) {
                if (A.charAt(AI) == B.charAt(i)) {
                    AI += 1;
                    if (AI == NA) {
                        System.out.println(AI + " " + (NA) + " Yes");
                        return "YES";
                    }
                }
            }
        } else {
            return "NO";
        }

        System.out.println(AI + " " + (NA) + " No");
        return "NO";
    }
    public static void main(String[] args) {
        findSubsequence fb = new findSubsequence();
        // String A = "bit";
        // String B = "dfbkjijgbbiihbmmt";
        String A = "apple";
        String B = "appel";
        fb.solve(A, B);
    }
}
