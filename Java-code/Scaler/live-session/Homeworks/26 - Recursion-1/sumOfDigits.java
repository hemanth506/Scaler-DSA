
public class sumOfDigits {

    public int sumVal(int N, long modV) {
        if (N < modV) {
            System.out.println("inside => " + N + " " + modV + " " + (N % modV) + " " +  (modV/10)+ " " +(N % modV)/(modV/10));
            return (int) ((int)(N % modV)/(modV/10));
        }
        System.out.println(N + " " + modV + "   value => " + (N % modV)/(modV/10));
        int result = (int) (((N % modV)/(modV/10)) + sumVal(N, modV *= 10));
        System.out.println(result);
        return result;
    }

    public int solve(int A) {
        long modV = 10;
        return sumVal(A, modV);
    }
    public static void main(String[] args) {
        sumOfDigits sd = new sumOfDigits();
        int A = 25345;
        // int A = 1000000000;
        sd.solve(A);
    }
}
