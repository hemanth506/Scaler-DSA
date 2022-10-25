import java.util.HashSet;

public class validSudoku {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        // row-wise
        for(int i = 0; i < N; i++) {
            HashSet<Character> hs = new HashSet<>();
            for(int j = 0; j < N; j++) {
                if(board[i][j] != '.') {
                    if(!hs.contains(board[i][j])) {
                        hs.add(board[i][j]);
                    } else {
                        return false;
                    }
                }
            }
        }

        // column-wise
        for(int i = 0; i < N; i++) {
            HashSet<Character> hs = new HashSet<>();
            for(int j = 0; j < N; j++) {
                if(board[j][i] != '.') {
                    if(!hs.contains(board[j][i])) {
                        hs.add(board[j][i]);
                    } else {
                        return false;
                    }
                }
            }
        }


        int start = -3;
        int end = 0;
        for(int k = 0; k < 3; k++) {
            start += 3;
            end += 3;
            HashSet<Character> hsCubeSet1 = new HashSet<>();
            for(int i = 0; i < 9; i++) {
                if(i%3 == 0) {
                    hsCubeSet1 = new HashSet<>();
                }
                for(int j = start; j < end; j++) {
                    if(board[i][j] != '.') {
                        if(!hsCubeSet1.contains(board[i][j])) {
                            hsCubeSet1.add(board[i][j]);
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        System.out.println("true");
        return true;
    }
    public static void main(String[] args) {
        validSudoku vs = new validSudoku();
        // char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        char[][] board = {{'8','3','.','.','7','.','.','.','.'}
        ,{'6','.','.','1','9','5','.','.','.'}
        ,{'.','9','8','.','.','.','.','6','.'}
        ,{'8','.','.','.','6','.','.','.','3'}
        ,{'4','.','.','8','.','3','.','.','1'}
        ,{'7','.','.','.','2','.','.','.','6'}
        ,{'.','6','.','.','.','.','2','8','.'}
        ,{'.','.','.','4','1','9','.','.','5'}
        ,{'.','.','.','.','8','.','.','7','9'}};
        vs.isValidSudoku(board);
    }
}
