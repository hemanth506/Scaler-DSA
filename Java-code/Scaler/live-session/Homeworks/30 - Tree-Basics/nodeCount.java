
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

public class nodeCount {
    public int solve(TreeNode A) {

        if (A==null) {
            return 0;
        }
        int lTree = solve(A.left);
        int rTree = solve(A.right);

        return lTree + rTree + 1;
    }
}
