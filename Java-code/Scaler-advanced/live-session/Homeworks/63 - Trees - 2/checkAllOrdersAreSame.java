import java.util.ArrayList;
import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class checkAllOrdersAreSame {
    int globalVar;
    int iterVal;
    boolean isEqual;

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        globalVar = 0;
        iterVal = 0;
        isEqual = true;

        int N = A.size();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            hm.put(B.get(i), i);
        }
        // System.out.println("hm = " + hm);

        createPostOrder(A, B, 0, N - 1, hm, C);

        return isEqual ? 1 : 0;
    }

    public TreeNode createPostOrder(ArrayList<Integer> A, ArrayList<Integer> B, int s2, int e2, HashMap<Integer, Integer> hm, ArrayList<Integer> C) {
        // System.out.println(s2 + " " + e2);
        if (s2 > e2) {
            return null;
        }

        TreeNode root = new TreeNode(A.get(globalVar));
        int ind = hm.get(A.get(globalVar));
        globalVar++;

        // if the preOrder and inOrder are not matched.
        if (ind < s2 || ind > e2) {
            return null;
        }
        root.left = createPostOrder(A, B, s2, ind - 1, hm, C);
        root.right = createPostOrder(A, B, ind + 1, e2, hm, C);

        // check if the val is matching C arr [Post order]
        if (root.val != C.get(iterVal)) {
            isEqual = false;
            return null;
        }
        iterVal++;
        return root;
    }
}
