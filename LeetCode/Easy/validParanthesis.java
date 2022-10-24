import java.util.Stack;

public class validParanthesis {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        int N = s.length();
        for(int i = 0; i < N; i++) {
            if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stk.add(s.charAt(i));
            } else {
                if(stk.isEmpty()) {
                    return false;
                }
                System.out.println(s.charAt(i));
                char peekElt = stk.peek();
                if(s.charAt(i) == '}' && peekElt != '{') {
                    return false;
                } else if (s.charAt(i) == ')' && peekElt != '(') {
                    return false;
                } else if (s.charAt(i) == ']' && peekElt != '[') {
                    return false;
                }
                stk.pop();
            }
        }
        if(stk.isEmpty()) {
            System.out.println(true);
            return true;
        } else {
            System.out.println(false);
            return false;
        }
    }
    public static void main(String[] args) {
        validParanthesis vp = new validParanthesis();
        String s = "{[]}";
        vp.isValid(s);
    }
}
