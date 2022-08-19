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

public class postOrder {
    public ArrayList<Integer> postOrd(ArrayList<Integer> Alist, TreeNode A) {
        if(A == null) {
            return null;
        }
        postOrd(Alist, A.left);
        postOrd(Alist, A.right);
        Alist.add(A.val);
        return Alist;
    }
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> Alist = new ArrayList<>();
        return postOrd(Alist, A);
    }
    public static void main(String[] args) {
        // Not taught how to create a node
    }
}
