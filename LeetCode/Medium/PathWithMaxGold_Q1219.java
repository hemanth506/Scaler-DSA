public class PathWithMaxGold_Q1219 {
  int total = Integer.MIN_VALUE;
  public int getMaximumGold(int[][] grid) {
    int N = grid.length;
    int M = grid[0].length;

    for(int i = 0; i < N; i++) {
      for(int j = 0; j < M ; j++) {
        if(grid[i][j] != 0) {
          dfs(N, M,grid, i, j, 0);
          System.out.println(i + " " + j + " " + total);
        }
      }
    }

    System.out.println(total);
    return total == Integer.MIN_VALUE ? 0 : total;
  }

  private void dfs(int N, int M, int[][] grid, int i, int j, int maxVal) {
    if(i >= N || j >= M || i < 0 || j < 0 || grid[i][j] == 0) {
      total = Integer.max(total, maxVal);
      return;
    }

    int val = grid[i][j];
    grid[i][j] = 0;
    dfs(N, M, grid, i+1, j, maxVal+val);
    dfs(N, M, grid, i-1, j, maxVal+val);
    dfs(N, M, grid, i, j+1, maxVal+val);
    dfs(N, M, grid, i, j-1, maxVal+val);
    grid[i][j] = val;
  }
  
  public static void main(String[] args) {
    PathWithMaxGold_Q1219 pm = new PathWithMaxGold_Q1219();
    // int[][] grid = {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};
    // int[][] grid = {{0,6,0},{5,8,7},{0,9,0}};
    int[][] grid = {{1,0,7,0,0,0},{2,0,6,0,1,0},{3,5,6,7,4,2},{4,3,1,0,2,0},{3,0,5,0,20,0}};
    pm.getMaximumGold(grid);
  }
}
