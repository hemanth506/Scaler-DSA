import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class isDictionary {
    public int solve(ArrayList<String> A, String B) {
        int N = A.size();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < B.length(); i++) {
            hm.put(B.charAt(i), i);
        }
        System.out.println(hm);

        int j = 1;
        for (int i = 0; i < N - 1; i++) {
            int wordLenI = A.get(i).length();
            int wordLenJ = A.get(j).length();
            System.out.println(A.get(i) + " " + wordLenI + " " + A.get(j) + " " + wordLenJ);
            int minLen = 0;
            boolean tookJLen = false;
            if (wordLenI <= wordLenJ) {
                minLen = wordLenI;
            } else {
                minLen = wordLenJ;
                tookJLen = true;
            }
            innerloop: for (int k = 0; k < minLen; k++) {
                if (hm.get(A.get(i).charAt(k)) < hm.get(A.get(j).charAt(k))) {
                    break innerloop;
                } else if (hm.get(A.get(i).charAt(k)) == hm.get(A.get(j).charAt(k))) {
                    if (tookJLen && k == (minLen - 1)) {
                        System.out.println("It is not lexicographical");
                        return 0;
                    }
                } else {
                    System.out.println("It is not lexicographical");
                    return 0;
                }
            }
            j++;
        }
        System.out.println("It is lexicographical");
        return 1;
    }

    public static void main(String[] args) {
        isDictionary id = new isDictionary();
        // ArrayList<String> A = new ArrayList<String>(Arrays.asList("hello", "scaler",
        // "interviewbit"));
        // String B = "adhbcfegskjlponmirqtxwuvzy";

        ArrayList<String> A = new ArrayList<String>(Arrays.asList("fine", "none",
                "no"));
        String B = "qwertyuiopasdfghjklzxcvbnm";
        id.solve(A, B);
    }
}
