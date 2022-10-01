
public class squareRoot {
    public int sqrt(int A) {
        if (A == 1) {
            System.out.println(1);
            return 1;
        }
        long l = 1;
        long r = A;
        long ans = 0;
        while (l <= r) {
            long mid = (l + r) / 2;
            long lMid = mid * mid;
            if (lMid <= A) {
                ans = mid;
                // System.out.println(ans);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);
        return (int)ans;
    }
    public static void main(String[] args) {
        squareRoot sr = new squareRoot();
        int A = 4;
        // int A = 2147483647;

        sr.sqrt(A);
    }
}
