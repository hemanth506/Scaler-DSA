import java.util.ArrayList;
import java.util.Arrays;

public class segmentedSeive {
    public ArrayList<Integer> solve(int A, int B) {
        // ========================================================
        // find all prime numbers within sqrt
        int sqt = (int) Math.sqrt(B);
        System.out.println(sqt);
        boolean[] primeBool = new boolean[sqt + 1];
        Arrays.fill(primeBool, true);
        for(int i = 2; i*i <= sqt; i++) {
            // System.out.println(i);
            if(primeBool[i] == true) {
                for(int j = i*i; j <= sqt; j+=i) {
                    primeBool[j] = false;
                }
            }
        } 
        // System.out.println(Arrays.toString(primeBool));
        ArrayList<Integer> primeArr = new ArrayList<Integer>();
        for(int i = 2; i < primeBool.length; i++) {
            if(primeBool[i] == true) {
                primeArr.add(i);
            }
        }
        System.out.println(primeArr);

        // ========================================================


        boolean[] prime = new boolean[B - A + 1];
        Arrays.fill(prime, true);
        for(int i = 0; i < primeArr.size(); i++) {
            int start = 0;
            int p = primeArr.get(i);
            if(A % p == 0) {
                start = A;
            } else {
                start = A/p * p + p;
            }

            if(start == p) {
                start = start + p;
            }

            for(int j = start; j <= B; j += p) {
                prime[j - A] = false;
            }
        }
        // System.out.println(Arrays.toString(prime));

        ArrayList<Integer> primeArrVal = new ArrayList<Integer>();
        for(int i = 0; i < prime.length; i++) {
            if(prime[i] == true) {
                primeArrVal.add(i + A); 
            }
        }
        System.out.println(primeArrVal);

        return primeArrVal;
    }
    public static void main(String[] args) {
        segmentedSeive ss = new segmentedSeive();
        int A = 1;
        int B = 30;
        ss.solve(A, B);
    }
}
