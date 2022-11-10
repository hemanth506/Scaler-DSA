import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class slidingWindowMax {
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        int N = A.size();
        ArrayList<Integer> resList = new ArrayList<>();;
        if(N == 1) {
            resList.add(A.get(0));
            return resList;
        }

        Deque<Integer> deq = new LinkedList<>();
        for(int i = 0; i < B; i++) {
            int curVal = A.get(i);
            while(!deq.isEmpty() && deq.peekLast() < curVal) {
                deq.pollLast();
            }
            deq.add(curVal);
        }
        resList.add(deq.peekFirst());
        // System.out.println(deq);
        // System.out.println(resList);

        for(int i = B, j = 0; i < N; i++, j++) {
            // System.out.println(j + " " + i);
            int curVal = A.get(i);
            int remVal = A.get(j);

            while(!deq.isEmpty() && deq.peekLast() < curVal) {
                deq.pollLast();
            }
            deq.addLast(curVal);
            // System.out.println(remVal + " " + deq.peekFirst());
            if(remVal == (int) deq.peekFirst()) {
                deq.pollFirst();
            }
            resList.add(deq.peekFirst());
        }
        System.out.println(resList);
        return resList;
    }
    public static void main(String[] args) {
        slidingWindowMax sw = new slidingWindowMax();
        // final List<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 3, -1, -3, 5, 3, 6, 7));
        // int B = 3;

        final List<Integer> A = new ArrayList<Integer>(Arrays.asList(648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368));
        int B = 9;

        sw.slidingMaximum(A, B);
    }
}
