import java.util.ArrayList;
import java.util.Arrays;

public class sumByRemovingAnElt {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();

        /*
         * prefixEven = []
         * prefixEven[0] = A[0]
         * for(int i = 0; i< N; i++) {
         *      if(i%2 == 0) {
         *          prefixEven[i] = prefixEven[i - 1] + A[i]
         *      } else {
         *          prefixEven[i] = prefixEven[i - 1]
         *      }
         * }
         * 
         * prefixOdd = []
         * prefixOdd[0] = 0
         * for(int i = 0; i< N; i++) {
         *      if(i%2 != 0) {
         *          prefixOdd[i] = prefixOdd[i - 1] + A[i]
         *      } else {
         *          prefixOdd[i] = prefixOdd[i - 1]
         *      }
         * }
         * 
         * 
         */
        ArrayList<Integer> prefixEven = new ArrayList<Integer>();
        prefixEven.add(A.get(0));
        int evenVal = prefixEven.get(0);
        for (int i = 1; i < N; i++) {
            if(i % 2 == 0) {
                evenVal = prefixEven.get(i - 1) + A.get(i);
                prefixEven.add(evenVal);
            } else {
                prefixEven.add(evenVal);
            }
        }
        System.out.println(prefixEven);

        ArrayList<Integer> prefixOdd = new ArrayList<Integer>();
        prefixOdd.add(0);
        int oddVal = 0;
        for (int i = 1; i < N; i++) {
            if(i % 2 != 0) {
                oddVal = prefixOdd.get(i - 1) + A.get(i);
                prefixOdd.add(oddVal);
            } else {
                prefixOdd.add(oddVal);
            }
        }
        System.out.println(prefixOdd);


        int specialIndex = 0;
        for(int l = 0; l < N; l++) {

            int even =  prefixOdd.get(N - 1) - prefixOdd.get(l);
            if (l != 0) {
                even += prefixEven.get(l - 1);
            }
            
            int odd = prefixEven.get(N - 1) - prefixEven.get(l);
            if(l != 0) {
                odd += prefixOdd.get(l - 1);
            }
            
            if (even == odd) {
                System.out.println(l+ " " + even + " " + odd);
                specialIndex += 1;
            }
        }
        System.out.println(specialIndex);

        return specialIndex;
    }
    public static void main(String[] args) {
        sumByRemovingAnElt sm = new sumByRemovingAnElt();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(4,3,2,7,6,-2));
        sm.solve(A);
    }
}
