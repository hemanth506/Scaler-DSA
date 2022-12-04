import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class runningMedian {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int N = A.size();
        PriorityQueue<Integer> box1 = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> box2 = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        box1.add(A.get(0));
        res.add(box1.peek());

        for(int i = 1; i < N; i++) {
            int curVal = A.get(i);
            if(box1.peek() < curVal) {
                box2.add(curVal);
            } else {
                box1.add(curVal); 
            }


            int length = box1.size() - box2.size();
            if(length == 1 || length == 0) {
                res.add(box1.peek());
            } else {
                if(box1.size() < box2.size()) {
                    box1.add(box2.peek());
                    box2.poll();
                } else {
                    box2.add(box1.peek());
                    box1.poll();
                }
                res.add(box1.peek());
            }
        }

        System.out.println(res);
        return res;
    }
    public static void main(String[] args) {
        runningMedian rm = new runningMedian();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 5, 4, 3));

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5, 17, 100, 11));

        rm.solve(A);
    }
}
