
public class isMagicNum {
    public int sumOfDigits(int A) {
        if(A == 0) {
            return 0;
        }
        return sumOfDigits(A/10) + A%10;
    }
    public int solve(int A) {
        if(A/10 == 0) {
            if (A == 1) {
                return 1;
            } else {
                return 0;
            }
        }
        int val = sumOfDigits(A);
        return solve(val);
    }
    public static void main(String[] args) {
        isMagicNum mg = new isMagicNum();
        // int A = 83557;
        int A = 1291;
        System.out.println(mg.solve(A));
    }
}
