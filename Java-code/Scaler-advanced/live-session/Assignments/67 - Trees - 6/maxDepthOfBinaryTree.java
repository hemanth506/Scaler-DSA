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

public class maxDepthOfBinaryTree {
    public int depth(TreeNode A) {
        if(A == null) {
            return 0;
        }

        int left = 0;
        if(A.left != null) {
            left = depth(A.left) + 1;
        }
        
        int right = 0;
        if(A.right != null) {
            right = depth(A.right) + 1;
        }

        return Integer.max(left, right);
    }
    public int maxDepth(TreeNode A) {
        int depth = depth(A) + 1; // plus 1 for root node
        System.out.println(depth);
        return depth;
    }
}
