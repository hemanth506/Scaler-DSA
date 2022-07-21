
public class helpFromSam {
    public int solve(int A) {

        if (A == 0)
            return 0;
        int power = 1;
        int i = 0;
        int currentPower = 0;
        int help = power;
        while(power <= A) {
            currentPower = power;
            // System.out.println(currentPower);
            power += 1<<i;
            i++;
        }
        help += A - currentPower;
        System.out.println(help);
        return help;
    }

    // Use Bit manuplation for doubling and find questions
    public int solveBit(int A) {
        int help = 0;
        while (A > 0) {
            if ((A & 1) == 1) {
                help += 1;
            }
            A = A >> 1;
        }
        System.out.println(help);
        return help;
    }

    public static void main(String[] args) {
        helpFromSam help = new helpFromSam();
        int A = 7;
        help.solve(A);
        help.solveBit(A);
    }
}