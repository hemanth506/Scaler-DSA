import java.util.ArrayList;
import java.util.List;

public class grayCodeLC {
    public List<Integer> grayCode(int n) {
        if (n == 1) {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            arr.add(0);
            arr.add(1);
            return arr;
        }

        int k = n - 1;
        List<Integer> arr = grayCode(k);
        int len = arr.size();

        for(int i = len-1; i >= 0; i--) {
            arr.add(arr.get(i)+(1<<k));
        }

        return arr;
    }

    public static void main(String[] args) {
        grayCodeLC gc = new grayCodeLC();
        System.out.println(gc.grayCode(3));
    }
}
