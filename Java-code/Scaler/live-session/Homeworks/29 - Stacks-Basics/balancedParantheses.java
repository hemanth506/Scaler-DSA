import java.util.Stack;

public class balancedParantheses {
    public int solve(String A) {
        int N = A.length();

        Stack<Character> charStack = new Stack<>();
        for(int i = 0; i < N; i++) {
            if(charStack.isEmpty()) {
                if(A.charAt(i) == '(') {
                    charStack.push('(');
                    System.out.println("Push => " + charStack);
                    
                } else {
                    System.out.println("Not balanced => " + charStack);
                    System.out.println();
                    return 0;
                }
            } else {
                if (A.charAt(i) == ')' && charStack.peek() == '(') {
                    System.out.println("Before pop => " + charStack);
                    charStack.pop();
                    System.out.println("After pop => " + charStack);
                } else {
                    charStack.push(A.charAt(i));
                    System.out.println("Push => " + charStack);
                }
            }
            System.out.println("=============");
        }
        System.out.println("Final => " + charStack);
        return charStack.isEmpty() ? 1 : 0;
    }
    public static void main(String[] args) {
        balancedParantheses bp = new balancedParantheses();
        String A = "(()())";
        // String A = "(()((((()(";
        bp.solve(A);
    }
}
