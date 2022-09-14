import java.util.Arrays;
import java.util.HashSet;

public class luckyNumbers {
    public int factors(int A, HashSet<Integer> primeHs) {
        int count = 0;
        for(int i = 1; i*i <= A; i++) {
            if(A%i == 0) {
                if(i != A/i) {
                    if(primeHs.contains(i)) {
                        count += 1;
                    }
                    if(primeHs.contains(A/i)) {
                        count += 1;
                    }
                } else {
                    if(primeHs.contains(i)) {
                        count += 1;
                    }
                }
            }
        }
        return count-1;
    }

    public int solve(int A) {
        // find all prime from 1 to 12
        boolean[] primeBool = new boolean[A + 1];
        Arrays.fill(primeBool, true);
        for(int i = 2; i*i <= A; i++) {
            if(primeBool[i] == true) {
                for(int j = i*i; j <= A; j += i) {
                    primeBool[j] = false;
                }
            }
        } 
        System.out.println(Arrays.toString(primeBool));

        HashSet<Integer> primeHs = new HashSet<Integer>();
        for(int i = 1; i < A; i++) {
            if(primeBool[i] == true) {
                primeHs.add(i);
            }
        }
        System.out.println(primeHs);

        int totalluckyNo = 0;
        for(int i = 1; i <= A; i++) {
            if(factors(i, primeHs) == 2) {
                totalluckyNo += 1;
            }
            System.out.println(factors(i, primeHs) + " " + i);
        }
        System.out.println("totalluckyNo => " + totalluckyNo);
        return totalluckyNo;
    }

    public static void main(String[] args) {
        luckyNumbers ln = new luckyNumbers();
        int A = 12;
        ln.solve(A);
    }
}
