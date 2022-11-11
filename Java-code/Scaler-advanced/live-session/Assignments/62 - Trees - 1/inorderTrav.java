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

public class inorderTrav {
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        TreeNode tempA = A;
        Deque<TreeNode> deq = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        while(!deq.isEmpty() || tempA != null) {
            while(tempA != null) {
                deq.addLast(tempA);
                tempA = tempA.left;
            }
            tempA = deq.peekLast();
            deq.pollLast();
            arr.add(tempA.val);
            tempA = tempA.right;
        }

        return arr;
    }
}
