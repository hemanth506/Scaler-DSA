import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class nearestSmallestNumber {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        int N = A.size();
        Stack<Integer> stk = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        stk.add(A.get(0));
        arr.add(-1);
        for(int i = 1; i < N; i++) {
            System.out.println(A.get(i));
            while (!stk.isEmpty() && A.get(i) <= stk.peek()) {
                stk.pop();
            }
            if(!stk.isEmpty()) {
                arr.add(i, stk.peek());
            } else {
                arr.add(i, -1);
            }

            stk.add(A.get(i));
        }
        System.out.println(stk);
        System.out.println(arr);
        return arr;
    }
    public static void main(String[] args) {
        nearestSmallestNumber ns = new nearestSmallestNumber();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(4, 5, 2, 10, 8));
        ns.prevSmaller(A);
    }
}
