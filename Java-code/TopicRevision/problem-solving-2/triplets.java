
public class triplets {
    int count(int[] arr) {
        int N = arr.length;
        int ans = 0;
        for (int j = 0; j < N; j++) {
            int left = 0;
            int right = 0;

            for (int i = 0; i < j; i++) {
                if (arr[i] < arr[j]) {
                    left += 1;
                }
            }

            for (int k = j + 1; k < N; k++) {
                if (arr[j] < arr[k]) {
                    right += 1;
                }
            }
            ans = ans + (left * right);

        }
        return ans;
    }
    public static void main(String[] args) {
        triplets ct = new triplets();
        int[] arr = {4,1,2,6,9,7,3}; 
        // int[] arr = {4,1,2,6,9,7}; 

        System.out.println(ct.count(arr));
    }
}
