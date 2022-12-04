import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class kthSmallestElt {
    public int kthsmallest(final List<Integer> A, int B) {
        int N = A.size();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            minHeap.add(A.get(i));
        }

        int res = 0;
        for(int i = 0; i < B; i++) {
            res = minHeap.peek();
            minHeap.poll();
        }
        System.out.println(res);
        return res;
    }
    public static void main(String[] args) {
        kthSmallestElt kse = new kthSmallestElt();
        List<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 1, 4, 3, 2));
        int B = 3;
        kse.kthsmallest(A, B);
    }


}
