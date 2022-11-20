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

public class validBinarySearchTree {
    public boolean inOrder(TreeNode A) {
        TreeNode tempA = A;
        Deque<TreeNode> deq = new LinkedList<>();
        TreeNode prev = null;
        while (!deq.isEmpty() || tempA != null) {
            while (tempA != null) {
                deq.add(tempA);
                tempA = tempA.left;
            }
            TreeNode curNode = deq.peekLast();
            if(prev != null) {
                if(prev.val > curNode.val) {
                    return false;
                }
            }
            prev = curNode;
            tempA = curNode.right;
            deq.pollLast();
        }
        return true;
    }
    public int isValidBST(TreeNode A) {
        return inOrder(A) ? 1 : 0;
    }
}
