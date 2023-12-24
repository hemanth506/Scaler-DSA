import java.util.ArrayList;
import java.util.HashMap;

public class FindCenter {
  public int findCenter(int[][] edges) {
    HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();

    int N = edges.length;
    for (int i = 0; i < N; i++) {
      int src = edges[i][0];
      int dest = edges[i][1];

      ArrayList<Integer> arr1;
      if (adjList.containsKey(src)) {
        arr1 = adjList.get(src);
      } else {
        arr1 = new ArrayList<>();
      }
      arr1.add(dest);
      adjList.put(src, arr1);

      ArrayList<Integer> arr2;
      if (adjList.containsKey(dest)) {
        arr2 = adjList.get(dest);
      } else {
        arr2 = new ArrayList<>();
      }
      arr2.add(src);
      adjList.put(dest, arr2);

    }

    int center = 0;
    int M = adjList.size();
    for (Integer node : adjList.keySet()) {
      int adjNode = adjList.get(node).size();
      if(adjNode == M-1) {
        center = node;
      }
    }

    return center;
  }
}
