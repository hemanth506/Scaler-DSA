import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class preorderTrav {
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        TreeNode tempA = A;
        Deque<TreeNode> deq = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        while(!deq.isEmpty() || tempA != null) {
            while(tempA != null) {
                arr.add(tempA.val);
                deq.add(tempA);
                tempA = tempA.left;
            }
            tempA = deq.peekLast().right; 
            deq.pollLast();
        }
        return arr;
    }
}
