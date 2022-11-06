import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class taskScheduling {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int Na = A.size();
        int Nb = B.size();
        Deque<Integer> que = new LinkedList<>();;
        for(int i = 0; i < Na; i++) {
            que.add(A.get(i));
        }
        System.out.println(que);

        int totalCycle = 0;
        for(int i = 0; i < Nb; i++) {
            int cycle = 0;
            // while(que.peek() != (int) (B.get(i)))
            while(!que.peek().equals(B.get(i))) {
                cycle += 1;
                que.add(que.peek());
                que.remove();
            }
            que.remove();
            totalCycle += cycle + 1;
        }
        System.out.println(totalCycle);
        return totalCycle;
    }
    public static void main(String[] args) {
        taskScheduling ts = new taskScheduling();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 3, 1, 5, 4));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 4, 2));

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(6, 7, 1, 2, 4, 5, 8, 3));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(3, 7, 2, 5, 1, 8, 4, 6));


        ts.solve(A, B);
    }
}
