
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class treeHeight {
    public int solve(TreeNode A) {
        int hLeft = solve(A.left);
        int hRight = solve(A.right);

        return Integer.max(hLeft, hRight) + 1;
    }
}
