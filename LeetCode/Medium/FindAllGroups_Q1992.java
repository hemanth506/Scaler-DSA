import java.util.ArrayList;
import java.util.Arrays;

public class FindAllGroups_Q1992 {
  ArrayList<ArrayList<Integer>> resultArr;
  ArrayList<Integer> arr;

  public int[][] findFarmland(int[][] land) {
    int N = land.length;
    int M = land[0].length;
    resultArr = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (land[i][j] == 1) {
          arr = new ArrayList<>();
          arr.add(i);
          arr.add(j);
          solve(i, j, land, N, M);
        }
      }
    }

    System.out.println(resultArr);
    int[][] result = new int[resultArr.size()][4];
    for (int i = 0; i < resultArr.size(); i++) {
      for (int j = 0; j < 4; j++) {
        result[i][j] = resultArr.get(i).get(j);
      }
    }

    System.out.println(Arrays.deepToString(result));
    return result;
  }

  private boolean solve(int i, int j, int[][] land, int N, int M) {
    if (i >= N && j >= M) {
      return true;
    }
    if (i >= N || j >= M) {
      return true;
    }
    if (land[i][j] == 0) {
      return true;
    }

    if (land[i][j] == 1) {
      land[i][j] = -1;
      boolean bottom = solve(i + 1, j, land, N, M);
      boolean right = solve(i, j + 1, land, N, M);
      if (bottom && right) {
        arr.add(i);
        arr.add(j);
        ArrayList<Integer> tempArr = new ArrayList<>(arr);
        resultArr.add(tempArr);
      }
    }

    return false;
  }

  public static void main(String[] args) {
    FindAllGroups_Q1992 fa = new FindAllGroups_Q1992();
    // int[][] land = { { 1, 0, 0, 1, 1 }, { 0, 1, 1, 0, 0 }, { 0, 1, 1, 0, 0 }, {
    // 0, 1, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
    // int[][] land = { { 1, 1 }, { 1, 1 } };
    // int[][] land = { { 0 }};
    // int[][] land = {{1,0,0},{0,1,1},{0,1,1}};
    int[][] land = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

    fa.findFarmland(land);
  }
}
