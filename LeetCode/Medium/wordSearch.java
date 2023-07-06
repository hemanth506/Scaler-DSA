// Backtracking

public class wordSearch {
    char[][] board;
    String word;
    int N, M;
    boolean[][] touched;
    public boolean check(int i, int j, int charId) {
        System.out.println(charId + " " + word.length() + " " + i + " " + j);
        if(charId == word.length()) {
            return true;
        }
        if(i == this.N || j == this.M || j < 0 || i < 0 || this.board[i][j] != word.charAt(charId) || touched[i][j] == true) {
            return false;
        }

        touched[i][j] = true;
        boolean response = check(i+1, j, charId+1) || check(i, j+1, charId+1) || check(i-1, j, charId+1) || check(i, j-1, charId+1);
        touched[i][j] = false;
        return response;

    }
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.N = this.board.length;
        this.M = this.board[0].length;
        this.touched = new boolean[N][M];

        boolean res = false;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] == word.charAt(0)) {
                    res = check(i, j, 0);
                    System.out.println(res);
                    if(res) {
                        return res;
                    }
                }
            }
        }
        
        return res;
    }
    public static void main(String[] args) {
        wordSearch ws = new wordSearch();
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        // String word = "ABCCED";
        String word = "SEE";
        ws.exist(board, word);
    }
}