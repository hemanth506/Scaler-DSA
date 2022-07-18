public class sumOfAllSubArrays {
    int sumSubArrayNSquare(int[] arr) {
        int N = arr.length;
        int totVal = 0;
        for(int i = 0; i< N;i++) {
            int sumVal = 0;
            for(int j = i;j < N; j++) {
                sumVal += arr[j];
                totVal += sumVal;
            }
        }
        return totVal;
    }

    int sumSubArrayN(int[] arr) {
        int N = arr.length;
        int totVal = 0;
        int ct = 0;
        int total = 0;
        for(int i = 0;i < N; i++) {
            ct = (i + 1) * (N - i);
            total = ct * arr[i];
            totVal += total;
        }
        return totVal;
    }
    public static void main(String[] args) {
        sumOfAllSubArrays sub = new sumOfAllSubArrays();
        int[] arr = {7,3,2,-1,6,8,2,3};
        System.out.println("return O(N^2) => "+sub.sumSubArrayNSquare(arr));
        System.out.println("==================================");
        System.out.println("return O(N) => "+sub.sumSubArrayN(arr));
    }
}
