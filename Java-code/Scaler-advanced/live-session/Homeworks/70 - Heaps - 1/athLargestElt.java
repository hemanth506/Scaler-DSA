import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class athLargestElt {
    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        int N = B.size();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if(i > (A-1)) {
                if(minHeap.peek() <= B.get(i)) {
                    minHeap.add(B.get(i));
                    minHeap.poll();
                }
                res.add(minHeap.peek());
            } else {
                minHeap.add(B.get(i));
                if(i == (A-1)) {
                    res.add(minHeap.peek());
                } else {
                    res.add(-1);
                }
            }
        }
        System.out.println(res);
        return res;
    }
    
    public static void main(String[] args) {
        athLargestElt ale = new athLargestElt();
        // int A = 4;
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));

        // int A = 2;
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(15, 20, 99, 1));

        int A = 4;
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(3, 65, 34, 23, 12, 4, 6, 34, 67, 22, 98, 13));
        ale.solve(A, B);
    }
}

// -1, -1, -1, 3, 12, 12, 12, 23, 34, 34, 34, 34
// -1  -1  -1  3  12  12  12  23  34  34  34  34
