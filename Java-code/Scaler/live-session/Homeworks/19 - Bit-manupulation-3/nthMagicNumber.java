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
    
    public static void main(String[] args) {
        nthMagicNumber magic = new nthMagicNumber();
        int A = 0;
        magic.solve(A);
    }
}
