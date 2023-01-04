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
public class OddAndEvenLevels {
    public int solve(TreeNode A) {
        TreeNode tempA = A;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(tempA);
        int even = 0, odd = tempA.val;
        int level = 1;
        while(!que.isEmpty()) {
            int N = que.size();
            int ct = 1;
            while(ct <= N) {
                // System.out.println("level = " + level);
                TreeNode curNode = que.peek();
                
                if(level%2 == 0) {
                    // System.out.println("even");
                    even += curNode.val;
                } else {
                    odd += curNode.val;
                }
                if(curNode.left != null) {
                    que.add(curNode.left);
                }

                if(curNode.right != null) {
                    que.add(curNode.right);
                }
                que.poll();
                ct+=1;
            }
            level++;
        }
        // System.out.println(odd);
        // System.out.println(even);

        return (odd-even);
    }
}
