import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

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

public class ZigZagLevelOrder {
  public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
    ArrayList<ArrayList<Integer>> response = new ArrayList<>();
    if (A == null) {
      response.add(new ArrayList<>());
      return response;
    }

    Queue<TreeNode> que = new LinkedList<TreeNode>();
    que.add(A);

    int row = 0;
    ArrayList<Integer> innerArr = new ArrayList<>();
    while (!que.isEmpty()) {
      int N = que.size();
      innerArr = new ArrayList<>();
      boolean leftCheck = false;
      boolean rightCheck = false;

      for (int i = 0; i < N; i++) {
        TreeNode node = que.poll();

        innerArr.add(node.val);

        if (node.left != null) {
          que.add(node.left);
          leftCheck = true;
        }

        if (node.right != null) {
          que.add(node.right);
          rightCheck = true;
        }
      }

      if (row % 2 != 0) {
        Collections.reverse(innerArr);
      }

      // System.out.println("Res = "+ innerArr + (leftCheck || rightCheck));
      if (leftCheck || rightCheck) {
        response.add(innerArr);
      }

      row++;
    }
    response.add(innerArr);

    return response;
  }
}
