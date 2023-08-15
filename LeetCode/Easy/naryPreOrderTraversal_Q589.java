import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Easy.Node;

public class naryPreOrderTraversal_Q589 {
    List<Integer> arr = new ArrayList<>();
    List<Integer> arr2 = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null) {
            return arr;
        }
        getPreOrderRecursive(root);
        getPreOrderIterative(root);
        System.out.println(arr);
        System.out.println(arr2);
        return arr;
    }

    private void getPreOrderIterative(Node root) {
        Stack<Node> stk = new Stack<>();
        stk.add(root);
        while (!stk.isEmpty()) {
            Node node = stk.pop();
            arr2.add(node.val);
            for(int i = node.children.size()-1; i >= 0; i--) {
                stk.add(node.children.get(i));
            }
        }
    }

    private void getPreOrderRecursive (Node root) {
        if(root == null) {
            return;
        }
        arr.add(root.val);
        for(int i = 0; i < root.children.size(); i++) {
            getPreOrderRecursive(root.children.get(i));
        }
    }
}
