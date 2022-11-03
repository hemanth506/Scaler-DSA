import java.util.ArrayList;
import java.util.Stack;

public class infixToPostfix {
    public int priority(char op) {
        int val = 0;
        switch (op) {
            case '+':
            case '-':
                val = 1;
                break;
            case '*':
            case '/':
                val = 2;
                break;
            case '^':
                val = 3;
                break;
            default:
                break;
        }
        return val;
    }

    public String solve(String A) {
        int N = A.length();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<Character>();
        ArrayList<Character> op = new ArrayList<Character>();
        op.add('+');
        op.add('-');
        op.add('/');
        op.add('*');
        op.add('^');

        for (int i = 0; i < N; i++) {
            char c = A.charAt(i);
            if (!op.contains(c) && c != '(' && c != ')') {
                System.out.println("cond 1 " + c);
                sb.append(c);
            } else if (c == '(') {
                System.out.println("cond 2 " + c);
                stk.add(c);
            } else if (c == ')') {
                System.out.println("cond 3 " + c);
                while (stk.peek() != '(') {
                    sb.append(stk.peek());
                    stk.pop();
                }
                stk.pop();
            } else if (op.contains(c)) {
                System.out.println("cond 4 " + c);
                while (!stk.isEmpty() && priority(stk.peek()) >= priority(c)) {
                    System.out.println(stk.peek() + " " + c);
                    sb.append(stk.peek());
                    stk.pop();
                }
                stk.add(c);
            }
        }
        System.out.println(stk);
        while(!stk.isEmpty()) {
            sb.append(stk.peek());
            stk.pop();
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        infixToPostfix ip = new infixToPostfix();
        // String A = "a+b*(c^d-e)^(f+g*h)-i";
        // String A = "-(a+b+c)";
        String A = "-a-b-c";

        ip.solve(A);
    }
}
