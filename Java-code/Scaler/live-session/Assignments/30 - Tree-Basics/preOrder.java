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

public class preOrder {
    public ArrayList<Integer> preOrd (ArrayList<Integer> AList, TreeNode A) {
        if(A == null) {
            return null;
        }
        AList.add(A.val);
        preOrd(AList, A.left);
        preOrd(AList, A.right);
        return AList;
    }
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> AList = new ArrayList<>();
        return preOrd(AList, A);
    }
    public static void main(String[] args) {
        // Not taught how to create a node
    }
}
