import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class singleNum2 {
    public int singleNumber(final List<Integer> A) {
        int N = A.size();
        int missingElt = 0;
        for(int i = 0; i < 32; i++) {
            int ct = 0;
            for (int j = 0; j < N; j++) {
                if (((A.get(j) >> i) & 1) == 1){
                    ct += 1;
                }
            }
            if ((ct % 3) == 1) {
                missingElt = missingElt + (1 << i);
            }
        }

        System.out.println(missingElt);
        return missingElt;
    }
    public static void main(String[] args) {
        singleNum2 num2 = new singleNum2();
        List<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 3, 3, 2, 2, 3, 1, 1));
        num2.singleNumber(A);
    }
}
