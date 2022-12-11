import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {
    int time;
    int profit;

    Pair(int t, int p) {
        this.time = t;
        this.profit = p;
    }
}

class sortPair implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return o1.time - o2.time;
    }
}

public class freeCars {

    public void print(int N, ArrayList<Pair> allPairs) {
        System.out.println("=============");
        for (int i = 0; i < N; i++) {
            Pair cr = allPairs.get(i);
            System.out.print(cr.time + " ");
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            Pair cr = allPairs.get(i);
            System.out.print(cr.profit + " ");
        }
        System.out.println();
        System.out.println("=============");
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int N = A.size();
        int mod = 1000000007;

        ArrayList<Pair> allPairs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            allPairs.add(new Pair(A.get(i), B.get(i)));
        }
        
        Collections.sort(allPairs, new sortPair());
        // print(N, allPairs);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int time = 0;
        for (Pair curPair: allPairs) {
            if (time < curPair.time) {
                time++;
                minHeap.add(curPair.profit);
            } else {
                if (minHeap.peek() < curPair.profit) {
                    minHeap.poll();
                    minHeap.add(curPair.profit);
                }
            }
        }

        int total = 0;
        while(!minHeap.isEmpty()) {
            int poll = minHeap.poll();
            total += poll;
            total %= mod;
        }
        System.out.println(total);
        return total;
    }

    public static void main(String[] args) {
        freeCars fc = new freeCars();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 7, 6, 2, 8, 4,
        // 4, 6, 8, 2));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(8, 11, 7, 7, 10,
        // 8, 7, 5, 4, 9));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 3, 2, 3, 3));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(5, 6, 1, 3, 9));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 1, 2, 1, 3));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(100, 19, 27, 25,
        // 30));

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(6, 8, 5, 4, 2, 1, 6, 4, 2, 8, 5, 4, 4, 8, 8, 5, 3, 4, 4, 5, 8, 5, 5, 7, 2, 4, 5, 2, 6));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(11, 10, 8, 10, 5, 7, 5, 9, 8, 7, 11, 5, 7, 4, 7, 9, 8, 5, 5, 5, 8, 11, 8, 4, 4, 2, 9, 6, 6));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 8, 7, 5));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(3, 1, 7, 19));
        fc.solve(A, B);
    }

}