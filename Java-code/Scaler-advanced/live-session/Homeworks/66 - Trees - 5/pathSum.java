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
public class pathSum {
    // Referred using Video hint.
    public boolean path(TreeNode A, int B) {
        if(A == null) {
            return false;
        }
        // Subtract the sum value with A.val
        B = B - A.val;

        // So when the leaf node comes and if the sum is zero then we have a path with sum B.
        if(A.left == null && A.right == null) {
            return B == 0;
        }

        return (path(A.left, B) || path(A.right, B));
    }
    public int hasPathSum(TreeNode A, int B) {
        return path(A, B) ? 1 : 0;
    }
}
