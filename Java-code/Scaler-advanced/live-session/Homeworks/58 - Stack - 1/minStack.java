import java.util.ArrayList;

public class minStack {
    ArrayList<Integer> stackVal = new ArrayList<Integer>();
    ArrayList<Integer> minVal = new ArrayList<Integer>();
    int minV = Integer.MAX_VALUE;
    int size = 0;

    public void push(int x) {
        stackVal.add(x);
        minV = Integer.min(minV, x);
        minVal.add(minV);
        size += 1;
    }

    public void pop() {
        if(size > 0) {
            stackVal.remove(size - 1);
            minVal.remove(size - 1);
            size -= 1;
            if(size == 0) {
                minV = Integer.MAX_VALUE;
            } else {
                minV = getMin();
            }
        }
    }

    public int top() {
        if(size > 0) {
            return stackVal.get(size - 1);
        }
        return -1;
    }

    public int getMin() {
        if(size > 0) {
            return minVal.get(size - 1);
        }
        return -1;
    }
}
