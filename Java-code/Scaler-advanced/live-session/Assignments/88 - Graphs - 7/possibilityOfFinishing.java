import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class possibilityOfFinishing {
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int N = B.size();
        HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        int[] dependency = new int[A+1];
        for(int i = 0; i < N; i++) {
            int src = B.get(i);
            int dest = C.get(i);
            dependency[dest]++;
            ArrayList<Integer> arr;
            if(adjList.containsKey(src)) {
                arr = adjList.get(src);
            } else {
                arr = new ArrayList<>();
            }
            arr.add(dest);
            adjList.put(src, arr);
        }
        System.out.println(Arrays.toString(dependency));
        System.out.println(adjList);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 1; i < A+1; i++) {
            if(dependency[i] == 0) {
                minHeap.add(i);
            }
        }

        System.out.println(minHeap);
        while(!minHeap.isEmpty()) {
            int curVal = minHeap.poll();
            if(adjList.containsKey(curVal)) {
                ArrayList<Integer> arr = adjList.get(curVal);
                int QN = arr.size();
                for(int i = 0; i < QN; i++) {
                    dependency[arr.get(i)]--;
                    if(dependency[arr.get(i)] == 0) {
                        minHeap.add(arr.get(i));
                    }
                }
            }
        }

        System.out.println(Arrays.toString(dependency));
        for(int i = 1;i < A+1; i++) {
            if(dependency[i] != 0) {
                System.out.println("not completed");
                return 0;
            }
        }
        System.out.println("Completed");


        return 1;
    }
    public static void main(String[] args) {
        possibilityOfFinishing pf = new possibilityOfFinishing();
        // int A = 5;
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 5));
        // ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(2, 1, 5, 3));

        int A = 2;
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1,2));
        ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(2,1));

        pf.solve(A, B, C);
    }
}
