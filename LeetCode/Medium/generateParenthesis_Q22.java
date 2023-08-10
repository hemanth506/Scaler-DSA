/*
 * The approach which I started was correct as backtracking
 * but was not able to come up with a solution. 
 * So got some help from Youtube videos
 */

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis_Q22 {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        res = new ArrayList<>();
        generate(sb, 0, 0, n);
        System.out.println(res);
        return res;
    }

    private void generate(StringBuilder sb, int open, int close, int N) {
        if (open == N && close == N) {
            System.out.println("result = " + sb);
            res.add(sb.toString());
            return;
        }

        if (open < N) {
            System.out.println("sb 1 = " + sb);
            generate(sb.append('('), open + 1, close, N);
            sb.deleteCharAt(sb.length() - 1);
        }

        System.out.println("sb 3 = " + sb);
        if (open > close) {
            generate(sb.append(')'), open, close + 1, N);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {
        generateParenthesis_Q22 gp = new generateParenthesis_Q22();
        int n = 3;
        gp.generateParenthesis(n);
    }
}

/*
 * private void generate_OLD(int n) {
 * if (n <= 0) {
 * System.out.println("Return = " + n);
 * return;
 * }
 * 
 * sb.append('(');
 * System.out.println("append = (");
 * generate(n - 1);
 * System.out.println("After 1 = " + sb);
 * sb.deleteCharAt(sb.length()-1);
 * sb.append(')');
 * generate(n - 1);
 * 
 * System.out.println("append = )");
 * System.out.println("After 2 = " + sb);
 * // res.add(sb.toString());
 * }
 */
