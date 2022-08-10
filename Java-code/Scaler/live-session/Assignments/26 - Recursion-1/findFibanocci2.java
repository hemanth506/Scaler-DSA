
public class findFibanocci2 {
    public int fibanocci(int N) {
        if (N <= 1) {
            return N;
        }
        System.out.println((N - 1) + " " + (N - 2));
        return fibanocci(N - 1) + fibanocci(N - 2);
    }
    public int findAthFibonacci(int A) {
        System.out.println(fibanocci(A));
        return 1;
    }
    public static void main(String[] args) {
        findFibanocci2 fb = new findFibanocci2();
        int A = 9;
        fb.findAthFibonacci(A);
    }
}
