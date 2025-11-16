import java.util.*;

public class WindowString {
    public static void main(String[] args) {
        String A = "ADOBECODEBANC";
        String B = "ABC";

        // String A = "Aa91b";
        // String B = "ab";

        // String A = "A";
        // String B = "A";

        // String A = "AAAAAA";
        // String B = "AA";
        WindowString ws = new WindowString();
        ws.minWindow(A, B);
    }

    public String minWindow(String A, String B) {
        int NA = A.length();
        int NB = B.length();

        if (NB > NA) return "";

        HashMap<Character, Integer> hmA = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hmB = new HashMap<Character, Integer>();
        for (char ch : B.toCharArray()) {
            hmB.put(ch, hmB.getOrDefault(ch, 0) + 1);
        }

        int required = hmB.size();
        int formed = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        int i = 0, j = 0;
        while (j < NA) {
            char chj = A.charAt(j);

            if (hmB.containsKey(chj)) {
                hmA.put(chj, hmA.getOrDefault(chj, 0) + 1);
                if (hmA.get(chj).intValue() == hmB.get(chj).intValue()) {
                    formed++;
                }
            }

            while (formed == required) {
                int curLen = j - i + 1;
                if (curLen < minLen) {
                    minLen = curLen;
                    minStart = i;
                }

                char chi = A.charAt(i);
                if(hmB.containsKey(chi)) {
                    if(hmA.get(chi).intValue() == hmB.get(chi).intValue()) {
                        formed--;
                    }
                    hmA.put(chi, hmA.get(chi) - 1);
                }
                i++;
            }
            j++;
        }

        System.out.println("Final " + minLen + " " + minStart + " " + A.substring(minStart,  minStart + minLen));
        return (minLen == Integer.MAX_VALUE) ? "" : A.substring(minStart, minStart + minLen);
    }

}