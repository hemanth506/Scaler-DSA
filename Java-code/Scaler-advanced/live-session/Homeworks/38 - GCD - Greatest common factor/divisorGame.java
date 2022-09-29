/*
 * Run a loop from 1 to A and check if that number is divisible by B and C. If it does increase the count.
Can we loop to a large number up to 10^9?
 */
public class divisorGame {
    public int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }

    public int solveBruteForce(int A, int B, int C) {
        int count = 0;
        for(int i = 1; i <= A; i++) {
            if (i%B == 0 && i%C == 0) {
                System.out.println("A => " + i);
                count += 1;
            }
        }
        System.out.println(count);
        return count;
    }

    // Correct solution
    public int solve(int A, int B, int C) {
        int mult = 0;
        int div = 0;
        if(B > C) {
            mult = B;
            div = C;
        } else {
            mult = C;
            div = B;
        }
        int GCD = 0;
        int count = 0;
        while (GCD <= A) {
            if(GCD % div == 0 && GCD != 0) {
                System.out.println(GCD);
                count += 1;
            }
            GCD += mult;
        }
        System.out.println(count);
        return count;
    }
    public static void main(String[] args) {
        divisorGame dg = new divisorGame();
        int A = 12;
        int B = 3;
        int C = 2;

        dg.solve(A, B, C);
    }
}
