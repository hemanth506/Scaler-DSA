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

public class sumSubtree {
    boolean hasSum = true;
    public int isEqual(TreeNode A) {
        if (A == null) {
            System.out.println("null");
            return 0;
        }

        int left = 0;
        if (A.left != null) {
            left = A.left.val;
        }

        int right = 0;
        if (A.right != null) {
            right = A.right.val;
        }

        left += isEqual(A.left);
        right += isEqual(A.right);
        int sumVal = left + right;
        if (A.left != null || A.right != null) {
            System.out.println("left = " + left + " right = " + right + " sumVal = " + sumVal + " A.val = " + A.val);
            if (sumVal != A.val) {
                hasSum = false;
            }
        }
        return sumVal;
    }

    public int solve(TreeNode A) {
        isEqual(A);
        return hasSum ? 1 : 0;
    }
}
