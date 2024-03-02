
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

public class AddOneRow_Q623 {

  public void addRow(TreeNode root, int val, int depth) {
    if (root == null) {
      return;
    }

    if (depth == 2) {
      TreeNode nL = new TreeNode(val);
      TreeNode nR = new TreeNode(val);
      TreeNode tempLeftNode = root.left;
      TreeNode tempRightNode = root.right;
      root.left = nL;
      root.right = nR;
      nL.left = tempLeftNode;
      nR.right = tempRightNode;
      return;
    }

    addRow(root.left, val, depth-1);
    addRow(root.right, val, depth-1);
  }

  public TreeNode addOneRow(TreeNode root, int val, int depth) {
    TreeNode head = root;
    if(depth == 1) {
      head = new TreeNode(val);
      head.left = root;
    } else {
      addRow(root, val, depth);
    }
    return head;
  }
}
