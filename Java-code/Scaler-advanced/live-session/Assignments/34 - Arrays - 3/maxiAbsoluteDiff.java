import java.util.ArrayList;
import java.util.Arrays;

public class maxiAbsoluteDiff {
    public int maxArrBruteForce(ArrayList<Integer> A) {
        int N = A.size();
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int absVal = Math.abs(A.get(i) - A.get(j)) + Math.abs(i - j);
                maxVal = Integer.max(absVal, maxVal);
            }
        }
        System.out.println(maxVal);
        return maxVal;
    }
    
    public int maxArr(ArrayList<Integer> A) {
        int N = A.size();

        int Xmax = Integer.MIN_VALUE;
        int Xmin = Integer.MAX_VALUE;
        int Ymax = Integer.MIN_VALUE;
        int Ymin = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            int x = A.get(i) - i;
            int y = A.get(i) + i;

            Xmax = Integer.max(x, Xmax);
            Xmin = Integer.min(x, Xmin);

            Ymax = Integer.max(y, Ymax);
            Ymin = Integer.min(y, Ymin);
        }

        int maxiAbs = Integer.max(Xmax-Xmin, Ymax-Ymin);
        System.out.println(maxiAbs);

        return maxiAbs;
    }
    public static void main(String[] args) {
        maxiAbsoluteDiff ma = new maxiAbsoluteDiff();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 3, -1));
        ma.maxArr(A);
    }
}
