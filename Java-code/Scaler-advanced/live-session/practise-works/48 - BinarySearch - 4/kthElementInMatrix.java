import java.util.ArrayList;
import java.util.Arrays;

public class kthElementInMatrix {
    public int counterMatrix(ArrayList<Integer> B, int M) {
        int N = B.size();
        int l = 0;
        int h = N - 1;
        int index = 0;
        while (l <= h) {
            int m = (l + h) / 2;
            if (B.get(m) >= M) {
                System.out.println(" h checked");
                h = m - 1;
                index = m;
            } else if (B.get(m) < M) {
                System.out.println(" l checked");
                l = m + 1;
            }
        }
        System.out.println("counterMatrix => " + index);
        return index;
    }

    public int counterMatrixNew(ArrayList<Integer> A, int M) {
        int N = A.size();
        int ct = 0;
        for (int i = 0; i < N; i++) {
            if (A.get(i) < M) {
                ct += 1;
            }
        }
        System.out.println("counterMatrixNew => " + ct);
        return ct;
    }

    public int kthEltInMatrix(ArrayList<ArrayList<Integer>> A, int K) {
        int N = A.size();
        int M = A.get(0).size();

        int maxV = Integer.MIN_VALUE;
        int minV = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            minV = Integer.min(minV, A.get(i).get(0));
            maxV = Integer.max(maxV, A.get(i).get(M - 1));
        }
        System.out.println(minV + " " + maxV);

        int l = minV;
        int h = maxV;
        int kThElt = 0;
        while (l <= h) {
            int m = (l + h) / 2;
            int values = 0;
            for (int i = 0; i < N; i++) {
                values += counterMatrix(A.get(i), m);
            }
            System.out.println(values + " " + m);
            if (values <= K) {
                kThElt = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        System.out.println(kThElt);
        return kThElt;
    }

    public static void main(String[] args) {
        kthElementInMatrix kth = new kthElementInMatrix();

        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(3, 3, 6, 7, 7, 11, 14, 17, 17));
        int M = 5;
        kth.counterMatrix(B, M);
        kth.counterMatrixNew(B, M);

        // ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        // A.add(new ArrayList<Integer>(Arrays.asList(3,3,6,7,7,11,14,17)));
        // A.add(new ArrayList<Integer>(Arrays.asList(2,2,10,10,13,20,20,22)));
        // int K = 8;
        // kth.kthEltInMatrix(A, K);

    }
}
