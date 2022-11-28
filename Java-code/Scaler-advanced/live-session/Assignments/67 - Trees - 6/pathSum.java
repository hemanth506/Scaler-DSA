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
    public boolean checkSum(TreeNode A, int B) {
        if (A == null) {
            return false;
        }

        B = B - A.val;
        if (A.left == null && A.right == null) {
            return B == 0;
        }

        return checkSum(A.left, B) || checkSum(A.right, B);
    }

    public int hasPathSum(TreeNode A, int B) {
        return checkSum(A, B) ? 1 : 0;
    }
}
