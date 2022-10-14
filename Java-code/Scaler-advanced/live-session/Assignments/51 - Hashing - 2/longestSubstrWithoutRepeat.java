import java.util.HashSet;

public class longestSubstrWithoutRepeat {
    public int lengthOfLongestSubstring(String A) {
        int N = A.length();

        int j = 0;
        int maxLength = 1;
        for(int i = 0; i < N; i++) {
            HashSet<Character> hs = new HashSet<Character>();
            j = i;
            System.out.println("j => " + j);
            while (j < N && !hs.contains(A.charAt(j))) {
                hs.add(A.charAt(j));
                j++;
            }
            System.out.println(hs);
            maxLength = Integer.max(maxLength, hs.size());

            if(i < N) {
                if(!hs.contains(A.charAt(i))) {
                    hs.add(A.charAt(i));
                } else {
                    hs.remove(A.charAt(i));
                }

            }
            System.out.println(hs);
            System.out.println("==============================");
        }
        System.out.println(maxLength);
        return maxLength;
    }
    public static void main(String[] args) {
        longestSubstrWithoutRepeat lr = new longestSubstrWithoutRepeat();
        // String A = "abcabcbb";
        String A = "AaaA";

        lr.lengthOfLongestSubstring(A);
    }
}
