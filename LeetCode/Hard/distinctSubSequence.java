import java.util.Arrays;

public class distinctSubSequence {
  int dp[][];
  int N;
  int M;

  private int solve(String S, String T, int i, int j) {

    if (j >= M) {
      return 1;
    }

    if (i >= N) {
      return 0;
    }

    if (dp[i][j] == -1) {
      int count = 0;
      if (S.charAt(i) == T.charAt(j)) {
        count += solve(S, T, i + 1, j + 1);
      }

      count += solve(S, T, i + 1, j);
      dp[i][j] = count;
    }
    return dp[i][j];
  }

  public int numDistinct(String s, String t) {
    N = s.length();
    M = t.length();
    dp = new int[N][M];

    for (int i = 0; i < N; i++) {
      Arrays.fill(dp[i], -1);
    }
    int numSeq = solve(s, t, 0, 0);
    System.out.println(numSeq);
    return numSeq;
  }

  public static void main(String[] args) {
    distinctSubSequence ds = new distinctSubSequence();
    // String s = "babgbag";
    // String t = "bag";

    String s = "rabbbit";
    String t = "rabbit";
    ds.numDistinct(s, t);
  }
}
