import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class validSudoku {

    public int isValidSudoku(final List<String> A) {
        // store the string in array of 9X9 matrix.
        String[][] sudoku = new String[9][9];
        for (int i = 0; i < 9; i++) {
            String[] AInner = A.get(i).split("");
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = AInner[j];
            }
            System.out.println(Arrays.deepToString(sudoku[i]));
        }

        // System.out.println("=============col - row================");
        for (int col = 0; col < 9; col++) {
            HashSet<String> hs = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                if (!sudoku[col][row].equals(".")) {
                    if (hs.contains(sudoku[col][row])) {
                        System.out.println("exists");
                        return 0;
                    } else {
                        hs.add(sudoku[col][row]);
                    }
                }
            }
            // System.out.println("Total => " + hs);
        }


        // System.out.println("===========row - col==================");
        for (int row = 0; row < 9; row++) {
            HashSet<String> hs = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                if (!sudoku[col][row].equals(".")) {
                    if (hs.contains(sudoku[col][row])) {
                        System.out.println("exists");
                        return 0;
                    } else {
                        hs.add(sudoku[col][row]);
                    }
                }
            }
            // System.out.println("Total => " + hs);
        }

        // System.out.println("============Inner grid validation=================");
        int cInterateStart = -3;
        int cIterateTill = 0;
        for (int i = 0; i < 3; i++) {
            System.out.println("+++++++++++" + i + "+++++++++++++");
            cInterateStart += 3;
            cIterateTill += 3;

            HashSet<String> hsCube = new HashSet<>();
            int rCt = 0;
            int rIterateTill = 3;
            while (rCt < rIterateTill) {
                int cCt = cInterateStart;
                while (cCt < cIterateTill) {
                    System.out.println(rCt + " " + cCt + " values => " + sudoku[rCt][cCt] + " ");
                    if (!sudoku[rCt][cCt].equals(".")) {
                        if (hsCube.contains(sudoku[rCt][cCt])) {
                            System.out.println("Exists 1");
                            return 0;
                        } else {
                            hsCube.add(sudoku[rCt][cCt]);
                        }
                    }
                    cCt++;
                }
                rCt++;
                System.out.println();
            }
            System.out.println(hsCube);
            System.out.println("------------------------");
    
    
            HashSet<String> hsCube1 = new HashSet<>();
            rCt = rIterateTill;
            rIterateTill = rIterateTill + 3;
            while (rCt < rIterateTill) {
                int cCt = cInterateStart;
                while (cCt < cIterateTill) {
                    System.out.println(rCt + " " + cCt + " values => " + sudoku[rCt][cCt] + " ");
                    if (!sudoku[rCt][cCt].equals(".")) {
                        if (hsCube1.contains(sudoku[rCt][cCt])) {
                            System.out.println("Exists 1");
                            return 0;
                        } else {
                            hsCube1.add(sudoku[rCt][cCt]);
                        }
                    }
                    cCt++;
                }
                rCt++;
                System.out.println();
            }
            System.out.println(hsCube1);
            System.out.println("------------------------");
    
    
            HashSet<String> hsCube2 = new HashSet<>();
            rCt = rIterateTill;
            rIterateTill = rIterateTill + 3;
            while (rCt < rIterateTill) {
                int cCt = cInterateStart;
                while (cCt < cIterateTill) {
                    System.out.println(rCt + " " + cCt + " values => " + sudoku[rCt][cCt] + " ");
                    if (!sudoku[rCt][cCt].equals(".")) {
                        if (hsCube2.contains(sudoku[rCt][cCt])) {
                            System.out.println("Exists 1");
                            return 0;
                        } else {
                            hsCube2.add(sudoku[rCt][cCt]);
                        }
                    }
                    cCt++;
                }
                rCt++;
                System.out.println();
            }
            System.out.println(hsCube2);
        }


        System.out.println("valid sudoku");
        return 1;
    }

    
    public static void main(String[] args) {
        validSudoku vs = new validSudoku();
        // List<String> A = new ArrayList<String>(Arrays.asList("....5..1.", ".4.3.....", ".....3..1", "8......2.", "..2.7....", ".15......", ".....2...", ".2.9.....", "..4......"));
        List<String> A = new ArrayList<String>(Arrays.asList("53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79")) ;
        vs.isValidSudoku(A);
    }
}
