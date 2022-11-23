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
    public TreeNode invertTree(TreeNode A) {
        if(A == null) {
            return null;
        }
        TreeNode left = invertTree(A.left);
        TreeNode right = invertTree(A.right);
        A.left = right;
        A.right = left;

        return A;
    }
}
