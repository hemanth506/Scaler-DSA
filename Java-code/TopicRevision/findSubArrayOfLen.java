// sliding window technique

public class findSubArrayOfLen {
    int maxSubArray(int[] arr, int k) {
        int N = arr.length;
        
        int sumVal = 0;
        for(int i = 0; i < k; i++) {
            sumVal += arr[i];
        }

        int ans = sumVal;
        int s = 1;
        for (int e = k; e < N; e++) {
            sumVal = sumVal - arr[s - 1] + arr[e];
            if (ans < sumVal) {
                ans = sumVal;
            }
            s++;
        }
        return ans;
    }
    public static void main(String[] args) {
        findSubArrayOfLen subSum = new findSubArrayOfLen();
        int arr[] = {-3,4,-2,8,2,1,4};
        int k = 6;
        System.out.println(subSum.maxSubArray(arr, k));
    }
}
