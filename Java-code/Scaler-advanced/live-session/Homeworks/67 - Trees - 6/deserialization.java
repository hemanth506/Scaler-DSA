import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

public class deserialization {
    public TreeNode solve(ArrayList<Integer> A) {
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode root = new TreeNode(A.get(0));
        que.add(root);
        int i = 1;
        while (!que.isEmpty()) {
            TreeNode curNode = que.peek();

            TreeNode nodeLeft;
            if(A.get(i) != -1) {
                nodeLeft = new TreeNode(A.get(i));
                que.add(nodeLeft);
            } else {
                nodeLeft = null;
            }
            curNode.left = nodeLeft;

            TreeNode nodeRight;
            if(A.get(i+1) != -1) {
                nodeRight = new TreeNode(A.get(i+1));
                que.add(nodeRight);
            } else {
                nodeRight = null;
            }
            curNode.right = nodeRight;

            i+=2;
            que.poll();
        }
        return root;
    }
}
