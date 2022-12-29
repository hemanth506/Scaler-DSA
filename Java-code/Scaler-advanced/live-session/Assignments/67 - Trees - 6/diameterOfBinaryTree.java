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
public class diameterOfBinaryTree {
    int maxDia = Integer.MIN_VALUE;
    public int getDiameter(TreeNode A) {
        if(A == null) {
            return 0;
        }

        int left = 0;
        if(A.left != null) {
            left = getDiameter(A.left)+1;
        }

        int right = 0;
        if(A.right != null) {
            right = getDiameter(A.right)+1;
        }

        int curDia = left + right;
        maxDia = Integer.max(maxDia, curDia);

        return Integer.max(left, right);
    }

    public int solve(TreeNode A) {
        getDiameter(A);
        return maxDia;
    }    
}
