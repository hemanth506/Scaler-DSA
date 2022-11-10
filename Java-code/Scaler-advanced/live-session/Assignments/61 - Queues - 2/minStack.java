import java.util.Stack;

public class minStack {
    Stack<Integer> stk = new Stack<>();
    Stack<Integer> minStk = new Stack<>();
    int minV = Integer.MAX_VALUE;
    public void push(int x) {
        stk.add(x);
        minV = Integer.min(minV, x);
        minStk.add(minV);
    }

    public void pop() {
        if(!stk.isEmpty()) {
            minStk.pop();
            stk.pop();
        }
        // Make sure to update the minV after popping
        if(!stk.isEmpty()) {
            minV = minStk.peek();
        } else {
            minV = Integer.MAX_VALUE;
        }
    }

    public int top() {
        if(stk.isEmpty()) {
            return -1;
        }
        return stk.peek();
    }

    public int getMin() {
        if(stk.isEmpty()) {
            return -1;
        }
        return minStk.peek();   
    }
}
