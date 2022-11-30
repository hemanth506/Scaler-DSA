import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Node {
    boolean isEnd;
    HashMap<Character, Node> hm = new HashMap<>();
    Node()  {
        isEnd = false;
    }
}
public class shortestUniquePrefix {
    public ArrayList<String> prefix(ArrayList<String> A) {
        Node root = new Node();
        for(int i = 0; i < A.size(); i++) {
            insertNode(root, A.get(i));
        }

        ArrayList<String> uniqStr = new ArrayList<>();
        for(int i = 0; i < A.size(); i++) {
            int id = uniqueIndex(root, A.get(i));
            uniqStr.add(A.get(i).substring(0, id));
        }
        System.out.println(uniqStr);
        return uniqStr;
    }
    public void insertNode(Node root, String word) {
        Node t = root;
        for(int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if(t.hm.containsKey(ch)) {
                t = t.hm.get(ch);
            } else {
                Node nn = new Node();
                t.hm.put(ch, nn);
                t = nn;
            }
        }
        t.isEnd = true;
    }

    public int uniqueIndex(Node root, String word) {
        Node t = root;
        int index = 1;
        for(int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if(t.hm.size() > 1) {
                index = i + 1;
            }
            t = t.hm.get(ch);
        }
        return index;
    }
    public static void main(String[] args) {
        shortestUniquePrefix sup = new shortestUniquePrefix();
        // ArrayList<String> A = new ArrayList<String>(Arrays.asList("zebra", "dog", "duck", "dove"));
        
        ArrayList<String> A = new ArrayList<String>(Arrays.asList("apple", "ball", "cat"));
        
        sup.prefix(A);
    }
}
