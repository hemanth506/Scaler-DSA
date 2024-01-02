import java.util.ArrayList;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

public class LowestCommonAnchesterNode {

  ArrayList<TreeNode> pArr;
  ArrayList<TreeNode> qArr;

  public boolean getPath(TreeNode root, TreeNode target, ArrayList<TreeNode> arr) {

    if (root == null) {
      return false;
    }

    if (root == target) {
      arr.add(target);
      return true;
    }

    arr.add(root);
    if (getPath(root.left, target, arr) || getPath(root.right, target, arr)) {
      return true;
    }

    arr.remove(arr.size() - 1);
    return false;

  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    pArr = new ArrayList<>();
    getPath(root, p, pArr);

    qArr = new ArrayList<>();
    getPath(root, q, qArr);

    int N = Integer.min(qArr.size(), pArr.size());
    TreeNode lastAnchester = null;
    for (int i = 0; i < N; i++) {
      if (i == qArr.size() || i == pArr.size() || qArr.get(i) != pArr.get(i)) {
        break;
      }
      lastAnchester = pArr.get(i);
    }

    return lastAnchester;
  }

}
