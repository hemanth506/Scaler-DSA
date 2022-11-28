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
public class isSymmetricBT {
    public boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left != null && right != null || left.val != right.val) {
            return false;
        }
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
    public int isSymmetric(TreeNode A) {
        return helper(A.left, A.right) ? 1 : 0;
    }
}
