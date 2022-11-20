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

public class recoverBinarySearchTree {
    public int[] recoverTree(TreeNode A) {
        TreeNode tempA = A;
        Deque<TreeNode> deq = new LinkedList<>();
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode last = null;
        while(!deq.isEmpty() || tempA != null) {
            while (tempA != null) {
                deq.add(tempA);
                tempA = tempA.left;
            }
            TreeNode curNode = deq.peekLast();
            if(prev != null) {
                if(prev.val > curNode.val && first == null) {
                    first = prev;
                    last = curNode;
                } else if (prev.val > curNode.val) {
                    last = curNode;
                }
            }
            prev = curNode;
            tempA = curNode.right;
            deq.pollLast();
        }
        int[] arr = new int[2];
        arr[0] = first.val;
        arr[1] = last.val; 

        return arr;
    }
}
