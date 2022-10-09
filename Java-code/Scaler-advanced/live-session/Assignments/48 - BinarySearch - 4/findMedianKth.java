import java.util.ArrayList;
import java.util.Arrays;

public class findMedianKth {

    // check the count function using binary search
    public int counterMatrixOLD(ArrayList<Integer> B, int M) {
        int N = B.size();
        int l = 0;
        int h = N - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            if (B.get(m) >= M) {
                h = m - 1;
            } else if (B.get(m) < M) {
                l = m + 1;
            }
        }
        System.out.println("counterMatrix => " + l);
        return l;
    }

    // this is working fine.
    public int counterMatrix(ArrayList<Integer> A, int M) {
        int N = A.size();
        int ct = 0;
        for (int i = 0; i < N; i++) {
            if (A.get(i) < M) {
                ct += 1;
            }
        }
        System.out.println("counterMatrixNEW => " + ct);
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
        int kThElt = -1;
        while (l <= h) {
            int m = (l + h) / 2;
            int values = 0;
            for (int i = 0; i < N; i++) {
                values += counterMatrix(A.get(i), m);
            }
            System.out.println("values=> " + values + " m=> " + m);
            if (values > K) {
                h = m - 1;
            } else {
                kThElt = m;
                l = m + 1;
            }
            System.out.println("-----------------------------");
        }
        System.out.println(kThElt);
        return kThElt;
    }

    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();
        // int K = Math.ceilDiv(N*M, 2);
        int K = (N * M) / 2;
        System.out.println("K " + K);
        int finalResult = kthEltInMatrix(A, K);
        System.out.println(finalResult);
        return finalResult;
    }

    public static void main(String[] args) {
        findMedianKth fk = new findMedianKth();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(new ArrayList<Integer>(Arrays.asList(1, 3, 5)));
        A.add(new ArrayList<Integer>(Arrays.asList(2, 6, 9)));
        A.add(new ArrayList<Integer>(Arrays.asList(3, 6, 9)));

        // A.add(new ArrayList<Integer>(Arrays.asList(5, 17, 100)));

        // A.add(new ArrayList<Integer>(Arrays.asList(2)));
        // A.add(new ArrayList<Integer>(Arrays.asList(1)));
        // A.add(new ArrayList<Integer>(Arrays.asList(4)));
        // A.add(new ArrayList<Integer>(Arrays.asList(1)));
        // A.add(new ArrayList<Integer>(Arrays.asList(2)));
        // A.add(new ArrayList<Integer>(Arrays.asList(2)));
        // A.add(new ArrayList<Integer>(Arrays.asList(5)));

        fk.findMedian(A);
    }
}
