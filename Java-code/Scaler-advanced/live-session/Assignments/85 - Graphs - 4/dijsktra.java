import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class Pair {
    int node;
    int distance;

    Pair(int x, int y) {
        this.node = x;
        this.distance = y;
    }
}

public class dijsktra {

    public HashMap<Integer, ArrayList<Pair>> getAdjList(ArrayList<ArrayList<Integer>> B, int N) {
        
        HashMap<Integer, ArrayList<Pair>> hm = new HashMap<Integer, ArrayList<Pair>>();
        
        for (int i = 0; i < N; i++) {
            int src = B.get(i).get(0);
            int dest = B.get(i).get(1);
            int distance = B.get(i).get(2);

            ArrayList<Pair> prArr;
            Pair pr = new Pair(dest, distance);
            if (hm.containsKey(src)) {
                prArr = hm.get(src);
                prArr.add(pr);
            } else {
                prArr = new ArrayList<>();
                prArr.add(pr);
            }
            hm.put(src, prArr);

            ArrayList<Pair> prArr2;
            Pair pr2 = new Pair(src, distance);
            if (hm.containsKey(dest)) {
                prArr2 = hm.get(dest);
                prArr2.add(pr2);
            } else {
                prArr2 = new ArrayList<>();
                prArr2.add(pr2);
            }
            hm.put(dest, prArr2);

        }
        
        return hm;
    }

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        int N = B.size();

        HashMap<Integer, ArrayList<Pair>> hm = getAdjList(B, N);
        // System.out.println(hm);

        int[] distArr = new int[A];
        Arrays.fill(distArr, Integer.MAX_VALUE);
        distArr[C] = 0;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((Pair p1, Pair p2) -> p1.distance - p2.distance);
        Pair pr = new Pair(C, 0);
        minHeap.add(pr);

        while (!minHeap.isEmpty()) {
            Pair minPr = minHeap.poll();
            int node = minPr.node;
            int dist = minPr.distance;
            if (distArr[node] < dist) { // already blasted
                continue;
            } else {

                if(hm.containsKey(node)) {
                    int size = hm.get(node).size();

                    for (int i = 0; i < size; i++) {
                        Pair Cpr = hm.get(node).get(i);
                        int n = Cpr.node;
                        int t = Cpr.distance;
                        if (distArr[n] > (distArr[node] + t)) {
                            distArr[n] = distArr[node] + t;
                            // System.out.println(distArr[n]);
                            minHeap.add(new Pair(n, distArr[n]));
                        }
                    }
                }
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < distArr.length; i++) {
            if (distArr[i] == Integer.MAX_VALUE) {
                arr.add(-1);
            } else {
                arr.add(distArr[i]);
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        dijsktra dj = new dijsktra();
        int A = 6;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<Integer>(Arrays.asList(0, 4, 9)));
        B.add(new ArrayList<Integer>(Arrays.asList(3, 4, 6)));
        B.add(new ArrayList<Integer>(Arrays.asList(1, 2, 1)));
        B.add(new ArrayList<Integer>(Arrays.asList(2, 5, 1)));
        B.add(new ArrayList<Integer>(Arrays.asList(2, 4, 5)));
        B.add(new ArrayList<Integer>(Arrays.asList(0, 3, 7)));
        B.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1)));
        B.add(new ArrayList<Integer>(Arrays.asList(4, 5, 7)));
        B.add(new ArrayList<Integer>(Arrays.asList(0, 5, 1)));
        int C = 4;

        dj.solve(A, B, C);
    }
}
