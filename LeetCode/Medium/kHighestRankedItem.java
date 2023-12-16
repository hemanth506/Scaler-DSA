import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair {
  int row;
  int col;

  public Pair(int r, int c) {
    this.row = r;
    this.col = c;
  }
}

class RankingPair {
  int value;
  int distance;
  Pair pr;

  public RankingPair(int value, int distance, int row, int col) {
    this.value = value;
    this.distance = distance;
    this.pr = new Pair(row, col);
  }
}

public class kHighestRankedItem {
  ArrayList<RankingPair> rankingArr;
  int low;
  int high;
  int N;
  int M;
  boolean visited[][];
  Queue<Pair> que;

  private void solve(int[][] grid, int k, int r, int c) {
    que = new LinkedList<>(); // SC: O(N+E)
    que.add(new Pair(r, c));
    visited[r][c] = true;
    int dist = 0;

    while (!que.isEmpty()) { // Breadth First search -> TC: O(N+E)
      int L = que.size();
      for (int i = 0; i < L; i++) {
        Pair pr = que.poll();
        int row = pr.row;
        int col = pr.col;

        if (grid[row][col] == 0) {
          continue;
        }

        if (low <= grid[row][col] && grid[row][col] <= high) {
          RankingPair rkPr = new RankingPair(grid[row][col], dist, row, col);
          rankingArr.add(rkPr);
          k--;
        }

        if (row + 1 < N && !visited[row + 1][col]) {
          que.add(new Pair(row + 1, col));
          visited[row + 1][col] = true;
        }

        if (col + 1 < M && !visited[row][col + 1]) {
          que.add(new Pair(row, col + 1));
          visited[row][col + 1] = true;
        }

        if (row - 1 >= 0 && !visited[row - 1][col]) {
          que.add(new Pair(row - 1, col));
          visited[row - 1][col] = true;
        }

        if (col - 1 >= 0 && !visited[row][col - 1]) {
          que.add(new Pair(row, col - 1));
          visited[row][col - 1] = true;
        }
      }
      dist++;
    }

  }

  public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
    N = grid.length;
    M = grid[0].length;
    low = pricing[0];
    high = pricing[1];
    int row = start[0];
    int col = start[1];
    visited = new boolean[N][M]; // SC: O(N*M)
    rankingArr = new ArrayList<>(); // SC: O(P)

    solve(grid, k, row, col);

    Collections.sort(rankingArr, new CustomSort()); // Sorting -> TC: O(PlogP)

    List<List<Integer>> finalSortedArr = new ArrayList<>(); // SC: O(K)
    int P = rankingArr.size();
    int q = 0;
    for (int i = 0; i < P; i++) { // TC: O(P)
      if (q < k) {
        RankingPair rkPr = rankingArr.get(i);
        finalSortedArr.add(new ArrayList<Integer>(Arrays.asList(rkPr.pr.row, rkPr.pr.col)));
      }
      q++;
    }

    System.out.println(finalSortedArr);
    return finalSortedArr;
  }

  public static void main(String[] args) {
    // int[][] grid = { { 1, 2, 0, 1 }, { 1, 3, 0, 1 }, { 0, 2, 5, 1 } };
    // int[] pricing = { 2, 5 };
    // int[] start = { 0, 0 };
    // int k = 3;

    // int[][] grid = { { 1,2,0,1 }, { 1,3,3,1 }, { 0, 2, 5, 1 } };
    // int[] pricing = { 2, 3 };
    // int[] start = { 2,3 };
    // int k = 2;

    // int[][] grid = { { 1, 1, 1 }, { 0, 0, 1 }, { 2, 3, 4 } };
    // int[] pricing = { 2, 3 };
    // int[] start = { 0, 0 };
    // int k = 3;

    // int[][] grid = { { 0 }, { 2 }, { 0 } };
    // int[] pricing = { 2, 2 };
    // int[] start = { 1, 0 };
    // int k = 1;

    int[][] grid = { { 57, 54, 48 }, { 652, 572, 990 }, { 632, 199, 306 }, { 38, 702, 263 }, { 431, 0, 507 },
        { 673, 570, 750 }, { 316, 141, 639 } };
    int[] pricing = { 475, 745 };
    int[] start = { 3, 2 };
    int k = 4;

    kHighestRankedItem kh = new kHighestRankedItem();
    kh.highestRankedKItems(grid, pricing, start, k);
  }
}

class CustomSort implements Comparator<RankingPair> {

  @Override
  public int compare(RankingPair o1, RankingPair o2) {
    if (o1.distance < o2.distance) {
      return -1;
    } else if (o1.distance > o2.distance) {
      return 1;
    } else if (o1.distance == o2.distance) {
      if (o1.value < o2.value) {
        return -1;
      } else if (o1.value > o2.value) {
        return 1;
      } else if (o1.value == o2.value) {
        if (o1.pr.row < o2.pr.row) {
          return -1;
        } else if (o1.pr.row > o2.pr.row) {
          return 1;
        } else if (o1.pr.row == o2.pr.row) {
          if (o1.pr.col < o2.pr.col) {
            return -1;
          } else if (o1.pr.col > o2.pr.col) {
            return 1;
          }
          return 0;
        }
      }
    }
    return 0;
  }

}