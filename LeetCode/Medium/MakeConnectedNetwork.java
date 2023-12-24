import java.util.ArrayList;
import java.util.HashMap;

public class MakeConnectedNetwork {

  HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
  int remainingEdges = 0;
  int currentCompEdges;
  int currentCompNodes;
  boolean[] visitedArr;

  private HashMap<Integer, ArrayList<Integer>> createAdjList(int[][] connections) {
    int N = connections.length;
    for (int i = 0; i < N; i++) {
      int src = connections[i][0];
      int dest = connections[i][1];

      ArrayList<Integer> arr;
      if (adj.containsKey(src)) {
        arr = adj.get(src);
      } else {
        arr = new ArrayList<>();
      }
      arr.add(dest);
      adj.put(src, arr);

      ArrayList<Integer> arr2;
      if (adj.containsKey(dest)) {
        arr2 = adj.get(dest);
      } else {
        arr2 = new ArrayList<>();
      }
      arr2.add(src);
      adj.put(dest, arr2);
    }

    return adj;
  }

  private void dfs(int node) {
    if (visitedArr[node]) {
      return;
    }

    visitedArr[node] = true;
    currentCompNodes++;
    if (adj.containsKey(node)) {
      ArrayList<Integer> arr = adj.get(node);
      for (int i = 0; i < arr.size(); i++) {
        currentCompEdges++;
        dfs(arr.get(i));
      }
    }
  }

  public int makeConnected(int N, int[][] connections) {
    adj = createAdjList(connections);
    visitedArr = new boolean[N];

    int components = 0;
    for (int i = 0; i < N; i++) {
      if (!visitedArr[i]) {
        currentCompEdges = currentCompNodes = 0;
        dfs(i);
        currentCompEdges = currentCompEdges / 2;
        int edgesRequired = currentCompNodes - 1;
        remainingEdges += currentCompEdges - edgesRequired;
        components++;
      }
    }

    if (remainingEdges >= (components - 1)) {
      System.out.println("Edges rearranged = " + (components - 1));
      return components - 1;
    }
    System.out.println("not possible rearranged");
    return -1;
  }

  public static void main(String[] args) {
    MakeConnectedNetwork mc = new MakeConnectedNetwork();
    // int n = 6;
    // int[][] connections = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };

    // int n = 6;
    // int[][] connections = {{0,1},{0,2},{0,3},{1,2}};

    int n = 4;
    int[][] connections = {{0,1},{0,2},{1,2}};
    mc.makeConnected(n, connections);
  }
}
