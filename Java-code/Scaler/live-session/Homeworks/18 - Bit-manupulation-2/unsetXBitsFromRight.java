
public class unsetXBitsFromRight {
    public Long solve(Long A, int B) {
        A = ((A >> B) << B);
        // System.out.println(A);
        return A;
    }
    public static void main(String[] args) {
        unsetXBitsFromRight unset = new unsetXBitsFromRight();
        Long A = (long) 53;
        int B = 5;
        unset.solve(A, B);
    }
}
