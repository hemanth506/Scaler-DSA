import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class passingGame {
    public int solve(int A, int B, ArrayList<Integer> C) {
        Stack<Integer> stk = new Stack<>();
        stk.add(B);
        for(int i = 0; i < A; i++) {
            if(C.get(i) == 0) {
                stk.pop();
            } else {
                stk.add(C.get(i));
            }
        }
        System.out.println(stk.peek());
        return stk.peek();
    }
    public static void main(String[] args) {
        passingGame pg = new passingGame();
        int A = 10;
        int B = 23;
        ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(86, 63, 60, 0, 47, 0, 99, 9, 0, 0));
        pg.solve(A, B, C);
    }
}
