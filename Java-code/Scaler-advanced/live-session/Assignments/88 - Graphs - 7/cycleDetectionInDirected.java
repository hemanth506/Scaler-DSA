import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class cycleDetectionInDirected {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int N = B.size();
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        int[] dependent = new int[A+1];

        for(int i = 0; i < N; i++) {
            int src = B.get(i).get(0);
            int dest = B.get(i).get(1);
            ArrayList<Integer> arr;
            if(adjList.containsKey(src)) {
                arr = adjList.get(src);
                arr.add(dest);
                dependent[dest]++;
            } else {
                arr = new ArrayList<>();
                arr.add(dest);
                dependent[dest]++;
            }
            adjList.put(src, arr);
        }

        System.out.println(adjList);
        System.out.println(Arrays.toString(dependent));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < A+1; i++) {
            if(dependent[i] == 0 && i != 0) {
                minHeap.add(i);
            }
        }

        System.out.println(minHeap);
        ArrayList<Integer> finalArr = new ArrayList<>();
        if(minHeap.isEmpty()) {
            System.out.println(1);
            return 1;
        }

        int ct = 0;
        while (!minHeap.isEmpty()) {
            int curVal = minHeap.poll();
            finalArr.add(curVal);
            ct += 1;
            if(adjList.containsKey(curVal)) {
                int sz = adjList.get(curVal).size();
                ArrayList<Integer> adjArr = adjList.get(curVal);
                for(int i = 0; i < sz; i++) {
                    dependent[adjArr.get(i)]--;
                    if(dependent[adjArr.get(i)] == 0) {
                        minHeap.add(adjArr.get(i));
                    }
                }
            }
        }
        System.out.println(finalArr);
        System.out.println(ct);
        if(ct < A) {
            System.out.println(1);
            return 1;
        }
        System.out.println(0);

        return 0;
    }
    public static void main(String[] args) {
        cycleDetectionInDirected cd = new cycleDetectionInDirected();
        int A = 5;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        B.add(new ArrayList<Integer>(Arrays.asList(4, 1)));
        B.add(new ArrayList<Integer>(Arrays.asList(2, 4)));
        B.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
        B.add(new ArrayList<Integer>(Arrays.asList(5, 2)));
        B.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
        cd.solve(A, B);
    }
}
