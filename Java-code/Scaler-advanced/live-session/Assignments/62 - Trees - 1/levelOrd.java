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

public class levelOrd {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        TreeNode tempA = A;
        Queue<TreeNode> que = new LinkedList<>();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        ArrayList<Integer> nestArr = new ArrayList<>();
        que.add(tempA);
        nestArr.add(que.peek().val);
        arr.add(nestArr);
        while(!que.isEmpty()) {
            int N = que.size();
            int ct = 1;
            nestArr = new ArrayList<>();
            boolean leftCheck = false;
            boolean rightCheck = false;

            while(ct <= N) {
                if(que.peek().left != null) {
                    que.add(que.peek().left);
                    nestArr.add(que.peek().left.val);
                    leftCheck = true;
                }
    
                if(que.peek().right != null) {
                    que.add(que.peek().right);
                    nestArr.add(que.peek().right.val);
                    rightCheck = true;
                }
                ct+=1;
                que.poll();
            }
            if(leftCheck || rightCheck) {
                arr.add(nestArr);
            }
        }
        return arr;
    }
}
