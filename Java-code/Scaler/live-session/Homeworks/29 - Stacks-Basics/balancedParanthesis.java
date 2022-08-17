import java.util.Stack;

public class balancedParanthesis {
    public int solve(String A) {
        int N = A.length();

        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < N; i++) {
            char bracket = A.charAt(i);
            if (charStack.isEmpty()) {
                if(bracket == ']' || bracket =='}' || bracket == ')') {
                    return 0;
                } else {
                    charStack.push(bracket);
                }
            } else {
                if (charStack.peek() == '[' && bracket == ']') {
                    charStack.pop();
                } else if (charStack.peek() == '{' && bracket == '}') {
                    charStack.pop();
                } else if (charStack.peek() == '(' && bracket == ')') {
                    charStack.pop();
                } else {
                    charStack.push(bracket);
                }
            }
        }
        System.out.println("Final => " + charStack);
        return charStack.isEmpty() ? 1 : 0;
    }
    public static void main(String[] args) {
        balancedParanthesis bp = new balancedParanthesis();
        // String A = "{([])}";
        // String A = "(){";
        String A = "()[]";
        bp.solve(A);
    }
}
