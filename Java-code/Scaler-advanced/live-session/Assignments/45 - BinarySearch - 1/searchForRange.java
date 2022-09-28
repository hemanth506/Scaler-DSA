import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class searchForRange {
    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        int N = A.size();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int l = 0;
        int h = N - 1;
        int ans = 0;
        boolean chechStart = false;
        while (l <= h) {
            int m = (l + h) / 2;
            if(A.get(m) == B) {
                ans = m;
                h = m - 1;
                chechStart = true;
            }
            if (A.get(m) < B) {
                l = m + 1;
            } else if (A.get(m) > B) {
                h = m - 1;
            }
        }
        System.out.println(ans);


        int l1 = 0;
        int h1 = N - 1;
        int ans1 = 0;
        boolean chechEnd = false;
        while (l1 <= h1) {
            int m1 = (l1 + h1) / 2;
            if(A.get(m1) == B) {
                ans1 = m1;
                l1 = m1 + 1;
                chechEnd = true;
            }
            if (A.get(m1) < B) {
                l1 = m1 + 1;
            } else if (A.get(m1) > B) {
                h1 = m1 - 1;
            }
        }
        System.out.println(ans1);

        // arr.add(e)
        if (chechEnd && chechStart) {
            arr.add(ans);
            arr.add(ans1);
        } else {
            arr.add(-1);
            arr.add(-1);
        }

        System.out.println(arr);
        return arr;
    }
    public static void main(String[] args) {
        searchForRange sr = new searchForRange();
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(1,1,1,1,5,5,5,7,7,7,8,8,8,9,9));
        // int B = 7;

        List<Integer> A = new ArrayList<Integer>(Arrays.asList(1));
        int B = 1;
        sr.searchRange(A, B);
    }
}
