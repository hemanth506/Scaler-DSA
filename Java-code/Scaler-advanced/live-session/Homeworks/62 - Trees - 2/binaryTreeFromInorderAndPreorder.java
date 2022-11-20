import java.util.ArrayList;
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
public class binaryTreeFromInorderAndPreorder {
    public TreeNode construct(ArrayList<Integer> A, int s1, int e1, ArrayList<Integer> B, int s2, int e2, int N) {
        if(s1 > e1 || s1 >= N) {
            return null;
        }
        int m = s2;
        for(int i = s2; i <= e2; i++) {
            if(B.get(i).equals(A.get(s1))) {
                m = i;
                break;
            }
        }
        int l = m - s2;
        TreeNode node = new TreeNode(A.get(s1));
        // System.out.println("left = " + l + " " + (s1+1) + " " + (s1+l) + " " + s2 + " " + (l - 1));
        node.left = construct(A, s1+1, s1+l, B, s2, m-1, N);
        // System.out.println("right = " + l + " " + (s1+l+1) + " " + (e2) + " " + (l+1) + " " + (e2));
        node.right = construct(A, s1+l+1, e1, B, m+1, e2, N);
        return node;
    }
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        int N = A.size();
        int m = 0;
        for(int i = 0; i < N; i++) {
            if(B.get(i).equals(A.get(0))) {
                m = i;
                break;
            }
        }
        int init = 0;
        TreeNode node = new TreeNode(A.get(init));
        node.left = construct(A, 1, m, B, 0, m-1, N);
        node.right = construct(A, m+1, N-1, B, m+1, N-1, N);
        return node;
    }
}
