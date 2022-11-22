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
public class distanceBetweenTwoNodes {
    public boolean path(TreeNode A, int B, ArrayList<Integer> arrB) {
        if(A == null) {
            return false;
        }

        if(A.val == B) {
            arrB.add(A.val);
            return true;
        }

        if(path(A.left, B, arrB) || path(A.right, B, arrB)) {
            arrB.add(A.val);
            return true;
        }
        return false;
    }
    public int solve(TreeNode A, int B, int C) {
        ArrayList<Integer> pathA = new ArrayList<Integer>();
        path(A, B, pathA);


        ArrayList<Integer> pathB = new ArrayList<Integer>();
        path(A, C, pathB);

        int N = pathA.size() > pathB.size() ? pathB.size() : pathA.size();
        // System.out.println(pathA);
        // System.out.println(pathB);

        int iA = pathA.size()-1;
        int iB = pathB.size()-1;
        // System.out.println(pathA.size() + " size " + pathB.size());

        int ct = 1;
        int tempA = iA;
        int tempB = iB;

        while(ct <= N) {
            int curValA = pathA.get(iA);
            int curValB = pathB.get(iB);

            if(curValA == curValB) {
                tempA = iA;
                tempB = iB;
            }
            ct++;
            iA--;
            iB--;
        }
        System.out.println(tempA + tempB - 1);
        return C;
    }
}
