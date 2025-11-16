import java.util.Arrays;
import java.util.HashMap;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 7, 5};
        int sum = 14;
        SubarrayWithGivenSum sw = new SubarrayWithGivenSum();
        System.out.println(Arrays.toString(sw.solve(A, sum)));
    }

    private int[] solve(int[] A, int B) {
        int N = A.length;
        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put(0L, -1);
        long prefixSum = 0;
        for(int i = 0; i < N; i++) {
            prefixSum += A[i];
            if(hm.containsKey(prefixSum - B)) {
                int stId = hm.get(prefixSum - B) + 1;
                int endId = i;
                return Arrays.copyOfRange(A, stId, endId+1);
            }

            hm.put(prefixSum, i);
        }
        return new int[]{-1};
    }
}
