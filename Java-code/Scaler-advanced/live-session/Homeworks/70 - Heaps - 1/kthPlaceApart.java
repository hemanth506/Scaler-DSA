import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class kthPlaceApart {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        int ct = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        while (!minHeap.isEmpty() || ct < N) {
            if(ct <= B) {
                minHeap.add(A.get(ct));
            } else {
                arr.add(minHeap.peek());
                minHeap.poll();
                if(ct < N) {
                    minHeap.add(A.get(ct));
                }
            }
            ct += 1;
        }
        // System.out.println(arr);
        return arr;
    }
    public static void main(String[] args) {
        kthPlaceApart kt = new kthPlaceApart();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 40, 2, 3));
        int B = 2;
        kt.solve(A, B);
    }
}
