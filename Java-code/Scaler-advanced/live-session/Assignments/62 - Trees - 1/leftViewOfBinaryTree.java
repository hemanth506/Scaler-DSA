import java.util.ArrayList;
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

public class leftViewOfBinaryTree {
    public ArrayList<Integer> solve(TreeNode A) {
        TreeNode tempA = A;
        Queue<TreeNode> que = new LinkedList<>();
        ArrayList<Integer> finArr = new ArrayList<>();
        if(tempA != null) {
            que.add(tempA);
            finArr.add(que.peek().val);
        }
        while(!que.isEmpty()) {
            int N = que.size();
            int ct = 1;
            boolean added = false;
            while (ct <= N) {
                if(que.peek().left != null) {
                    que.add(que.peek().left);
                }

                if(que.peek().right != null) {
                    que.add(que.peek().right);
                }

                if(!added) {
                    if(que.peek().left != null) {
                        finArr.add(que.peek().left.val);
                        added = true;
                    } else if(que.peek().right != null) {
                        finArr.add(que.peek().right.val);
                        added = true;
                    }
                }
                ct+=1;
                que.poll();
            }
        }
        
        return finArr;
    }
}
