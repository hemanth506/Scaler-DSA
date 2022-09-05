
public class numberSetBits {
    public int numSetBits(int A) {

        int ct = 0;
        while (A > 0) {
            int divNum = A % 2;
            if (divNum == 1) {
                ct += 1;
            }
            A = A/2;
        }
        System.out.println(ct);
        return ct;
    }
    public static void main(String[] args) {
        numberSetBits ns = new numberSetBits();
        int A = 11;
        ns.numSetBits(A);
    }
}
