import java.util.HashSet;
import java.util.Iterator;

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

public class commonNodesofBST {
    int tot = 0;
    int m = 1000000007;
    public int solveOnlyCommonNodes(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return 0;
        }

        if ((A.left == B.left) || (A.right == B.right)) {
            tot = (tot + A.val) % m;
        }

        solveOnlyCommonNodes(A.left, B.left);
        solveOnlyCommonNodes(A.right, B.right);

        return tot % m;
    }

    public HashSet<Integer> getValues(TreeNode node, HashSet<Integer> hs) {
        if(node == null) {
            return null;
        }
        hs.add(node.val);
        getValues(node.left, hs);
        getValues(node.right, hs);
        return hs;
    }
    public int solve(TreeNode A, TreeNode B) {
        int total = 0;
        int mod = 1000000007;
        HashSet<Integer> hsA = new HashSet<>();
        HashSet<Integer> hsB = new HashSet<>();
        hsA = getValues(A, hsA);
        hsB = getValues(B, hsB);

        Iterator<Integer> it = hsA.iterator();
        while(it.hasNext()) {
            int val = it.next();
            if(hsB.contains(val)) {
                total = (total + val)%mod;
            }
        }

        return total;
    }
}
