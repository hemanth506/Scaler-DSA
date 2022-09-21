import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kthSmallestElt {
    public void swap(int[] arr, int minV, int ind, int i) {
        int temp = arr[i];
        arr[i] = minV;
        arr[ind] = temp;
    }
    public int kthsmallest(final List<Integer> A, int B) {
        int N = A.size();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = A.get(i);
        }
        System.out.println(Arrays.toString(arr));

        for(int i = 0; i < N; i++) {
            int minV = arr[i];
            int ind = i;
            for(int j = i + 1; j < N; j++) {
                if(arr[j] < minV) {
                    minV = arr[j];
                    ind = j;
                }
            }
            swap(arr, minV, ind, i);
            if(i == B - 1) {
                break;
            }
        }
        System.out.println(arr[B-1]);
        return arr[B-1];
    }
    public static void main(String[] args) {
        kthSmallestElt ks = new kthSmallestElt();
        List<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 1, 4, 3, 2));
        int B = 3;
        ks.kthsmallest(A, B);
    }
}
