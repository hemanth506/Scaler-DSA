import java.util.ArrayList;
import java.util.Arrays;

public class closestMinMax {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();

        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for(int mi = 0; mi < N; mi++) {
            if(minVal > A.get(mi)) {
                minVal = A.get(mi);
            }

            if (maxVal < A.get(mi)) {
                maxVal = A.get(mi);
            }
        }
        System.out.println(minVal + " " + maxVal);

        if (minVal == maxVal) {
            return 1;
        }

        int minI = -1;
        int maxI = -1;
        int len = 0;
        int minLen = N;
        for(int i = 0; i< N; i++) {
            if(A.get(i) == minVal) {
                minI = i;
                if(maxI != -1) {
                    len = Math.abs(maxI - minI) + 1;
                    if(minLen > len) {
                        minLen = len;
                    }
                }
            }
            else if (A.get(i) == maxVal) {
                maxI = i;
                if(minI != -1) {
                    len = Math.abs(maxI - minI) + 1;
                    if(minLen > len) {
                        minLen = len;
                    }
                }
            }
        }
        System.out.println(minLen);
        return minLen;
    }
    public static void main(String[] args) {
        closestMinMax cl = new closestMinMax();

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,6,4,6,5,1,5,2,6,4,4,2,1,5));
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,3,1,3,4,6,4,6,3));

        cl.solve(A);
    }
    public void test() {
    }
}
