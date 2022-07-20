
public class findMaxSubArraySum {

    public int maxArr(int[] arr, int k) {
        int N = arr.length;
        
        int sum = 0;
        for (int p = 0; p < k;p++) {
            sum += arr[p];
        }
        int maxValue = sum;
        int l = k;
        for (int i = 1; i < N - k; i++) {
            sum = sum - arr[i - 1] + arr[l];
            l++; 
            if(maxValue < sum) {
                maxValue = sum;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        findMaxSubArraySum max = new findMaxSubArraySum();
        int[] arr = {-3,4,-2,5,3,-2,8,2,-1,4};
        int k = 6;
        System.out.println(max.maxArr(arr, k));
    }
}
