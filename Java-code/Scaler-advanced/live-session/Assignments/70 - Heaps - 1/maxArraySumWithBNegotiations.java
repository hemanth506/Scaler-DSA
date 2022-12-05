import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class maxArraySumWithBNegotiations {
    public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            minHeap.add(A.get(i));
        }

        for(int i = 0; i < B; i++) {
            int val = minHeap.peek();
            minHeap.poll();
            minHeap.add(-val);
        }

        int total = 0;
        int size = minHeap.size();
        for(int i = 0; i < size; i++) {
            total += minHeap.peek();
            minHeap.poll();
        }

        System.out.println(total);

        return total;
    }
    public static void main(String[] args) {
        maxArraySumWithBNegotiations ms = new maxArraySumWithBNegotiations();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(24, -68, -29, -9, 84));
        int B = 4;
        ms.solve(A, B);
    }
}
