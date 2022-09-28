import java.util.ArrayList;
import java.util.Arrays;

public class firstOccurance {
    public int firstOcc(ArrayList<Integer> A, int B) {
        int N = A.size();
        int l = 0;
        int h = N - 1;
        int ans = 0;
        while (l <= h) {
            int m = (l + h) / 2;
            if(A.get(m) == B) {
                ans = m;
                h = m - 1;
            }
            if (A.get(m) < B) {
                l = m + 1;
            } else if (A.get(m) > B) {
                h = m - 1;
            }
        }
        System.out.println(ans);
        return ans;
    }
    public static void main(String[] args) {
        firstOccurance fo = new firstOccurance();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,1,1,1,5,5,5,7,7,7,8,8,8,9,9));
        int B = 5;
        fo.firstOcc(A, B);
    }
}
