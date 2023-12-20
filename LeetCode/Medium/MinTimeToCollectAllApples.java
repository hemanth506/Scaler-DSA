// Took help from the recording

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinTimeToCollectAllApples {

  HashMap<Integer, ArrayList<Integer>> adjList;
  boolean[] visitedArr;

  private void createAdjList(int n, int[][] edges) {
    adjList = new HashMap<>();
    for (int i = 0; i < n - 1; i++) {
      int src = edges[i][0];
      int dest = edges[i][1];

      ArrayList<Integer> arrSrc;
      if (adjList.containsKey(src)) {
        arrSrc = adjList.get(src);
      } else {
        arrSrc = new ArrayList<>();
      }
      arrSrc.add(dest);
      adjList.put(src, arrSrc);

      ArrayList<Integer> arrDest;
      if (adjList.containsKey(dest)) {
        arrDest = adjList.get(dest);
      } else {
        arrDest = new ArrayList<>();
      }
      arrDest.add(src);
      adjList.put(dest, arrDest);
    }
  }

  public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
    if (n == 1) {
      return 0;
    }
    createAdjList(n, edges);
    visitedArr = new boolean[n];
    int appleCollectedTime = dfs(0, hasApple);
    return appleCollectedTime;
  }

  private int dfs(int root, List<Boolean> hasApple) {
    // base case
    if (visitedArr[root]) {
      return 0;
    }

    visitedArr[root] = true;
    ArrayList<Integer> arr = adjList.get(root);

    int appleCollectedTime = 0;
    for (int i = 0; i < arr.size(); i++) {
      if (!visitedArr[arr.get(i)]) {
        appleCollectedTime += dfs(arr.get(i), hasApple);
      }
    }

    // we don't want to add steps if it is a root node, we can directly return it.
    if ((hasApple.get(root) || appleCollectedTime > 0) && root != 0) {
      appleCollectedTime += 2;
    }

    return appleCollectedTime;

  }

  public static void main(String[] args) {
    MinTimeToCollectAllApples mt = new MinTimeToCollectAllApples();
    int n = 7;
    int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
    List<Boolean> hasApple = new ArrayList<>(Arrays.asList(false, false, true, false, true, true, false));
    mt.minTime(n, edges, hasApple);
  }
}
