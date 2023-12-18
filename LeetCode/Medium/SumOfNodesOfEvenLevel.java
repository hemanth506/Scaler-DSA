import Medium.TreeNode;

public class SumOfNodesOfEvenLevel {
  int sumValue;
  public void solve(TreeNode root) {
    if (root == null) {
      return;
    }

    if(root.val % 2 == 0) {
      if(root.left != null) {
        if(root.left.left != null) {
          sumValue += root.left.left.val;
        }

        if(root.left.right != null) {
          sumValue += root.left.right.val;
        }
      }

      if(root.right != null) {
        if(root.right.left != null) {
          sumValue += root.right.left.val;
        }

        if(root.right.right != null) {
          sumValue += root.right.right.val;
        }
      }
    }

    solve(root.left);
    solve(root.right);
  }

  public int sumEvenGrandparent(TreeNode root) {
    sumValue = 0;
    solve(root);
    System.out.println(sumValue);
    return sumValue;
  }
}
