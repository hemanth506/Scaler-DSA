import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class nQueens {
    ArrayList<ArrayList<String>> allPoss = new ArrayList<>();
    // previously used hashmap, but it was making that too complicated instead we can use hashset to check if the index exist or not.
    HashSet<Integer> diagonalTtoB;
    HashSet<Integer> diagonalBtoT;
    HashSet<Integer> column;

    public ArrayList<String> convertToString(String[][] board, int N) {
        ArrayList<String> strArr = new ArrayList<String>();
        System.out.println("====start====");
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < N; j++) {
                sb.append(board[i][j]);
            }
            System.out.println(sb.toString());
            strArr.add(sb.toString());
        }
        System.out.println("====end====");
        return strArr;
    }

    public void queenArrangements(String[][] board, int row, int A) {
        if (row == A) {
            System.out.println("last");
            ArrayList<String> arr = convertToString(board, A);
            allPoss.add(arr);
            return;
        }

        for (int i = 0; i < A; i++) {
            System.out.println(row + " ++++++++++++ " + i);
            
            // whenever the column starts with 0, the set should be empty.
            if(row == 0) {
                diagonalTtoB = new HashSet<>();
                diagonalBtoT = new HashSet<>();
                column = new HashSet<>();
            }

            int TtoB = row-i ; int BtoT = row + i; int col = i;
            if(diagonalTtoB.contains(TtoB) || diagonalBtoT.contains(BtoT) || column.contains(col)) {
                // If the id exists, it will continue and go to the next column (for loop)
                continue;
            }

            // add column/diagonals
            diagonalTtoB.add(TtoB);
            diagonalBtoT.add(BtoT);
            column.add(col);

            board[row][i] = "Q";
            System.out.println("rows == " + (row+1));
            queenArrangements(board, row + 1, A);
            board[row][i] = ".";

            System.out.println("(((((((((((returned))))))))))))");
            
            // remove column/diagonals
            diagonalTtoB.remove(TtoB);
            diagonalBtoT.remove(BtoT);
            column.remove(col);
        }

    }

    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        String[][] board = new String[A][A];

        for (String[] row: board) {
            Arrays.fill(row, ".");
        }
        queenArrangements(board, 0, A);
        System.out.println(allPoss);
        return allPoss;
    }

    public static void main(String[] args) {
        nQueens nq = new nQueens();
        int A = 4;
        nq.solveNQueens(A);
    }
}
