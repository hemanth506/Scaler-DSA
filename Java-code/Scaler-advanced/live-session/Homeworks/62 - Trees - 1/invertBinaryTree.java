
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


public class invertBinaryTree {
    public void mirror(TreeNode A) {
        if (A == null) {
            return;
        }
        mirror(A.left);
        mirror(A.right);
        TreeNode temp = A.left;
        A.left = A.right;
        A.right = temp;
    }
    public TreeNode invertTree(TreeNode A) {
        mirror(A);
        return A;
    }
}
