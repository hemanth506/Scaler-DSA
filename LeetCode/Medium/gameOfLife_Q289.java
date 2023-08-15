import java.util.Arrays;

public class gameOfLife_Q289 {
    public int getNeighbours(int i, int j, int N, int M, int[][] board) {
        int neighbour = 0;
        if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 1) {
            neighbour += 1;
        }

        if (j - 1 >= 0 && board[i][j - 1] == 1) {
            neighbour += 1;
        }

        if (i + 1 < N && j - 1 >= 0 && board[i + 1][j - 1] == 1) {
            neighbour += 1;
        }

        if (i - 1 >= 0 && board[i - 1][j] == 1) {
            neighbour += 1;
        }

        if (i + 1 < N && board[i + 1][j] == 1) {
            neighbour += 1;
        }

        if (i - 1 >= 0 && j + 1 < M && board[i - 1][j + 1] == 1) {
            neighbour += 1;
        }

        if (j + 1 < M && board[i][j + 1] == 1) {
            neighbour += 1;
        }

        if (i + 1 < N && j + 1 < M && board[i + 1][j + 1] == 1) {
            neighbour += 1;
        }
        return neighbour;
    }

    public void gameOfLife(int[][] board) {
        int N = board.length;
        int M = board[0].length;
        int[][] tempBoard = new int[N][M];
        System.out.println(Arrays.deepToString(board));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int neighbour = getNeighbours(i, j, N, M, board);
                System.out.println(i + "-" + j + " " + neighbour);
                if (board[i][j] == 0) {
                    if (neighbour == 3) {
                        tempBoard[i][j] = 1;
                    } else {
                        tempBoard[i][j] = 0;
                    }
                } else {
                    if (neighbour < 2 || neighbour > 3) {
                        tempBoard[i][j] = 0;
                    } else {
                        tempBoard[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                board[i][j] = tempBoard[i][j];
            }
        }
    }

    public static void main(String[] args) {
        gameOfLife_Q289 gl = new gameOfLife_Q289();
        // int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
        int[][] board = { { 1, 1 }, { 1, 0 } };
        gl.gameOfLife(board);
    }
}
