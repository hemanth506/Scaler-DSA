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
public class identicalBinaryTree {
    public int isSameTree(TreeNode A, TreeNode B) {
        if(A == null && B == null) {
            return 1;
        }
        TreeNode tempA = A;
        TreeNode tempB = B;
        Queue<TreeNode> queA = new LinkedList<>();
        Queue<TreeNode> queB = new LinkedList<>();
        queA.add(tempA);
        queB.add(tempB);

        while(!queA.isEmpty() && !queB.isEmpty()) {
            int Na = queA.size();
            int Nb = queB.size();

            if(Na == Nb) {
                int ct = 1;
                while (ct <= Na) {
                    TreeNode curNodeA = queA.peek();
                    TreeNode curNodeB = queB.peek();

                    if(curNodeA != null && curNodeB!= null && curNodeA.val != curNodeB.val) {
                        return 0;
                    }

                    if(curNodeA.left != null) {
                        queA.add(curNodeA.left);
                    }

                    if(curNodeA.right != null) {
                        queA.add(curNodeA.right);
                    }

                    if(curNodeB.left != null) {
                        queB.add(curNodeB.left);
                    }

                    if(curNodeB.right != null) {
                        queB.add(curNodeB.right);
                    }

                    queA.poll();
                    queB.poll();
                    ct += 1;
                }
            } else {
                return 0;
            }
        }
        if(!queA.isEmpty() || !queB.isEmpty()) {
            return 0;
        }
        return 1;
    }
}
