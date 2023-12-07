import java.util.Arrays;

public class MaximalSum_Q221 {
  public int maximalSquare(char[][] matrix) {
    int N = matrix.length;
    int M = matrix[0].length;
    int dp[][] = new int[N][M];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (matrix[i][j] == '1') {
          dp[i][j] = 1;
        }
      }
    }

    int maxSquare = Integer.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        int left = 0;
        if (j - 1 >= 0) {
          left = dp[i][j - 1];
        }

        int right = 0;
        if (i - 1 >= 0) {
          right = dp[i - 1][j];
        }

        int diagonal = 0;
        if (i - 1 >= 0 && j - 1 >= 0) {
          diagonal = dp[i - 1][j - 1];
        }

        int minSide = Integer.min(left, Integer.min(right, diagonal));
        int val = minSide + dp[i][j];
        if (dp[i][j] != 0) {
          dp[i][j] = val;
        }
        maxSquare = Integer.max(maxSquare, val);
      }
    }

    System.out.println(Arrays.deepToString(dp));
    System.out.println(maxSquare);
    int finalRes = maxSquare * maxSquare;
    System.out.println(finalRes);

    return finalRes;
  }

  public static void main(String[] args) {
    MaximalSum_Q221 ms = new MaximalSum_Q221();
    // char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
    // { '1', '1', '1', '1', '1' },
    // { '1', '0', '0', '1', '0' } };

    // char[][] matrix = { { '0', '1' }, { '1', '0' } };

    // char[][] matrix = { { '0', '0' } };

    char[][] matrix = { { '1', '0', '1', '1', '0', '1' }, { '1', '1', '1', '1', '1', '1' },
        { '0', '1', '1', '0', '1', '1' }, { '1', '1', '1', '0', '1', '0' }, { '0', '1', '1', '1', '1', '1' },
        { '1', '1', '0', '1', '1', '1' } };

    ms.maximalSquare(matrix);
  }
}
