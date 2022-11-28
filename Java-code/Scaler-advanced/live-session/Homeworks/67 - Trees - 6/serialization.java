import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class serialization {
    public ArrayList<Integer> solve(TreeNode A) {
        TreeNode tempA = A;
        Queue<TreeNode> que = new LinkedList<>();
        ArrayList<Integer> al = new ArrayList<>();
        que.add(tempA);
        while (!que.isEmpty()) {
            TreeNode curNode = que.peek();
            if (curNode != null) {
                if (curNode.left != null) {
                    que.add(curNode.left);
                } else {
                    que.add(null);
                }

                if (curNode.right != null) {
                    que.add(curNode.right);
                } else {
                    que.add(null);
                }
                al.add(curNode.val);
            } else {
                al.add(-1);
            }

            que.poll();
        }
        return al;
    }
}
