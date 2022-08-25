// solve like fibanocci series.
public class anotherSequenceProblem {
    public int solveOpt(int A) {
        if (A <= 2) {
            if (A == 0) {
                return 1;
            } else {
                return A;
            }
        }
        int res = solveOpt(A-1) + solveOpt(A-2) + solveOpt(A - 3) + A;
        System.out.println(res);
        return res;
    }
    public static void main(String[] args) {
        int A = 5;
        anotherSequenceProblem an = new anotherSequenceProblem();
        an.solveOpt(A);        
    }
}
