
public class noOfDoorsOpen {
    public int solve(int A) {
        int ct = 0;
        for(int i = 1; i*i <= A; i++) {
            ct += 1;
        }
        System.out.println(ct);
        return A;
    }
    public static void main(String[] args) {
        noOfDoorsOpen nd = new noOfDoorsOpen();
        int A = 6;
        nd.solve(A);
    }
}
