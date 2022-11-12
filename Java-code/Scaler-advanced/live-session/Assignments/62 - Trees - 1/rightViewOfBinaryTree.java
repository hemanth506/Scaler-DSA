import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

public class rightViewOfBinaryTree {
    public ArrayList<Integer> solve(TreeNode A) {
        TreeNode tempA = A;
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(tempA != null) {
            que.add(tempA);
            arr.add(que.peek().val);
        }
        while (!que.isEmpty()) {
            int N = que.size();
            Stack<Integer> element = new Stack<>();
            int ct = 1;
            while(ct <= N) {
                if(que.peek().left != null) {
                    element.add(que.peek().left.val);
                    que.add(que.peek().left);
                }
                if(que.peek().right != null) {
                    element.add(que.peek().right.val);
                    que.add(que.peek().right);
                }
                ct += 1;
                que.poll();
            }
            if(!element.isEmpty()) {
                arr.add(element.peek());
            }
        }
        return arr;
    }
}
