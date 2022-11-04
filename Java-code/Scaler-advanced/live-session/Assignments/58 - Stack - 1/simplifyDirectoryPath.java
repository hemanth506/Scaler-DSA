import java.util.Stack;

public class simplifyDirectoryPath {
    public String simplifyPath(String A) {
        int N = A.length();
        
        // there may be changes of this example with no leading slashes = "/a/./b/../../c" so added an extra slash
        A += '/';

        Stack<String> stk = new Stack<>();
        for(int i = 0; i < N-1; i++) {
            char c = A.charAt(i);
            char cPlus = A.charAt(i+1);
            if(c == '/') { // there may be double slashes which should be considered as single slash
                if(cPlus == '/') {
                    i+=1;
                }
            } else {
                if(c != '.') {
                    // there might be single character as "a" or "b" or even a string "home"
                    StringBuilder sb = new StringBuilder();
                    while (A.charAt(i) != '/') {
                        sb.append(A.charAt(i));
                        i+=1;
                    }
                    stk.add(sb.toString());
                } else if (c == '.' && cPlus == '.') { // if it has double dots then it is considered as going back.
                    if(!stk.isEmpty()) {
                        stk.pop();
                    }
                }
            }
        }
        if(stk.isEmpty()) {
            System.out.println("/");
            return "/";
        }
        System.out.println("stk = " + stk);
        Stack<String> revStk = new Stack<>();
        while (!stk.isEmpty()) {
            revStk.add(stk.peek());
            stk.pop();
        }
        StringBuilder sbFinal = new StringBuilder();
        while (!revStk.isEmpty()) {
            sbFinal.append('/');
            sbFinal.append(revStk.peek());
            revStk.pop();
        }

        System.out.println(sbFinal);
        return sbFinal.toString();
    }
    public static void main(String[] args) {
        simplifyDirectoryPath sp = new simplifyDirectoryPath();
        // String A = "/a/./b/../../c/";
        // String A = "/home/";
        String A = "/../";
        sp.simplifyPath(A);
    }
}
