import java.util.Arrays;

public class allFactors {
    public int[] solve(int A) {
        int arr[] = new int[A+1];
        Arrays.fill(arr, 1);
        for(int i = 2; i <= A; i++) {
            for(int j = i; j <= A; j+=i) {
                arr[j]++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    public static void main(String[] args) {
        allFactors af = new allFactors();
        int A = 20;
        af.solve(A);
    }
}
