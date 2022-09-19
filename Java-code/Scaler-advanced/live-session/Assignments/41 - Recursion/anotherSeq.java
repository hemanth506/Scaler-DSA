
public class anotherSeq {

    public int solveSub(int A, int sum) {
        if (A == 0) {
            return sum += 1;
        } else if(A == 1) {
            return sum += 1;
        } else if (A == 2) {
            return sum += 2;
        }
        sum = solveSub(A - 1, sum) + solveSub(A - 2, sum) + solveSub(A - 3, sum) + A;
        return sum;
    }

    public int solve(int A) {
        int sum = 0;
        return solveSub(A, sum);
    }
    public static void main(String[] args) {
        anotherSeq as = new anotherSeq();
        int A = 3;
        System.out.println(as.solve(A));
    }
}
