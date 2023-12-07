import java.util.ArrayList;

public class generateParenthesisString {
  ArrayList<String> strArr;

  public void generate(int open, int close, int A, StringBuilder sb, int totalStrLen) {
    if (open == A && close == A && sb.length() == totalStrLen) {
      strArr.add(sb.toString());
      return;
    }

    if (open > A || open < close || sb.length() > totalStrLen) {
      return;
    }

    generate(open + 1, close, A, sb.append("("), totalStrLen);
    sb.deleteCharAt(sb.length() - 1);
    generate(open, close + 1, A, sb.append(")"), totalStrLen);
    sb.deleteCharAt(sb.length() - 1);
  }

  public ArrayList<String> generateParenthesis(int A) {
    strArr = new ArrayList<>();
    if (A == 0) {
      return strArr;
    }

    int open = 0;
    int close = 0;
    StringBuilder sb = new StringBuilder();
    generate(open, close, A, sb, A * 2);
    System.out.println(strArr);
    return strArr;
  }

  public static void main(String[] args) {
    generateParenthesisString gps = new generateParenthesisString();
    int A = 2;
    gps.generateParenthesis(A);
  }
}
