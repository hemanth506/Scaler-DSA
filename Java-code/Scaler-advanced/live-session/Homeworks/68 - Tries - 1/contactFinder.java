import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Node {
    boolean isEnd;
    int count;
    HashMap<Character, Node> hm = new HashMap<>();
    Node()  {
        isEnd = false;
        count = 0;
    }
}

public class contactFinder {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B) {
        int N = A.size();
        Node root = new Node();
        ArrayList<Integer> ctArray = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if(A.get(i) == 0) {
                insertNode(root, B.get(i));
            } else {
                int ct = countContact(root, B.get(i));
                ctArray.add(ct);
            }
        }
        // System.out.println(ctArray);
        return ctArray;
    }

    // whenever there is a break, return the count directly.
    public int countContact(Node root, String word) {
        Node t = root;
        for(int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if(t.hm.containsKey(ch)) {
                t = t.hm.get(ch);
            } else {
                return 0;
            }
        }
        return t.count;
    }

    public void insertNode(Node root, String word) {
        Node t = root;
        for(int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if(t.hm.containsKey(ch)) {
                t = t.hm.get(ch);
                t.count++;
            } else {
                Node nn = new Node();
                t.hm.put(ch, nn);
                t = nn;
                t.count++;
            }
        }
        t.isEnd = true;
    }

    public static void main(String[] args) {
        contactFinder cf = new contactFinder();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(0, 0, 1, 1));
        // ArrayList<String> B = new ArrayList<String>(Arrays.asList("hack", "hacker", "hac", "hak"));
        
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(0, 1));
        ArrayList<String> B = new ArrayList<String>(Arrays.asList("abcde", "abc"));
        
        
        cf.solve(A, B);
    }
}
