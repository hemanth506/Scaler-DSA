import Medium.TreeNode;

public class maximumProductOfSplittedBinaryTree_Q1339 {
    long firstPart = 1L*0;
    long secondPart = 1L*0;
    long minDiff = Long.MAX_VALUE;
    int mod = 1000000007;

    public int maxProduct(TreeNode root) {
        TreeNode head = root;

        long totalSum = getTotalSumofTree(head);
        System.out.println(totalSum);

        splitEdges(head, totalSum);
        System.out.println(firstPart + " " + secondPart);

        long result = (firstPart % mod * secondPart % mod) % mod;
        return (int)result;
    }

    private long splitEdges(TreeNode root, long totalSum) {
        if(root == null) {
            return 0;
        }
        long left = splitEdges(root.left, totalSum);
        long remaining = totalSum - left;
        long tempDiff = Long.max(left, remaining) - Long.min(left, remaining);
        if (minDiff > tempDiff) {
            firstPart = left;
            secondPart = remaining;
            minDiff = tempDiff;
        }

        long right = splitEdges(root.right, totalSum);
        remaining = totalSum - right;
        tempDiff = Long.max(right, remaining) - Long.min(right, remaining);
        if (minDiff > tempDiff) {
            firstPart = right;
            secondPart = remaining;
            minDiff = tempDiff;
        }

        return (left + right + root.val);
    }


    private long getTotalSumofTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        long left = getTotalSumofTree(root.left);
        long right = getTotalSumofTree(root.right);
        return (left + right + root.val);
    }
}
