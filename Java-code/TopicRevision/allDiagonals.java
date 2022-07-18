public class allDiagonals {
    void diagonals(int[][] arr){
        int outerN = arr.length;

        for (int i = 0; i< outerN;i++) {
            int j = 0;
            int c = i;
            while (j <= i) {
                System.out.print(arr[j][c]+ " ");
                j++;
                c--;
            }
            System.out.println();
        }

        for (int p = 1; p < outerN; p++) {
            int n = outerN - 1;
            int m = p;
            while (m < outerN) {
                System.out.print(arr[m][n]+ " ");
                m++;
                n--;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        allDiagonals dia = new allDiagonals();
        int[][] arr = {{1,2,3,4,5},
                       {6,7,8,9,10},
                       {11,12,13,14,15},
                       {16,17,18,19,20},
                       {21,22,23,24,25}};
        dia.diagonals(arr);
    }
}
