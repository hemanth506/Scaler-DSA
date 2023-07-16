import Medium.TreeNode;

public class maximumBinaryTree_Q654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int N = nums.length;
        TreeNode head = maxBT(nums, 0, N-1);
        return head;
    }

    public TreeNode maxBT(int[] nums, int st, int end) {
        System.out.println(st + " " + end);
        if(st > end) {
            return null;
        }
        if (st == end) {
            TreeNode root = new TreeNode(nums[st], null, null);
            return root;
        }
        int maxV = Integer.MIN_VALUE;
        int maxI = -1;
        for(int i = st; i <= end; i++) {
            if (maxV < nums[i]) {
                maxI = i;
                maxV = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxV, maxBT(nums, st, maxI-1), maxBT(nums, maxI + 1, end));
        return root;
    }
}
