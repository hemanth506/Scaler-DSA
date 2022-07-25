import java.util.ArrayList;

public class nthMagicNumber {
    public int solve(int A) {
        if (A == 0) {
            System.out.println(0);
            return 0;
        }

        int powerValue = 1;
        int i = 1;
        int magicNumber = 5;
        ArrayList<Integer> values = new ArrayList<Integer>();
        while (i <= A) {
            powerValue = powerValue * magicNumber;
            values.add(powerValue);
            // System.out.println(values + " " + values.size());

            ArrayList<Integer> nestValues = new ArrayList<Integer>();
            int newPowerValue = powerValue;
            for (int k = 0; k < values.size() - 1; k++) {
                // System.out.println("value to multiply =>  " + values.get(k));
                newPowerValue = powerValue + values.get(k);
                nestValues.add(newPowerValue);
                i++;
                if (i == A) {
                    break;
                }
            }
            // System.out.println(nestValues);

            values.addAll(nestValues);
            // System.out.println(powerValue);
            i++;
        }

        System.out.println(values.get(A-1));

        return values.get(A-1);
    }
    
    // peer code.
    public int solveN(int A) {
        int ans = 0;
        for (int i = 0; A > 0; i++, A = A >> 1){
            if ((A & 1) == 1) {
                ans += Math.pow(5, (i+1));
                System.out.println(Math.pow(5, (i+1)));
            }
        }
        System.out.println(ans);
        return ans;
    }
    public static void main(String[] args) {
        nthMagicNumber magic = new nthMagicNumber();
        int A = 7;
        magic.solve(A);
        magic.solveN(A);
    }
}
