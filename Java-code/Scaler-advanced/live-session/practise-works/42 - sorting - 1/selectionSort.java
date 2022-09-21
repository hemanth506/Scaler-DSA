import java.util.Arrays;

public class selectionSort {
    public void swap(int[] arr, int curV, int idSwap, int i) {
        int temp = arr[i];
        arr[i] = curV;
        arr[idSwap] = temp;
        System.out.println("Arr => " + Arrays.toString(arr));
    }
    public int[] solveUnStable(int[] arr) {
        int N = arr.length;
        for(int i = 0; i < N; i++) {
            int curV = arr[i];
            int idSwap = i;
            for(int j = i + 1; j < N; j++) {
                if(arr[j] < curV) {
                    curV = arr[j];
                    idSwap = j;
                }
            }
            swap(arr, curV, idSwap, i);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    // check for the value which equals the current value when iterating to find the minimum value, if there exist an another value which equals the current value then sway these element first and continue to search for the minimum value and then swap minimum value and current value
    public int[] solveStable(int[] arr) {
        int N = arr.length;
        for(int i = 0; i < N; i++) {
            int curV = arr[i];
            int idSwap = i;
            for(int j = i + 1; j < N; j++) {
                if (arr[j] == curV) {
                    System.out.println(i + " " + j);
                    swap(arr, curV, j, i);
                } else if(arr[j] < curV) {
                    curV = arr[j];
                    idSwap = j;
                }
            }
            swap(arr, curV, idSwap, i);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void main(String[] args) {
        
        selectionSort ss = new selectionSort();
        // int[] arr = {2,8,4,-1,6,7,5,10,-1};
        int[] arr = {2,4,2,1};
        ss.solveUnStable(arr);

        int[] arr2 = {2,4,2,1};
        ss.solveStable(arr2);

    }
}
