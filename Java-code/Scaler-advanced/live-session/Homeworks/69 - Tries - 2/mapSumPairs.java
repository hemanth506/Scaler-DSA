import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Node {
    int val;
    HashMap<Character, Node> hm = new HashMap<>();
    Node(int x) {
        val = x;
    }
}

public class mapSumPairs {
    HashMap<String, Integer> hs = new HashMap<>();
    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<Integer> B) {
        int N = A.size();
        Node root = new Node(0);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            System.out.println("===========" + A.get(i) + " " + B.get(i) + "===========");
            if(B.get(i) == -1) {
                int sum = getSum(root, A.get(i));
                res.add(sum);
            } else {
                insertNode(root, A.get(i), B.get(i));
            }
        }
        System.out.println(res);
        return res;
    }

    public void insertNode(Node root, String word, int value) {
        Node t = root;
        int N = word.length();

        int existVal = 0;
        if(hs.containsKey(word)) {
            existVal = hs.get(word);
        }
        for(int i = 0; i < N; i++) {
            Character ch = word.charAt(i);
            if(t.hm.containsKey(ch)) {
                t = t.hm.get(ch);
                t.val += value - existVal;
                System.out.println("t.val = " + t.val);
            } else {
                Node nn = new Node(value);
                t.hm.put(ch, nn);
                t = nn;
                System.out.println("t.val = " + t.val);
            }
        }
        hs.put(word, value);
    }

    public int getSum(Node root, String word) {
        Node t = root;
        int val = 0;
        for(int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if(t.hm.containsKey(ch)) {
                t = t.hm.get(ch);
                if(i == word.length()-1) {
                    System.out.println("= ch = " + ch);
                    val = t.val;
                }
            } else {
                return 0;
            }
        }
        System.out.println(t.val);
        return val;
    }
    
    public static void main(String[] args) {
        mapSumPairs sp = new mapSumPairs();
        // ArrayList<String> A = new ArrayList<String>(Arrays.asList("apple", "ap", "app", "ap"));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(3, -1, 2, -1));

        // ArrayList<String> A = new ArrayList<String>(Arrays.asList("ban", "banana", "ba"));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(10, -1, -1));

        ArrayList<String> A = new ArrayList<String>(Arrays.asList("aaac", "aaca", "babb", "ccca", "ccbc", "ccac", "bcbb", "abbb", "bbca", "cbba", "ccaa", "ccbb", "baac", "bbaa", "caaa", "aaca", "cbcb", "abaa", "accb", "abcb", "bb", "cb", "ab", "ba", "aa", "cc", "aa", "aa", "bc", "aa"));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(42, 68, 35, 1, 70, 25, 79, 59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 ));
        
        sp.solve(A, B);
    }
}
