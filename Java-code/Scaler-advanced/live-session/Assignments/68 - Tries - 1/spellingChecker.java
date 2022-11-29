import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Node {
    boolean isEnd;
    HashMap<Character, Node> hm = new HashMap<>();
    Node () {
        isEnd = false;
    }
}
public class spellingChecker {
    
    public ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
        Node root = new Node();
        for(int i = 0; i < A.size(); i++) {
            insertword(root, A.get(i));
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < B.size(); i++) {
            result.add(searchWord(root, B.get(i)));
        }

        return result;
    }
    public void insertword(Node root, String word) {
        Node t = root;
        int N = word.length();
        for(int i = 0; i < N; i++) {
            Character ch = word.charAt(i);
            if(t.hm.containsKey(ch)) {
                t = t.hm.get(ch);
            } else {
                Node newNode = new Node();
                t.hm.put(ch, newNode);
                t = newNode;
            }
        }
        t.isEnd = true;
    }

    public int searchWord(Node root, String word) {
        Node t = root;
        int N = word.length();
        for(int i = 0; i < N; i++) {
            Character ch = word.charAt(i);
            if(t.hm.containsKey(ch)) {
                t = t.hm.get(ch);
            } else {
                return 0;
            }
        }
        return t.isEnd ? 1 : 0;
    }
    public static void main(String[] args) {
        spellingChecker sc = new spellingChecker();
        ArrayList<String> A = new ArrayList<String>(Arrays.asList("hat", "cat", "rat"));
        ArrayList<String> B = new ArrayList<String>(Arrays.asList("cat", "ball"));
        sc.solve(A, B);
    }
}
