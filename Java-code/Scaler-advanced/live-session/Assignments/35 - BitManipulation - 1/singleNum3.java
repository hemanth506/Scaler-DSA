import java.util.ArrayList;
import java.util.Arrays;

public class singleNum3 {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int N = A.size();

        // will get the sum of unique values
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = ans ^ A.get(i);
        }
        System.out.println(ans);

        // find position
        int pos = 0;
        for (int i = 0; i < N; i++) {
            if(((ans >> i) & 1) == 1) {
                pos = i;
                break;
            } 
        }
        System.out.println(pos);

        int set = 0;
        int unset = 0;
        for (int i = 0; i < N; i++) {
            if(((A.get(i) >> pos) & 1) == 1) {
                set = set ^ A.get(i);
            } else {
                unset = unset ^ A.get(i);
            }
        }
        System.out.println(set + " " + unset);

        ArrayList<Integer> arrList = new ArrayList<Integer>();
        if (set > unset) {
            arrList.add(unset);
            arrList.add(set);
        } else {
            arrList.add(set);
            arrList.add(unset);
        }

        return arrList;
    }
    public static void main(String[] args) {
        singleNum3 nm = new singleNum3();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 1, 2, 4));
        nm.solve(A);
    }
}
