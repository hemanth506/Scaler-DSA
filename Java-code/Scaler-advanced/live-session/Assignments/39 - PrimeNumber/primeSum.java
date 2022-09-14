import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class primeSum {
    public ArrayList<Integer> primesum(int A) {
        boolean[] findPrimes = new boolean[A + 1];
        Arrays.fill(findPrimes, true); 

        for(int i = 2; i*i <= A; i++) {
            if(findPrimes[i] == true) {
                for(int j = i*i; j <= A; j += i) {
                    findPrimes[j] = false;
                }
            }
        }
        // System.out.println(Arrays.toString(findPrimes));

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int k = 0;
        for(int i = 2; i < findPrimes.length; i++) {
            if(findPrimes[i] == true) {
                hm.put(k, i);
                k++;
            }

        }
        System.out.println(hm);

        ArrayList<Integer> values = new ArrayList<Integer>();
        int a = hm.get(0);
        int b = A - a;
        for(int p = 1; p < hm.size(); p++) {
            int c = hm.get(p);
            int d = A - c;
            if(hm.containsValue(d)) {
                if (a < c || a == c && b < d) {
                    a = c;
                    b = d;
                    break;
                }
            }
        }
        values.add(a);
        values.add(b);
        System.out.println(values);

        return values;
    }
    public static void main(String[] args) {
        primeSum ps = new primeSum();
        
        int A = 4;
        // int A = 378;

        ps.primesum(A);
    }
}
