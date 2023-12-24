import java.util.ArrayList;
import java.util.List;

public class AllPathSourceTarget {
  List<Integer> arr = new ArrayList<>();
  List<List<Integer>> allPaths = new ArrayList<>();
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    int N = graph.length;
    arr.add(0);
    dfs(graph, 0, N-1);
    System.out.println(allPaths);
    return allPaths;
  }

  private void dfs(int[][] graph, int src, int dest) {
    if(src == dest) {
      List<Integer> newArr = new ArrayList<>();
      for(int j = 0; j < arr.size(); j++) {
        newArr.add(arr.get(j));
      }
      allPaths.add(newArr);
      return;
    }

    int len = graph[src].length;
    for(int i = 0; i < len; i++) {
      int newSrc = graph[src][i];
      arr.add(newSrc);
      dfs(graph, newSrc, dest);
      arr.remove(arr.size()-1);
    }
  }

  public static void main(String[] args) {
    AllPathSourceTarget ap = new AllPathSourceTarget();
    int[][] graph = { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} };
    ap.allPathsSourceTarget(graph);
  }
}
