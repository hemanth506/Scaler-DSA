import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class connectRopes {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            minHeap.add(A.get(i));
        }

        int total = 0;
        while(!minHeap.isEmpty() && minHeap.size() != 1) {
            int min1 = minHeap.peek();
            minHeap.poll();
            int min2 = minHeap.peek();
            minHeap.poll(); 
            int length = min1 + min2;
            System.out.println("length = " + length);
            total += length;
            minHeap.add(length);
        }
        System.out.println(total);
        return total;
    }
    public static void main(String[] args) {
        connectRopes cr = new connectRopes();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        cr.solve(A);
    }
}
