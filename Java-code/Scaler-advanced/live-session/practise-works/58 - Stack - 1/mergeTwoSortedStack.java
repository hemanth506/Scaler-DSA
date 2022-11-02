import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class mergeTwoSortedStack {
    public Stack<Integer> solve (ArrayList<Integer> A, ArrayList<Integer> B) {
        int Na = A.size();
        int Nb = B.size();
        Stack<Integer> stk = new Stack<Integer>();
        int p1 = 0, p2 = 0;
        while (p1 < Na && p2 < Nb) {
            if(A.get(p1) < B.get(p2)) {
                stk.add(A.get(p1));
                p1++;
            } else {
                stk.add(B.get(p2));
                p2++;
            }
        }
        if(p1 < Na) {
            while(p1 < Na) {
                stk.add(A.get(p1));
                p1++;
            }
        } else {
            while(p2 < Nb) {
                stk.add(B.get(p2));
                p2++;
            }
        }
        System.out.println(stk);
        Stack<Integer> revStk = new Stack<Integer>();
        while(!stk.isEmpty()) {
            revStk.add(stk.peek());
            System.out.println(stk.peek());
            stk.pop();
        }
        System.out.println(revStk);
        return stk;
    }
    public static void main(String[] args) {
        mergeTwoSortedStack mts = new mergeTwoSortedStack();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2,4,5,8,9,13));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1,5,7,9,12,13,15,17));

        mts.solve(A, B);
    }
}
