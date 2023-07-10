public class battleshipsInBoard_Q419 {

    public void validate(int i, int j, char[][] board) {
        if(i >= N || i < 0 || j >= M || board[i][j] == '.') {
            return;
        }
        board[i][j] = '.';
        validate(i+1, j, board);
        validate(i-1, j, board);
        validate(i, j+1, board);
    }

    int N;
    int M;
    public int countBattleships(char[][] board) {
        N = board.length;
        M = board[0].length;

        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] == 'X') {
                    validate(i, j, board);
                    count++;
                }
            }
        }
        System.out.println(count);
        return count;
    }
    public static void main(String[] args) {
        battleshipsInBoard_Q419 bs = new battleshipsInBoard_Q419();
        // char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        char[][] board = {{'X'}};

        bs.countBattleships(board);
    }
}
