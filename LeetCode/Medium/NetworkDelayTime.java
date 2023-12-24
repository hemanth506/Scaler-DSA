import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class Pair {
  int timeTaken;
  int node;

  Pair(int x, int y) {
    this.timeTaken = x;
    this.node = y;
  }
}

public class NetworkDelayTime {

  HashMap<Integer, ArrayList<Pair>> adj = new HashMap<>();

  public int networkDelayTime(int[][] times, int n, int k) {
    adj = createAdjList(times);

    PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>((Pair p1, Pair p2) -> p1.timeTaken - p2.timeTaken);
    minHeap.add(new Pair(0, k));


    int[] blastedArr = new int[n + 1];
    Arrays.fill(blastedArr, Integer.MAX_VALUE);

    while (!minHeap.isEmpty()) {
      Pair curMinPair = minHeap.poll();
      int curNode = curMinPair.node;
      int blastedTime = curMinPair.timeTaken;
      if (blastedTime < blastedArr[curNode]) {
        blastedArr[curNode] = blastedTime;
        if(adj.containsKey(curNode)) {
          ArrayList<Pair> adjPairs = adj.get(curNode);
          for (int i = 0; i < adjPairs.size(); i++) {
            int toBeBlastedTime = adjPairs.get(i).timeTaken;
            int toBeBlastedNode = adjPairs.get(i).node;
            Pair adjPair = new Pair(blastedTime + toBeBlastedTime, toBeBlastedNode);
            minHeap.add(adjPair);
          }
        }
      }
    }

    int minTime = Integer.MIN_VALUE;
    for (int i = 1; i < blastedArr.length; i++) {
      if (blastedArr[i] == Integer.MAX_VALUE) {
        return -1;
      } else {
        minTime = Integer.max(minTime, blastedArr[i]);
      }
    }

    return minTime;
  }

  private HashMap<Integer, ArrayList<Pair>> createAdjList(int[][] times) {
    int N = times.length;
    for (int i = 0; i < N; i++) {
      int src = times[i][0];
      int dest = times[i][1];
      int tt = times[i][2];

      Pair pr = new Pair(tt, dest);
      ArrayList<Pair> arr;
      if (adj.containsKey(src)) {
        arr = adj.get(src);
      } else {
        arr = new ArrayList<>();
      }
      arr.add(pr);
      adj.put(src, arr);
    }

    return adj;
  }

  public static void main(String[] args) {
    NetworkDelayTime nd = new NetworkDelayTime();
    // int[][] times = { { 1, 2, 3 }, { 1, 6, 1 }, { 2, 9, 9 }, { 2, 3, 7 }, { 3, 4, 4 }, { 4, 8, 2 }, { 5, 7, 2 }, { 5, 8, 6 }, { 5, 3, 7 }, { 6, 7, 3 }, { 9, 5, 1 }, { 9, 1, 6 }, { 9, 6, 5 } };
    // int n = 9;
    // int k = 1;

    // int[][] times = { { 2,1,1 }, { 2,3,1 }, { 3,4,1 }};
    // int n = 4;
    // int k = 2;

    int[][] times = { { 1,2,1 }};
    int n = 2;
    int k = 2;
    nd.networkDelayTime(times, n, k);
  }
}
