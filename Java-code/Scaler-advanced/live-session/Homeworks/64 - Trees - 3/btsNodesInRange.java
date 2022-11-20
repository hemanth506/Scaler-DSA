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
public class btsNodesInRange {
    int getCount(TreeNode A, int B, int C) {
        TreeNode tempA = A;
        Deque<TreeNode> deq = new LinkedList<>();
        int count = 0;
        while(!deq.isEmpty() && tempA != null) {
            while(tempA != null) {
                deq.add(tempA);
                tempA = tempA.left;
            }
            TreeNode curNode = deq.peekLast();
            if(curNode.val > B && curNode.val < C) {
                count += 1;
            }
            tempA = curNode.right;
            deq.pollLast();
        }
        return count;
    }
    public int solve(TreeNode A, int B, int C) {
        return getCount(A, B, C);
    }
}
