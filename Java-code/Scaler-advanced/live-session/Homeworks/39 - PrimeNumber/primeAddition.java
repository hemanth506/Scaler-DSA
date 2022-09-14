// import java.util.Arrays;
import java.util.HashSet;

public class primeAddition {
    public int solve(int A) {
        // =========================================================

        /* No need for finding the prime number since if we take LCM we will be using only prime numbers */

        // boolean[] primeBool = new boolean[A + 1];
        // Arrays.fill(primeBool, true);
        // for (int i = 2; i * i <= A / 2; i++) {
        //     if (primeBool[i] == true) {
        //         for (int j = i * i; j <= A / 2; j += i) {
        //             primeBool[j] = false;
        //         }
        //     }
        // }
        // System.out.println(Arrays.toString(primeBool));
        // HashSet<Integer> primeHs = new HashSet<Integer>();
        // for (int i = 2; i * i < A / 2; i++) {
        //     if (primeBool[i] == true) {
        //         primeHs.add(i);
        //     }
        // }
        // System.out.println(primeHs);

        // =========================================================

        HashSet<Integer> distinctNo = new HashSet<Integer>();
        outerWhile: while (A != 1) {
            System.out.println("start =>  " + A);
            int prevA = A;
            int currentA = A;
            innerFor: for (int i = A / 2; i >= 1; i--) {
                System.out.println(i + " -- ");
                if (A % i == 0) {
                    A = A / i;
                    System.out.println(i + " " + A);
                    distinctNo.add(i);
                    currentA = A;
                    break innerFor;
                }
            }
            if (prevA == currentA) {
                break outerWhile;
            }
            // System.out.println("infinite");
        }
        System.out.println(distinctNo.size());
        return distinctNo.size();
    }

    public static void main(String[] args) {
        primeAddition pa = new primeAddition();
        // int A = 26;
        // int A = 96;
        int A = 234;

        pa.solve(A);
    }
}
