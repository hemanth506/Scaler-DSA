
public class closestMinMax {

    public void test() {
        // int[] arr = {1,2,3,1,3,4,6,4,6,3};
        // int[] arr = {2,2,6,4,5,1,5,2,6,4,1};
        int[] arr = {8,8,8,8,8,8,8,8};


        int N = arr.length;
        
        int min = arr[0];
        for (int i = 1; i < N;i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        int max = arr[0];
        for (int j = 1; j < N; j++) {
            if (arr[j] > max) {
                max = arr[j];
            }
        }


        int minI = -1;
        int maxI = -1;
        int len = 0;
        int minLength = Integer.MAX_VALUE;
        if (min == max) {
            System.out.println(1);
        } else {
            
            for (int k = 0; k < N; k++) {
                if(arr[k] == min) {
                    minI = k;
                    if(maxI != -1) {
                        len = Math.abs(maxI - minI) + 1;
                        System.out.println(arr[k] + " " + k + " " + minI + " " + len);
                        if (len < minLength) {
                            minLength = len;
                        }
                    }
                } else if(arr[k] == max) {
                    maxI = k;
                    if(minI != -1) {
                        len = Math.abs(maxI - minI) + 1;
                        System.out.println(arr[k] + " " + k + " " + maxI + " " + len);
                        if (len < minLength) {
                            minLength = len;
                        }
                    }
                }
            }
            System.out.println(minLength);
        }
        System.out.println("=========================");
    }
    public static void main(String[] args) {
        closestMinMax close = new closestMinMax();
        close.test();
    }
}
