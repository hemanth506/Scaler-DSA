import java.util.ArrayList;
import java.util.HashMap;

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


public class binaryTreeFromInorderAndPostorder {
    HashMap<Integer, Integer> hm;
    int postEltIt;
    int N;
    public TreeNode buildTree(ArrayList<Integer> In, ArrayList<Integer> Post) {
        N = In.size();
        postEltIt = N-1;
        hm = new HashMap<>();
        for (int i = N - 1; i >= 0; i--) {
            hm.put(In.get(i), i);
        }
        // System.out.println(hm);
        return construct(Post, In, 0, N-1);
    }

    public TreeNode construct(ArrayList<Integer> Post, ArrayList<Integer> In, int s2, int e2) {
        // Add this condition s2 > e2, to handle edge cases.
        if (postEltIt < 0 || s2 > e2) {
            return null;
        }
        // System.out.println("postEltIt =" + postEltIt);
        TreeNode node = new TreeNode(Post.get(postEltIt));
        int M = hm.get(Post.get(postEltIt));
        postEltIt -= 1;
        node.right = construct(Post, In, M+1, e2);
        node.left = construct(Post, In, s2, M-1);
        return node;
    }
}


// 10 12 4 -9 5 15 -1 6 9 19 10
// 10 4 -9 12 15 -1 19 9 10 6 5