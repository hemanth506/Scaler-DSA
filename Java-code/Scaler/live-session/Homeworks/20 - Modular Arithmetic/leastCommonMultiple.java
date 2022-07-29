import java.util.Scanner;

public class leastCommonMultiple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Testcase count: ");
        int testCases = sc.nextInt();

        for (int cases = 0 ; cases < testCases; cases++) {
            System.out.println("Enter A: ");
            int A = sc.nextInt();

            System.out.println("Enter B: ");
            int B = sc.nextInt();

            int LCM = 1;
            while (A > 1 || B > 1) {
                int divisor = 2;
                boolean breakNow = true;
                while (breakNow){
                    if (A % divisor == 0 || B % divisor == 0) {
                        if (A % divisor == 0) {
                            A = A / divisor;
                        }

                        if (B % divisor == 0) {
                            B = B / divisor;
                        }
                        LCM *= divisor;
                        // System.out.println("divisor => "+ divisor + " A => " + A + " B => " + B);
                        breakNow = false;
                    }
                    divisor++;
                }
                // System.out.println(A + " " + B); 
            }
            System.out.println("LCM => " + LCM);
        }

        sc.close();
    }
}
