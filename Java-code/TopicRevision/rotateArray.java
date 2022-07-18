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

    ArrayList<Integer> rotate (ArrayList<Integer> arr, int times) {
        int arrSize = arr.size();
        int f,e,k;
        f = 0;
        e = arrSize - 1;
        System.out.println("initial => " + arr);
        reverse(arr, f,e);
        System.out.println(arr);

        k = times % arrSize;
        f = 0;
        e = k - 1;
        reverse(arr, f,e);
        System.out.println(arr);

        f = k;
        e = arrSize - 1;
        reverse(arr, f,e);
        System.out.println(arr);
        return arr;
    }
    public static void main(String[] args) {

        rotateArray rotArr = new rotateArray();
        
        int times = 7;
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(3,-2,1,4,6,9,8));
        rotArr.rotate(arr, times);
    }
}
