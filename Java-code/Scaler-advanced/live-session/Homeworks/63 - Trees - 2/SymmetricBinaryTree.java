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
public class SymmetricBinaryTree {
    // Not working
    public boolean isIdenticalOLD(TreeNode A, TreeNode B) {
        if(A == null && B == null) {
            return true;
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
                while(ct <= Na) {
                    TreeNode curNodeA = queA.peek();
                    TreeNode curNodeB = queB.peek();

                    if(curNodeA != null && curNodeB != null && curNodeA.val != curNodeB.val) {
                        return false;
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
                return false;
            }
        }

        if(!queA.isEmpty() || !queB.isEmpty()) {
            return false;
        }
        return true;
    }
    
    public void mirror(TreeNode Node) {
        if(Node == null) {
            return;
        }
        mirror(Node.left);
        mirror(Node.right);
        TreeNode temp = Node.left;
        Node.left = Node.right;
        Node.right = temp;
    }
    
    public int isSymmetricOLD(TreeNode A) {
        TreeNode tempA = A;
        TreeNode left = tempA.left;
        TreeNode right = tempA.right;
        if(left != right) {
            return 0;
        }
        mirror(left);
        boolean res = isIdentical(left, right);

        return res ? 1 : 0;
    }

    // TA Approach:
    public boolean isIdentical(TreeNode NodeA, TreeNode NodeB) {
        if(NodeA == null && NodeB == null) {
            return true;
        }
        if(NodeA == null || NodeB == null || NodeA.val != NodeB.val) {
            return false;
        }
        return isIdentical(NodeA.left, NodeB.right) && isIdentical(NodeA.right, NodeB.left);
    }
    public int isSymmetric(TreeNode A) {
        return isIdentical(A.left, A.right) ? 1 : 0;
    }
}
