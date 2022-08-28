import java.util.HashSet;

public class longSubStrWithoutRepeatChar {
    public int expand(String s, int index) {
        int N = s.length();
        HashSet<Character> hs = new HashSet<>();
        // hs.add(s.charAt(index));
        int i = index;
        int j = index;
        boolean forward = true;
        boolean backward = true;

        while ((i) < N && (j) >= 0) {
            if (forward) {
                if (!hs.contains(s.charAt(i))) {
                    hs.add(s.charAt(i));
                    i+=1;
                } else {
                    forward = false;
                }
            }

            if (backward) {
                if (!hs.contains(s.charAt(j))) {
                    hs.add(s.charAt(j));
                    j-=1;
                } else {
                    backward = false;
                }
            }

            if (!backward && !forward) {
                break;
            }
        }
        // // forward check
        // for (int i = index + 1; i < N; i++) {
        //     if (!hs.contains(s.charAt(i))) {
        //         hs.add(s.charAt(i));
        //     } else {
        //         break;
        //     }
        // }

        // // backward check
        // for (int j = index - 1; j >= 0; j--) {
        //     if (!hs.contains(s.charAt(j))) {
        //         hs.add(s.charAt(j));
        //     } else {
        //         break;
        //     }
        // }
        System.out.println(hs);
        return hs.size();
    }
    public int lengthOfLongestSubstring(String s) {
        int N = s.length();

        int maxLen = 0;
        for(int i = 0; i < N; i++) {
            System.out.println("i => " + i + " ");
            int lengthUnique = expand(s, i);
            maxLen = Integer.max(maxLen, lengthUnique);
            System.out.println("============");
        }

        System.out.println("Final length => " + maxLen);
        return maxLen;
    }
    public static void main(String[] args) {
        longSubStrWithoutRepeatChar lg = new longSubStrWithoutRepeatChar();
        // String s = "abcabcbb";
        // String s = "bbbbb";
        // String s = "pwwkew";
        String s = "";

        lg.lengthOfLongestSubstring(s);
    }
}
