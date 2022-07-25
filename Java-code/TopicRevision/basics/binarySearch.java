

public class binarySearch {

    int search(int[] arr, int eltToFind) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) / 2);
            if (arr[mid] < eltToFind) {
                low = mid + 1;
            } else if (arr[mid] > eltToFind) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return 0;
    }

    int[] selectionSort(int[] arr) {
        int N = arr.length;
        for (int i = 0; i < N - 1; i++) {
            int minIndex = i;
            for (int j = (i + 1); j < N; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // System.out.println(minIndex);
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            // System.out.print(arr[i] + " ");
        }
        // System.out.println(arr.toString());
        return arr;
    }

    public static void main(String[] args) {
        int[] A = {2, 4,6 ,3, 1, 5};
        int B = 3;
        
        binarySearch bs = new binarySearch();
        bs.selectionSort(A);
        int index = bs.search(A, B);
        System.out.println(index);
    }
}
