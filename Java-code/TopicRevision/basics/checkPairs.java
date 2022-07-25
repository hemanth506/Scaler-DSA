// package basics;
// package TopicRevision;

public class checkPairs {

    boolean upperValidPair(int[] arr, int k) {
        System.out.println(arr[0]);
        int N = arr.length;
        boolean exist = false;
        for(int i = 0; i < N;i++) {
            // System.out.println("===========>" + i);
            for (int j = i+1; j < N; j++) {
                // System.out.println(i + " " + j);
                if (arr[i] + arr[j] == k){
                    exist = true;
                }
            }
        }
        return exist;
    }

    boolean lowerValidPair(int[] arr, int k) {
        System.out.println(arr[0]);
        int N = arr.length;
        boolean exist = false;
        for(int i = 0; i < N;i++) {
            // System.out.println("===========>" + i);
            for (int j = 0;j < i;j++) {
                // System.out.println(i + " " + j);
                if (arr[i] + arr[j] == k) {
                    exist = true;
                }
            }
        }
        return exist;
    }

    public static void main(String[] args) {
        checkPairs pairs = new checkPairs();
        int[] arr = {3,-2,1,4,3,6,8};
        int k = 10;
        System.out.println(pairs.upperValidPair(arr, k));
        // System.out.println(pairs.lowerValidPair(arr, k));
    }   
}
