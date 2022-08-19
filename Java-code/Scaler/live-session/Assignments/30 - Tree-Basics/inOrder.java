import java.util.ArrayList;


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

public class inOrder {
    public ArrayList<Integer> inOrd (ArrayList<Integer> Al, TreeNode A) {
        if(A == null) {
            return null;
        }
        inOrd(Al, A.left);
        Al.add(A.val);
        inOrd(Al, A.right);
        return Al;
    }
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> Al = new ArrayList<>();
        return inOrd(Al, A);
    }

    public static void main(String[] args) {
        // Not taught how to create a node
    }
}
