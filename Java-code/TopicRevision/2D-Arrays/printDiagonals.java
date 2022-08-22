
public class printDiagonals {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4,5},
                       {6,7,8,9,10},
                       {11,12,13,14,15},
                       {16,17,18,19,20},
                       {21,22,23,24,25}};

        int N = arr.length;

        for(int i = 0; i < N; i++) {
            System.out.println(i + " " + i + " " + arr[i][i] + " ");
        }

        System.out.println();
        for(int i = 0; i < N; i++) {
            System.out.println((N-i-1) + " " + i + " " +arr[N-i-1][i] + " ");
        }
    }
}
