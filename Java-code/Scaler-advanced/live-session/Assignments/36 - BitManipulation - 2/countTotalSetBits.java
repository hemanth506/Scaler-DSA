import java.util.ArrayList;

public class countTotalSetBits {
    // TC: O(N^2) SC: O(1) - TLE
    public int solveN_2(int A) {
        int countBits = 0;
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j < 32; j++) {
                if ((i >> j & 1) == 1) {
                    countBits += 1;
                }
            }
        }
        System.out.println(countBits);
        return countBits;
    }

    // TC: O(N) SC: O(N) - Memory Error
    public int solveN(int A) {
        ArrayList<Integer> ctArr = new ArrayList<Integer>();
        int countBits = 0;
        int modVal = 1000000007;
        ctArr.add(0);
        for (int i = 1; i <= A; i++) {
            int val = i / 2;
            int bits = ctArr.get(val) + (i % 2);
            ctArr.add(bits);
            countBits += bits;

        }
        System.out.println(countBits);
        return countBits % modVal;
    }

    // TC: O(1) SC: O(1) - Working
    public int solve(int A) {
        long count = 0;
        long modV = 1000000007;
        // since we are including zero, so we are adding +1 in that.
        A += 1;
        
        for (int i = 0; i < 31; i++) {
            long cellSize = 2 << i;
            System.out.println((1 << i) + " " + (2 << i));
            long complete = A / cellSize;
            long remaining = A % cellSize;
            long halfCellSize = cellSize / 2;

            // will check only for valid 2<<i, since we are checking for all the 32 bits it will be avoided by the below condition
            if (remaining <= cellSize) {
                count += complete * halfCellSize;
                // System.out.print(cellSize + " " + complete + " " + remaining);
                if (remaining > halfCellSize) {
                    // System.out.println(" " + halfCellSize);
                    count += remaining - halfCellSize;
                }
            }
        }
        System.out.println(count);
        return (int) (count % modV) < 0 ? (int) ((count % modV) + modV) : (int) (count % modV);
    }

    public static void main(String[] args) {
        countTotalSetBits ct = new countTotalSetBits();
        int A = 11;
        ct.solve(A);
    }
}
