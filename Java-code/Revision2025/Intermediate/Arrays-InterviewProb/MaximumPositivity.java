import java.util.Arrays;

public class MaximumPositivity {
    public static void main(String[] args) {
        int[] A = {5, 6, 1, 7, 8, 9};
        solve(A);
    }

    public static int[] solve(int[] A) {
        int N = A.length;

        int maxPositivity = Integer.MIN_VALUE;
        int stId = -1;
        int endId = -1;
        boolean isFirst = true;
        for(int i = 0; i < N; i++) {
            if(A[i] < 0) {
                if(isFirst) {
                    int j = i - 1;
                    for(; j >= 0; j--) {
                        if(A[j] < 0) break;
                    }
                    isFirst = false;
                    stId = j + 1;
                    endId = i - 1;
                    int len = endId - stId + 1;
                    maxPositivity = len;
                }

                int k = i + 1;
                for(; k < N; k++) {
                    if(A[k] < 0) break;
                }

                int len = k - 1 - i + 1 - 1;
                if(maxPositivity < len) {
                    maxPositivity = len;
                    stId = i + 1;
                    endId = k - 1;
                }
            }
        }

        if(stId == -1 && endId == -1) {
            System.out.println(Arrays.toString(A));
            return A;
        }

        int[] B = new int[maxPositivity];
        int q = 0;
        for(int p = stId; p <= endId; p++, q++) {
            B[q] = A[p];
        }
        System.out.println(Arrays.toString(B));
        return B;
    }
}
