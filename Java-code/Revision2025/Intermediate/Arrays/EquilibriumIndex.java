import java.util.Arrays;

public class EquilibriumIndex {
    public static void main(String[] args) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(equilibriumIndex(arr));
    }

    public static  int equilibriumIndex(int[] arr) {
        int N = arr.length;

        for (int i = 1; i < N; i++) {
            arr[i] = arr[i] + arr[i-1];
        }

        System.out.println(Arrays.toString(arr));

        for(int i = 0; i < N; i++) {
            int leftSum = i == 0 ? 0 : arr[i-1];
            int rightSum = i == N-1 ? 0: arr[N-1] - arr[i];

            if(leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }
}
