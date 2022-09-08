import java.util.ArrayList;
import java.util.Arrays;

public class countSubarrayOREqualZero {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        int ct = 0;
        int totalArr = 0;
        for(int i = 0; i < N; i++) {
            if (A.get(i) == 0) {
                ct += 1;
                System.out.println(i + " " + ct);
            } else {
                totalArr += (ct * (ct + 1)) / 2;
                ct = 0;
            }
        }
        totalArr += (ct * (ct + 1)) / 2;
        System.out.println(totalArr);
        return totalArr;
    }
    public static void main(String[] args) {
        countSubarrayOREqualZero coz = new countSubarrayOREqualZero();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,1,0,0,0,1,0,1,0,0));
        coz.solve(A);
    }
}
