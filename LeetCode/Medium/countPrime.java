import java.util.Arrays;

public class countPrime {
    public int countPrimes(int n) {
        boolean[] primeArr = new boolean[n];
        Arrays.fill(primeArr, true);

        for(int i = 2; i < n; i++) {
            if(primeArr[i] == true) {
                for(int j = i+i; j < n; j = j + i) {
                    primeArr[j] = false;
                }
            }
        }

        int count = 0;
        for(int i = 2; i < n; i++) {
            if(primeArr[i] == true) {
                count += 1;
            }
        }

        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        countPrime cp = new countPrime();
        int N = 1;
        cp.countPrimes(N);
    }
}
