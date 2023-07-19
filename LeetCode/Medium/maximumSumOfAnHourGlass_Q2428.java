import java.util.Arrays;

public class maximumSumOfAnHourGlass_Q2428 {
    public int maxSum(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        System.out.println(Arrays.deepToString(grid));

        int[][] LtoRPrefix = new int[N][M];
        for(int i = 0; i < N; i++) {
            LtoRPrefix[i][0] = grid[i][0];
            for(int j = 1; j < M; j++) {
                LtoRPrefix[i][j] = LtoRPrefix[i][j-1] + grid[i][j];
            }
        }
        System.out.println(Arrays.deepToString(LtoRPrefix));

        int maxHourSum = Integer.MIN_VALUE;

        int TRr = 0; 
        int BRr = 2; 
        int Mr = 1; 
        while (BRr < N) {
            int TRc = 2;
            int BRc = 2;
            int Mc = 1;
            while (TRc < M) {
                int curHourSum = 0;
    
                // Top right
                int TopRowSum = LtoRPrefix[TRr][TRc];
                if((TRc-2) != 0) {
                    TopRowSum -= LtoRPrefix[TRr][TRc-3];
                }
                curHourSum += TopRowSum;
    
                // Bottom right
                int BottomRowSum = LtoRPrefix[BRr][BRc];
                if((BRc-2) != 0) {
                    BottomRowSum -= LtoRPrefix[BRr][BRc-3];
                }
                curHourSum += BottomRowSum;
    
                // Middle value
                curHourSum += grid[Mr][Mc];
                maxHourSum = Integer.max(curHourSum, maxHourSum);
                TRc++;
                BRc++;
                Mc++;
            }
            TRr++;
            BRr++;
            Mr++;
        }
        System.out.println(maxHourSum);
        return maxHourSum;
        
    }
    public static void main(String[] args) {
        maximumSumOfAnHourGlass_Q2428 ms = new maximumSumOfAnHourGlass_Q2428();
        // int[][] grid = {{6,2,1,3}, {4,2,1,5}, {9,2,8,7}, {4,1,2,9}};
        int[][] grid = {{1,2,3}, {4,5,6}, {7,8,9}};
        ms.maxSum(grid);
    }
}

/*
 * {{6,2,1,3},
 *  {4,2,1,5},
 *  {9,2,8,7},
 *  {4,1,2,9}}
 */