import java.util.Stack;

public class doubleCharacterTrouble {
    public String solve(String A) {
        int N = A.length();
        if(N == 1) {
            return A;
        }
        Stack<Character> stk = new Stack<>();
        stk.add(A.charAt(0));
        for(int i = 1; i < N; i++) {
            if(!stk.isEmpty() && stk.peek() == A.charAt(i)) {
                stk.pop();
            } else {
                stk.add(A.charAt(i));
            }
        }
        System.out.println(stk);
        if(!stk.isEmpty()) {
            int stkSize = stk.size();
            Stack<Character> revStk = new Stack<>();
            for(int i = 0; i < stkSize; i++) {
                revStk.add(stk.peek());
                stk.pop();
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < stkSize; i++) {
                sb.append(revStk.peek());
                revStk.pop();
            }
            System.out.println(sb);
            return sb.toString();
        }
        return "";
    }
    public static void main(String[] args) {
        doubleCharacterTrouble dct = new doubleCharacterTrouble();
        String A = "acbbcd";
        dct.solve(A);
    }
}
