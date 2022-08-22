
public class printAllDiagonals {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4, 5, 6 },
                { 7, 8, 9, 10, 11, 12 },
                { 13, 14, 15, 16, 17, 18 },
                { 19, 20, 21, 22, 23, 24 },
                { 25, 26, 27, 28, 29, 30 }
        };

        // int[][] arr = { 
        //         { 1, 2, 3, 4 },
        //         { 5, 6, 7, 8 },
        //         { 9, 10, 11, 12 },
        //         { 13, 14, 15, 16 },
        //         { 17, 18, 19, 20 },
        //         { 21, 22, 23, 24 }
        //     };

        int Nrow = arr.length;
        int Ncol = arr[0].length;
        
        int normalCt = 0;
        if (Nrow > Ncol) {
            System.out.println("row max");
            normalCt = Ncol;
        } else {
            System.out.println("col max");
            normalCt = Nrow;
        }


        for (int i = 0; i < normalCt; i++) {
            int c = i;
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[c][j] + " ");
                c--;
            }
            System.out.println();
        }
        
        if (Nrow > Ncol) {
            for(int i = Ncol; i < Nrow; i++) {
                int c = i; 
                for(int j = 0; j < Ncol; j++) {
                    System.out.print(arr[c][j] + " ");
                    c--;
                }
                System.out.println();
            }

            int j = 1;
            while (j < Ncol) {
                int c = j;
                int i = Nrow - 1;
                while (c < Ncol) {
                    System.out.print(arr[i][c] + " ");
                    i--;
                    c++;
                }
                System.out.println();
                j++;
            }
            System.out.println("inner row max");
        } 
        else {
            for (int i = 1; i < Ncol; i++) {
                int c = i;
                for (int j = Nrow - 1; j >= (i - 1); j--) {
                    System.out.print(arr[j][c] + " ");
                    c++;
                }
                System.out.println();
            }
            System.out.println("inner col max");
        }
    }
}
