import java.util.ArrayList;
import java.util.Stack;

public class redundantBraces {
    public int braces(String A) {
        int N = A.length();
        Stack<Character> operator = new Stack<>();
        ArrayList<Character> op = new ArrayList<>();
        op.add('+'); op.add('-');
        op.add('/'); op.add('*'); 

        for(int i = 0; i < N; i++) {
            if(A.charAt(i) == '(' || op.contains(A.charAt(i))) {
                operator.add(A.charAt(i));
            } else {
                if(A.charAt(i) == ')') {
                    // there might be multiple op within the brackets.
                    boolean containsOp = false;
                    while(op.contains(operator.peek())) {
                        operator.pop();
                        containsOp = true;
                    }
                    // only pop the opening brackets when it has an operator.
                    if(containsOp) {
                        operator.pop();
                    }
                }
            }
        }

        int opSize = operator.size();
        for(int i = 0; i < opSize; i++) {
            if(operator.get(i) == '(') {
                return 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        redundantBraces rb = new redundantBraces();
        // String A = "(a+(a+b))";
        // String A = "(a*b)+(b*(d+(a)))";
        String A = "((a+b))";

        rb.braces(A);
    }
}
