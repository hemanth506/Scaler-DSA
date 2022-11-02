import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class evaluateExpression {
    public int operations(int a, int b, String op) {
        int result = 0;
        switch (op) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "/":
                result = a / b;
                break;
            case "*":
                result = a * b;
                break;
            default:
                break;
        }
        return result;
    }

    public int evalRPN(ArrayList<String> A) {
        int N = A.size();
        Stack<String> stk = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (A.get(i).equals("+") || A.get(i).equals("-") || A.get(i).equals("/") || A.get(i).equals("*")) {
                int stkSize = stk.size();
                if (!stk.isEmpty() && stkSize >= 2) {
                    String op = A.get(i);
                    int a = Integer.parseInt(stk.get(stkSize - 2));
                    int b = Integer.parseInt(stk.get(stkSize - 1));
                    int val = operations(a, b, op);
                    stk.pop();
                    stk.pop();
                    stk.add(String.valueOf(val));
                }
            } else {
                stk.add(A.get(i));
            }
        }

        int finResult = Integer.parseInt(stk.get(0));
        System.out.println(finResult);
        return finResult;
    }

    public static void main(String[] args) {
        evaluateExpression ee = new evaluateExpression();
        // ArrayList<String> A = new ArrayList<String>(Arrays.asList("2", "1", "+", "3", "*"));
        // ArrayList<String> A = new ArrayList<String>(Arrays.asList("4", "13", "5", "/", "+"));
        ArrayList<String> A = new ArrayList<String>(Arrays.asList("2", "2", "/"));
        
        ee.evalRPN(A);
    }
}
