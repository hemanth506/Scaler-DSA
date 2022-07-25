

public class secondLargest {
    int secondLarElt (int[] arr) {
        int N = arr.length;
        int minIndex = 0;
        if (N == 1) {
            return -1;
        }
        for(int i = 0; i < N - 1; i++) {
            minIndex = i;
            for (int j = i+1; j < N; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[N - 1] + " ");
        System.out.println();
        // System.out.println(minIndex - 1);
        return arr[minIndex - 1];
    }
    public static void main(String[] args) {
        secondLargest sl = new secondLargest();
        int[] A = {2, 4, 6, 3, 1, 5};
        
        System.out.println(sl.secondLarElt(A));
    }
}
