import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class flattenBinaryTreeWithLL {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode temp = root;
        ArrayList<TreeNode> arr = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();

        while (!stk.isEmpty() || temp != null) {
            while (temp!= null) {
                stk.add(temp);
                arr.add(temp);
                temp = temp.left;
            }
            TreeNode curNode = stk.pop();
            temp = curNode.right;
        }

        System.out.println(arr);

        for(int i = 0; i < arr.size()-1; i++) {
            arr.get(i).left = null;
            arr.get(i).right = arr.get(i+1);
        }

        arr.get(arr.size()-1).left = null;
        arr.get(arr.size()-1).right = null;

    }
}
