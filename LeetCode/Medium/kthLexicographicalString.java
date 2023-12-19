public class kthLexicographicalString {
  String kthString = "";
  int kth;

  private void solve(StringBuilder sb, int iter, int k, int n) {
    if (iter == n) {
      System.out.println("Inside base case " + kth + " " + sb.toString());
      if (kth == k) {
        kthString = sb.toString();
      }
      kth += 1;
      return;
    }

    char curChar = ' ';
    if (sb.length() != 0) {
      System.out.println(iter - 1);
      curChar = sb.charAt(iter - 1);
    }

    System.out.println("curChar = " + curChar + " " + iter);

    if (sb.length() == 0 || curChar != 'a') {
      sb.append('a');
      solve(sb, iter + 1, k, n);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (sb.length() == 0 || curChar != 'b') {
      sb.append('b');
      solve(sb, iter + 1, k, n);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (sb.length() == 0 || curChar != 'c') {
      sb.append('c');
      solve(sb, iter + 1, k, n);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  public String getHappyString(int n, int k) {
    StringBuilder sb = new StringBuilder();
    kthString = "";
    kth = 1;
    solve(sb, 0, k, n);
    System.out.println("kthString = " + kthString);
    return kthString;
  }

  public static void main(String[] args) {
    kthLexicographicalString kt = new kthLexicographicalString();
    int n = 1;
    int k = 4;
    kt.getHappyString(n, k);
  }
}
