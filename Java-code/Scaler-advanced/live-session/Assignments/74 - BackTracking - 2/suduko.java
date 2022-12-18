// IMPORTANT - Don't use global variables when using recursion

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class suduko {
    public boolean fillSuduko(ArrayList<ArrayList<Character>> a, int i) {
        if (i == 81) {
            System.out.println("complete = " + i);
            // System.out.println(a);
            return true;
        }
        int r = i / 9;
        int c = i % 9;
        if (a.get(r).get(c) != '.') {
            if(fillSuduko(a, i+1)) {
                return true;
            }
        } else {
            for (int p = 1; p <= 9; p++) {
                if (isValid(p, r, c)) {
                    char pChar = Integer.toString(p).charAt(0);
                    // System.out.println(r + " " + c + "====== placed = " + pChar + "======" + i);

                    a.get(r).set(c, pChar);
                    rowHs.get(r).add(pChar);
                    colHs.get(c).add(pChar);

                    int index = getIndex(r, c);
                    cubeHs.get(index).add(pChar);
                    // System.out.println("index = " + index);

                    // we have to stop to remove changes when we found a solution
                    if(fillSuduko(a, i+1)) {
                        return true;
                    }

                    a.get(r).set(c, '.');
                    rowHs.get(r).remove(pChar);
                    colHs.get(c).remove(pChar);
                    cubeHs.get(index).remove(pChar);

                    // System.out.println(r + " " + c + "====== removed = " + pChar + "======" + i);
                }
            }
        }
        // System.out.println("testing = " + i);
        return false;
    }

    public int getIndex(int row, int col) {
        int index = 0;
        if(row < 3) {
            if (col < 3) {
                index = 0;
            } else if (col < 6) {
                index = 1;
            } else if (col < 9) {
                index = 2;
            }
        } else if (row < 6) {
            if (col < 3) {
                index = 3;
            } else if (col < 6) {
                index = 4;
            } else if (col < 9) {
                index = 5;
            }
        } else if (row < 9) {
            if (col < 3) {
                index = 6;
            } else if (col < 6) {
                index = 7;
            } else if (col < 9) {
                index = 8;
            }
        }
        return index;
    }
    
    public boolean isValid(int p, int row, int col) {
        boolean status = true;
        char pChar = Integer.toString(p).charAt(0);
        // row and col check
        if (rowHs.get(row).contains(pChar) || colHs.get(col).contains(pChar)) {
            status = false;
        }

        // cube check
        int index = getIndex(row, col);
        if(cubeHs.get(index).contains(pChar)){
            status = false;
        }

        return status;
    }

    ArrayList<HashSet<Character>> rowHs;
    ArrayList<HashSet<Character>> colHs;
    ArrayList<HashSet<Character>> cubeHs;
    public void createHashSetArray(ArrayList<ArrayList<Character>> a, int N) {
        rowHs = new ArrayList<HashSet<Character>>();
        for (int i = 0; i < N; i++) {
            HashSet<Character> hs = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (a.get(i).get(j) != '.') {
                    hs.add(a.get(i).get(j));
                }
            }
            rowHs.add(hs);
        }

        colHs = new ArrayList<HashSet<Character>>();
        for (int i = 0; i < N; i++) {
            HashSet<Character> hs = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (a.get(j).get(i) != '.') {
                    hs.add(a.get(j).get(i));
                }
            }
            colHs.add(hs);
        }

        cubeHs = new ArrayList<HashSet<Character>>();
        int jStart = 0;
        int jEnd = 3;
        int iStart = 0;
        int iEnd = 3;
        for (int k = 0; k < 9; k++) {
            HashSet<Character> hs = new HashSet<>();
            // System.out.println("iStart = " + iStart + " iEnd = " + iEnd + " jStart = " + jStart + " jEnd = " + jEnd);
            for (int i = iStart; i < iEnd; i++) {
                for (int j = jStart; j < jEnd; j++) {
                    if (a.get(i).get(j) != '.') {
                        hs.add(a.get(i).get(j));
                    }
                }
            }
            cubeHs.add(hs);
            jStart += 3;
            jEnd += 3;
            if (jEnd > 9) {
                iStart += 3;
                iEnd += 3;
                jStart = 0;
                jEnd = 3;
            }

        }

    }

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        System.out.println(a);
        int N = a.size();

        createHashSetArray(a, N);
        System.out.println(rowHs);
        System.out.println(colHs);
        System.out.println(cubeHs);

        fillSuduko(a, 0);
        System.out.println("result = " + a);
    }

    public static void main(String[] args) {
        suduko sd = new suduko();
        ArrayList<ArrayList<Character>> a = new ArrayList<>();
        a.add(new ArrayList<Character>(Arrays.asList('5', '3', '.', '.', '7', '.', '.', '.', '.')));
        a.add(new ArrayList<Character>(Arrays.asList('6', '.', '.', '1', '9', '5', '.', '.', '.')));
        a.add(new ArrayList<Character>(Arrays.asList('.', '9', '8', '.', '.', '.', '.', '6', '.')));
        a.add(new ArrayList<Character>(Arrays.asList('8', '.', '.', '.', '6', '.', '.', '.', '3')));
        a.add(new ArrayList<Character>(Arrays.asList('4', '.', '.', '8', '.', '3', '.', '.', '1')));
        a.add(new ArrayList<Character>(Arrays.asList('7', '.', '.', '.', '2', '.', '.', '.', '6')));
        a.add(new ArrayList<Character>(Arrays.asList('.', '6', '.', '.', '.', '.', '2', '8', '.')));
        a.add(new ArrayList<Character>(Arrays.asList('.', '.', '.', '4', '1', '9', '.', '.', '5')));
        a.add(new ArrayList<Character>(Arrays.asList('.', '.', '.', '.', '8', '.', '.', '7', '9')));
        sd.solveSudoku(a);
    }
}

