import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class magicianAndChocolates {
    public int nchoc(int A, ArrayList<Integer> B) {
        int N = B.size();
        int mod = 1000000007;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i = 0; i< N; i++) {
            maxHeap.add(B.get(i));
        }

        long total = 0;
        for(int i = 0; i < A; i++) {
            int curMax = maxHeap.peek();
            total = (total + curMax)%mod;
            maxHeap.poll();
            maxHeap.add(curMax/2);
        }

        System.out.println(total);
        return (int)(total%mod);
    }

    public static void main(String[] args) {
        magicianAndChocolates mc = new magicianAndChocolates();
        int A = 5;
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(2, 4, 6, 8, 10));
        mc.nchoc(A, B);
    }
}
