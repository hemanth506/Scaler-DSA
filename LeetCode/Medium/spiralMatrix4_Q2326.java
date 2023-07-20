import java.util.Arrays;

import Medium.ListNode;

public class spiralMatrix4_Q2326 {

    public int[][] spiralMatrix(int N, int M, ListNode head) {
        if(head == null) {
            return new int[][]{{-1}};
        }
        if(N == 1 & M == 1) {
            return new int[][]{{head.val}};
        }
        int[][] matrix = new int[N][M];
        for(int i = 0; i < N; i++) {
            Arrays.fill(matrix[i], -1);
        }
        ListNode root = head;
        int totalGrid = (N * M) - 1;
        int ctGrid = 0;
        int x = 0;
        int y = 0;
        int tempN = N;
        int tempM = M;

        while (ctGrid <= totalGrid && root != null && N > 0 && M > 0) {
            for (int j = 0; j <= M - 2; j++) {
                if(root == null) {
                    break;
                }
                matrix[x][y] = root.val;
                root = root.next;
                y++;
                ctGrid++;
            }

            for (int i = 0; i <= N - 2; i++) {
                if(root == null) {
                    break;
                }
                matrix[x][y] = root.val;
                root = root.next;
                x++;
                ctGrid++;
            }

            for (int j = 0; j <= M - 2; j++) {
                if(root == null) {
                    break;
                }
                matrix[x][y] = root.val;
                root = root.next;
                y--;
                ctGrid++;
            }

            for (int i = 0; i <= N - 2; i++) {
                if(root == null) {
                    break;
                }
                matrix[x][y] = root.val;
                root = root.next;
                x--;
                ctGrid++;
            }
            N -= 2;
            M -= 2;
            x+=1;
            y+=1;
        }

        // For center value, we have explicitly handled it.
        if (N < 0 && M < 0) {
            matrix[tempN/2][tempM/2] = root.val;
        }

        return matrix;
    }
}
