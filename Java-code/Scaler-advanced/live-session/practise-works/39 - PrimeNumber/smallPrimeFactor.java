import java.util.Arrays;

public class smallPrimeFactor {
    public int[] solve(int A) {
        int[] arr = new int[A+1];
        for(int i = 1; i <= A; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));

        for(int i = 2; i*i <= A; i++) {
            if(arr[i] == i) {
                for(int j = i*i; j <= A; j+=i) {    
                    arr[j] = Integer.min(arr[j], i);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    public static void main(String[] args) {
        smallPrimeFactor spf = new smallPrimeFactor();
        spf.solve(40);
    }
}
