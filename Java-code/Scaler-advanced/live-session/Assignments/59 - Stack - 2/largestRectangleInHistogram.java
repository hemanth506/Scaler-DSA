import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class largestRectangleInHistogram {
    public int[] minFromLeft(ArrayList<Integer> A, int N) {
        Stack<Integer> stk = new Stack<Integer>();
        int[] arr = new int[N];
        Arrays.fill(arr, -1);
        for(int i = 0; i < N; i++) {
            while(!stk.isEmpty() && A.get(i) <= A.get(stk.peek())) {
                stk.pop();
            }
            if(!stk.isEmpty()) {
                arr[i] = stk.peek();
            }
            stk.add(i);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public int[] minFromRight(ArrayList<Integer> A, int N) {
        Stack<Integer> stk = new Stack<Integer>();
        int[] arr = new int[N];
        Arrays.fill(arr, N);
        for(int i = N-1; i >= 0; i--) {
            while(!stk.isEmpty() && A.get(i) <= A.get(stk.peek())) {
                stk.pop();
            }
            if(!stk.isEmpty()) {
                arr[i] = stk.peek();
            }
            stk.add(i);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public int largestRectangleArea(ArrayList<Integer> A) {
        int N = A.size();
        int[] minLeft = minFromLeft(A, N);
        int[] minRight = minFromRight(A, N);

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            int p1 = minLeft[i];
            int p2 = minRight[i];
            int ctCubes = (p2 - p1 - 1);
            int area = ctCubes * A.get(i);
            max = Integer.max(area, max);
        }
        System.out.println(max);
        return max;
    }
    public static void main(String[] args) {
        largestRectangleInHistogram lg = new largestRectangleInHistogram();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 1, 5, 6, 2, 3));
        lg.largestRectangleArea(A);
    }
}
