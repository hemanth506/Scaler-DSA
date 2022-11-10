import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class firstNonRepeatingChar {
    public String solve(String A) {
        int N = A.length();
        Deque<Character> deq = new LinkedList<>();
        HashMap<Character, Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        deq.add(A.charAt(0));
        hm.put(deq.peekFirst(), 1);
        sb.append(deq.peekFirst());

        for(int i = 1; i < N; i++) {
            char curChar = A.charAt(i);

            if(!deq.isEmpty() && deq.peekFirst() == curChar) {
                // Remove value from hashset and deque
                deq.pollFirst();
                int val = hm.get(curChar)+1;
                hm.put(curChar, val);
            } else {
                // Adding value to hashset and deque
                if(!hm.containsKey(curChar)) {
                    deq.add(curChar);
                    hm.put(curChar, 1);
                } else {
                    int val = hm.get(curChar)+1;
                    hm.put(curChar, val);
                }
            }

            // printing element from the deque
            if(deq.isEmpty()) {
                sb.append('#');
            } else {
                while (deq.isEmpty() || hm.get(deq.peekFirst()) != 1) {
                    if(deq.isEmpty()) {
                        sb.append('#');
                        break;
                    } else {
                        System.out.println("===" + deq + "===");
                        deq.pollFirst();
                    }
                }
                System.out.println(deq);
                System.out.println(hm);
                if(!deq.isEmpty()) {
                    sb.append(deq.peekFirst());
                }
            }
        }
        System.out.println(sb);
        return sb.toString();
    }
    public static void main(String[] args) {
        firstNonRepeatingChar fn = new firstNonRepeatingChar();
        // String A = "abadbc";
        // String A = "abbcabc";
        // String A = "xxikrwmjvsvckfrqxnibkcasompsuyuogauacjrr";
        String A = "wbtvqwblyaqpwguxbvrvntsrwfgkjvjnwpkauifymvxkllfeurhbww";
        // tsrwfgkjvjnwpkauifymvxk
        fn.solve(A);
    }
}
// aaaabbb
// aaaacc#

// x#iiiiiiiiiiiiiiiiwwwwwwwwwwwwwwwwwwwwww

// wwwwwbtttttttttttttttlllllllllllllllllllllllssssssssss
// wwwwwbtttttttttttttttlllllllllllllllllllllllbbbbbbbsss

