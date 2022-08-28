import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class rainWaterTrapped {
    public int trap(final List<Integer> A) {
        int N = A.size();

        int[] prefixMax = new int[N];
        prefixMax[0] = A.get(0);
        for(int i = 1; i < N; i++) {
            prefixMax[i] = Integer.max(prefixMax[i - 1],  A.get(i));
        }
        System.out.println(Arrays.toString(prefixMax));


        int[] suffixMax = new int[N];
        suffixMax[N-1] = A.get(N-1);
        for(int i = N-2; i >= 0; i--) {
            suffixMax[i] = Integer.max(suffixMax[i + 1], A.get(i));
        }
        System.out.println(Arrays.toString(suffixMax));

        // int maxL = 0;
        // int maxR = 0;
        int waterTrapped = 0;
        for(int i = 1; i < N - 1; i++) {
            int maxL = prefixMax[i - 1];
            int maxR = suffixMax[i + 1];
            int waterLvl = Integer.min(maxL, maxR);
            waterTrapped += Integer.max(0, waterLvl - A.get(i));
        }
        System.out.println(waterTrapped);

        return waterTrapped;
    }
    public static void main(String[] args) {
        rainWaterTrapped rt = new rainWaterTrapped();
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(0,1,0,2,1,0,3,2,1));

        List<Integer> A = new ArrayList<Integer>(Arrays.asList(56, 6, 52, 43, 23, 47, 48, 38, 96, 46, 30, 66, 80, 15, 62, 71, 61, 12, 98, 9, 28, 81, 70, 59, 95, 34, 9, 60, 70, 81, 71, 67, 58, 20, 22, 3, 95, 85, 20, 24, 74, 5, 23, 33, 75, 50, 38, 75, 68, 26, 46, 30, 75, 18, 4, 42, 51, 59, 8, 77));

        rt.trap(A);
    }
}
