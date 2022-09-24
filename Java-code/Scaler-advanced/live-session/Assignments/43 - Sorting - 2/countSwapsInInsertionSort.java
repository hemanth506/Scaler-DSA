import java.util.ArrayList;
import java.util.Arrays;

public class countSwapsInInsertionSort {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        int ct = 0;
        for(int i = 1; i < N; i++) {
            // System.out.println(i);
            for(int j = i - 1; j >= 0; j--) {
                // System.out.println(j + "===" + (j+1) + "===" + A.get(j) + "===" + A.get(j+1));
                if(A.get(j) > A.get(j+1)) {
                    int temp = A.get(j);
                    A.set(j, A.get(j+1));
                    A.set(j+1, temp);
                    ct += 1;
                } else {
                    break;
                }
            }
            System.out.println("-------------");
        }
        System.out.println(A);
        System.out.println(ct);
        return ct;
    }
    public static void main(String[] args) {
        countSwapsInInsertionSort ct = new countSwapsInInsertionSort();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5, 3, 1, 9, 4));
        ct.solve(A);
    }
}
