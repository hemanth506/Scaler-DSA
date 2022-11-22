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

public class leastCommonAnchester {
    public boolean path(TreeNode node, int K, ArrayList<Integer> A) {
        if (node == null) {
            return false;
        }
        if (node.val == K) {
            A.add(node.val);
            return true;
        }
        if (path(node.left, K, A) || path(node.right, K, A)) {
            A.add(node.val);
            return true;
        }
        return false;
    }

    public int lca(TreeNode A, int B, int C) {
        ArrayList<Integer> pathA = new ArrayList<Integer>();
        path(A, B, pathA);


        ArrayList<Integer> pathB = new ArrayList<Integer>();
        path(A, C, pathB);

        if(pathA.isEmpty() || pathB.isEmpty()) {
            return -1;
        }
        
        int N = pathA.size() > pathB.size() ? pathB.size() : pathA.size();
        // System.out.println(pathA);
        // System.out.println(pathB);

        int result = A.val;
        int iA = pathA.size()-1;
        int iB = pathB.size()-1;
        // System.out.println(pathA.size() + " size " + pathB.size());

        int ct = 1;
        while(ct <= N) {
            int curValA = pathA.get(iA);
            int curValB = pathB.get(iB);

            if(curValA == curValB) {
                result = pathA.get(iA);
            }
            ct++;
            iA--;
            iB--;
        }
        return result;
    }
}
