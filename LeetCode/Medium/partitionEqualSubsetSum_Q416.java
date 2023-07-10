
public class partitionEqualSubsetSum_Q416 {

    public boolean partition(int i, int j) {
        if(j == 0) {
            return true;
        }
        if(i >= N || j < 0) {
            return false;
        }

        if(dp[i][j] == null) {
            boolean leaveIt = partition(i + 1, j);
            boolean takeIt = partition(i + 1, j - nums[i]);
            dp[i][j] = leaveIt||takeIt;
        }
        return dp[i][j];
    }

    int[] nums;
    int N;
    Boolean[][] dp;
    public boolean canPartition(int[] arr) {
        nums = arr;
        N = nums.length;
        
        if(N == 1) {
            return false;
        }

        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += nums[i];
        }

        if(sum%2 != 0) {
            // System.out.println(false);
            return false;
        }

        int halfSum = sum/2;
        dp = new Boolean[N][halfSum+1];
        Boolean halfed = partition(0, sum/2);
        // System.out.println(halfed);
        return halfed;   
    }
    public static void main(String[] args) {
        partitionEqualSubsetSum_Q416 pe = new partitionEqualSubsetSum_Q416();
        // int[] nums = {1,5,11,5};
        // int[] nums = {1,2,3,5};
        // int[] nums = {43,42,20,86,5,5,64,77,92,94,7,4,28,42,67,97,93,85,53,41,22,86,26,45,100,57,19,94,83,29,36,100,24,36,62,38,97,86,10,86,76,69,73,31,53,95,82,88,72,29,96,24,90,33,62,85,63,93,83,20,23,72,26,31,97,79,72,69,38,29,36,75,73,66,48,50,77,12,79,48,3,67,16,40,11,79,28,5,18,12,80,4,82,60,29,96,95,2,50,99};
        int[] nums = {71,70,66,54,32,63,38,98,4,22,61,40,6,8,6,21,71,36,30,34,44,60,89,53,60,56,73,14,63,37,15,58,51,88,88,32,80,32,10,89,67,29,68,65,34,15,88,8,57,78,37,63,73,65,47,39,32,74,31,44,43,4,10,8,96,22,58,87,29,99,79,13,96,21,62,71,34,55,72,3,96,7,36,64,30,6,14,87,12,90,40,13,29,21,94,33,99,86,4,100};


        pe.canPartition(nums);
    }
}
