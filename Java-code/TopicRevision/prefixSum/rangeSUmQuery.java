import java.util.ArrayList;
import java.util.Arrays;

public class rangeSUmQuery {
    public ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int N = A.size();

        ArrayList<Long> prefix = new ArrayList<Long>();
        prefix.add((long)A.get(0));
        for (int i = 1; i < N; i++) {
            prefix.add((long)(prefix.get(i - 1) + A.get(i)));
        }
        System.out.println(prefix);

        ArrayList<Long> valSubArray = new ArrayList<Long>();
        int BLen = B.size();
        for(int k = 0; k < BLen; k++) {
            ArrayList<Integer> value = B.get(k);
            int l = value.get(0) - 1;
            int r = value.get(1) - 1;
            // System.out.println(l + " " + r);

            long result;
            if (l == 0) {
                result = prefix.get(r);
            } else {
                result = prefix.get(r) - prefix.get(l - 1);
            }
            // System.out.println(result);
            valSubArray.add(result);
        }
        System.out.println(valSubArray);
        return valSubArray;
    }
    
    
    public static void main(String[] args) {
        rangeSUmQuery rg = new rangeSUmQuery();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        B.add(new ArrayList<Integer>(Arrays.asList(1, 4)));
        B.add(new ArrayList<Integer>(Arrays.asList(2, 3)));

        rg.rangeSum(A, B);
    }
}
