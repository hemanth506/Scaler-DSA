import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class nextGreatest {
    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        int N = A.size();
        Stack<Integer> stk = new Stack<Integer>();
        ArrayList<Integer> arr = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            arr.add(-1);
        }
        for(int i = N - 1; i >= 0; i--) {
            while(!stk.isEmpty() && A.get(i) >= stk.peek()) {
                stk.pop();
            }
            System.out.println(arr);
            if(!stk.isEmpty()) {
                arr.set(i, stk.peek());
            }
            stk.add(A.get(i));
        }
        System.out.println(arr);
        return arr;
    }
    public static void main(String[] args) {
        nextGreatest ng = new nextGreatest();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(4, 5, 2, 10));
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3,2,1));
        
        ng.nextGreater(A);
    }
}
