import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class sortStackUsingAnotherStack {
    public Stack<Integer> mergeStack(Stack<Integer> A, Stack<Integer> B) {
        Stack<Integer> res = new Stack<>();
        while (!A.isEmpty() && !B.isEmpty()) {
            if (A.peek() < B.peek()) {
                res.add(A.peek());
                A.pop();
            } else {
                res.add(B.peek());
                B.pop();
            }
        }

        while (!A.isEmpty()) {
            res.add(A.peek());
            A.pop();
        }

        while (!B.isEmpty()) {
            res.add(B.peek());
            B.pop();
        }

        Stack<Integer> stk = new Stack<>();
        while (!res.isEmpty()) {
            stk.add(res.peek());
            res.pop();
        }
        System.out.println(stk);
        return res;
    }

    public ArrayList<Integer> mergeArrayList(ArrayList<Integer> A,int A1Str, int A1End, int A2Str, int A2End) {
        ArrayList<Integer> res = new ArrayList<>();
        int p1 = A1Str;
        int p2 = A2Str;
        while (p1 <= A1End && p2 <= A2End) {
            if (A.get(p1) < A.get(p2)) {
                res.add(A.get(p1));
                p1++;
            } else {
                res.add(A.get(p2));
                p2++;
            }
        }

        while (p1 <= A1End) {
            res.add(A.get(p1));
            p1++;
        }

        while (p2 <= A2End) {
            res.add(A.get(p2));
            p2++;
        }

        if(res.size() != 0) {
            for(int i = 0, j = A1Str; j <= A2End; i++, j++) {
                A.set(j, res.get(i));
            }
        }
        return A;
    }

    public void mergeSort(ArrayList<Integer> A, int start, int end) {
        if (start == end) {
            return;
        }
        int tempEnd = end;
        tempEnd = (start + end) / 2;
        mergeSort(A, start, tempEnd);
        mergeSort(A, tempEnd + 1, end);
        mergeArrayList(A, start, tempEnd, tempEnd+1, end);
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int N = A.size();
        mergeSort(A, 0, N-1);
        return A;
    }

    public static void main(String[] args) {
        sortStackUsingAnotherStack ss = new sortStackUsingAnotherStack();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5, 17, 100, 11));
        ss.solve(A);

        // Stack<Integer> A = new Stack<Integer>();
        // A.add(10);
        // A.add(9);
        // A.add(8);
        // A.add(6);
        // A.add(3);
        // Stack<Integer> B = new Stack<Integer>();
        // B.add(13);
        // B.add(11);
        // B.add(4);
        // B.add(2);
        // B.add(1);
        // ss.mergeStack(A, B);

    }
}
