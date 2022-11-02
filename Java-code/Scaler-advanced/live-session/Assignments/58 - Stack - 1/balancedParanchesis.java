import java.util.Stack;

public class balancedParanchesis {
    public int solve(String A) {
        int N = A.length();
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (A.charAt(i) == '{' || A.charAt(i) == '(' || A.charAt(i) == '[') {
                stk.add(A.charAt(i));
            } else {
                if(stk.isEmpty()) {
                    System.out.println("Incorrect seq empty");
                    return 0;
                }
                System.out.println(A.charAt(i) + "=" + stk.peek());
                if(A.charAt(i) == '}' && stk.peek() == '{') {
                    stk.pop();
                } else if(A.charAt(i) == ')' && stk.peek() == '(') {
                    stk.pop();
                } else if(A.charAt(i) == ']' && stk.peek() == '[') {
                    stk.pop();
                } else {
                    System.out.println("Incorrect seq condition");
                    return 0;
                }
            }
        }
        if(!stk.isEmpty()) {
            System.out.println("Incorrect seq not empty");
            return 0;
        }
        System.out.println("correct seq");

        return 1;
    }

    public static void main(String[] args) {
        balancedParanchesis bh = new balancedParanchesis();
        // String A = "{([])}";
        // String A = "(){";
        String A = "()[]";


        bh.solve(A);
    }
}
