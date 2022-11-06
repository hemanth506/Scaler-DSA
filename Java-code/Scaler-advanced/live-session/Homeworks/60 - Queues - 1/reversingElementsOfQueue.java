import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class reversingElementsOfQueue {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        Stack<Integer> stk = new Stack<>();
        ArrayList<Integer> C = new ArrayList<Integer>();
        
        for(int i = 0; i < B; i++) {
            stk.add(A.get(i));
        }

        while(!stk.isEmpty()) {
            C.add(stk.peek());
            stk.pop();
        }

        for(int i = B; i < N; i++) {
            int val = A.get(i);
            C.add(val);
        }

        return C;
    }

    public static void main(String[] args) {
        reversingElementsOfQueue re = new reversingElementsOfQueue();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        int B = 5;
        re.solve(A, B);
    }
}
