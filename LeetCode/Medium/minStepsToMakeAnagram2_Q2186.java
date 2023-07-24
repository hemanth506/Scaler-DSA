import java.util.HashMap;

public class minStepsToMakeAnagram2_Q2186 {
    public int minSteps(String s, String t) {
        int Ns = s.length();
        int Nt = t.length();
        HashMap<Character, Integer> hms = new HashMap<>();
        HashMap<Character, Integer> hmt = new HashMap<>();

        int maxL = Integer.max(Ns, Nt);
        for (int i = 0; i < maxL; i++) {
            if (i < Ns) {
                char ch = s.charAt(i);
                int ct = hms.getOrDefault(ch, 0) + 1;
                hms.put(ch, ct);
            }

            if (i < Nt) {
                char ch = t.charAt(i);
                int ct = hmt.getOrDefault(ch, 0) + 1;
                hmt.put(ch, ct);
            }
        }

        int Tsteps = 0;
        int Ssteps = 0;
        for (int i = 0; i < maxL; i++) {
            if (i < Nt) {
                char ch = t.charAt(i);
                if (hms.containsKey(ch)) {
                    int val = hms.get(ch) - 1;
                    if (val == 0) {
                        hms.remove(ch);
                    } else {
                        hms.put(ch, val);
                    }
                } else {
                    Tsteps += 1;
                }
            }

            if (i < Ns) {
                char ch = s.charAt(i);
                if (hmt.containsKey(ch)) {
                    int val = hmt.get(ch) - 1;
                    if (val == 0) {
                        hmt.remove(ch);
                    } else {
                        hmt.put(ch, val);
                    }
                } else {
                    Ssteps += 1;
                }
            }
        }

        System.out.println(Tsteps);
        System.out.println(Ssteps);

        int totalSteps = Ssteps + Tsteps;
        System.out.println(totalSteps);


        return totalSteps;
    }

    public static void main(String[] args) {
        minStepsToMakeAnagram2_Q2186 ms = new minStepsToMakeAnagram2_Q2186();
        String s = "leetcode";
        String t = "coats";

        // String s = "night";
        // String t = "thing";
        ms.minSteps(s, t);
    }
}
