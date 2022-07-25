import java.util.ArrayList;
import java.util.Arrays;

public class rotateArray {
    ArrayList<Integer> reverse (ArrayList<Integer> arr, int f, int e) {
        int temp = 0;
        while (f < e) {
            temp = arr.get(f);
            arr.set(f, arr.get(e));
            arr.set(e, temp);
            f++;
            e--;
        }
        return arr;
    }

    ArrayList<Integer> rotateRTL (ArrayList<Integer> arr, int times) {
        int arrSize = arr.size();
        int f,e,k;
        f = 0;
        e = arrSize - 1;
        System.out.println("initial => " + arr);
        reverse(arr, f,e);
        // System.out.println(arr);

        k = times % arrSize;
        f = 0;
        e = k - 1;
        reverse(arr, f,e);
        // System.out.println(arr);

        f = k;
        e = arrSize - 1;
        reverse(arr, f,e);
        System.out.println("RTL => " + arr);
        return arr;
    }

    ArrayList<Integer> rotateLTR (ArrayList<Integer> arr, int times) {
        int arrSize = arr.size();
        int f,e,k;
        f = 0;
        e = arrSize - 1;
        // System.out.println("initial => " + arr);
        reverse(arr, f,e);
        // System.out.println(arr);

        k = times % arrSize;
        f = 0;
        e = arrSize - k - 1;
        reverse(arr, f,e);
        // System.out.println(arr);

        f = arrSize - k;
        e = arrSize - 1;
        reverse(arr, f,e);
        System.out.println("LTR => " + arr);
        return arr;
    }
    public static void main(String[] args) {

        rotateArray rotArr = new rotateArray();
        
        int times = 2;
        ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        rotArr.rotateRTL(arr2, times);
        
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        rotArr.rotateLTR(arr, times);


    }
}
