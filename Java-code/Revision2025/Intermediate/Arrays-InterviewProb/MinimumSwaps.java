public class MinimumSwaps {
    public static void main(String[] args) {
        int[] A = {1, 12, 10, 3, 14, 10, 5};
        int B = 8;
        System.out.println(solve(A, B));
    }

    public static int solve(int[] A, int B) {
        int N = A.length;

        int windowSize = 0;
        for(int i = 0; i < N; i++) {
            if(A[i] <= B) {
                windowSize += 1;
            }
        }

        int maxCtLessThanB = Integer.MIN_VALUE;
        int ctLessThanB = 0;
        for(int i = 0; i < windowSize; i++) {
            if(A[i] <= B) {
                ctLessThanB += 1;
            }
        }
        maxCtLessThanB = Math.max(maxCtLessThanB, ctLessThanB);

        for(int i = 0; i <= N - windowSize - 1; i++) {
            if(A[i] <= B) {
                ctLessThanB -= 1;
            }

            if(A[i + windowSize] <= B) {
                ctLessThanB += 1;
            }

            maxCtLessThanB = Math.max(maxCtLessThanB, ctLessThanB);
        }



        System.out.println(windowSize - maxCtLessThanB);
        return 0;
    }
}
