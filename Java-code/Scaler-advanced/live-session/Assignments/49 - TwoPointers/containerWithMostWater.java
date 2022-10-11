import java.util.ArrayList;
import java.util.Arrays;

public class containerWithMostWater {
    public int maxArea(ArrayList<Integer> A) {
        int N = A.size();
        if(N == 1) {
            return 0;
        }
        int p1 = 0;
        int p2 = N - 1;
        int maxWaterAmt = Integer.MIN_VALUE;

        while (p1 < p2) {
            int canContain = Integer.min(A.get(p1), A.get(p2));
            int waterInContainer = canContain * (p2 - p1);
            maxWaterAmt = Integer.max(maxWaterAmt, waterInContainer);
            if(A.get(p1) >= A.get(p2)) {
                p2--;
            } else {
                p1++;
            }
        }
        System.out.println(maxWaterAmt);
        return maxWaterAmt;
    }
    public static void main(String[] args) {
        containerWithMostWater cm = new containerWithMostWater();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 5, 4, 3));
        cm.maxArea(A);
    }
}
