public class PickFromBothSides {
    public static void main(String[] args) {
        int[] arr = {5, -2, 3, 1, 2};
        int B = 3;
        System.out.println(pickFromBothSides(arr, B));
    }

    public static int pickFromBothSides(int[] arr, int B) {
        int N = arr.length;
        int maxSum = 0;
        int sum = 0;

        for (int i = 0; i < B; i++) {
            sum += arr[i];
        }

        maxSum = sum;

        for (int i = 0; i < B; i++) {
            sum = sum - arr[B-1-i] + arr[N-1-i];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
