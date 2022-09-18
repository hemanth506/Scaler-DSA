
public class sumOfDigits {
    public int solve(int A) {
        if(A == 0) {
            return 0;
        }

        return solve(A/10) + A%10;
    }
    public static void main(String[] args) {
        sumOfDigits sd = new sumOfDigits();
        int A = 46;
        System.out.println(sd.solve(A));
    }
}
