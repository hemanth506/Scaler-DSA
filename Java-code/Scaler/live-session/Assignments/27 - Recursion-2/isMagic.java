
public class isMagic {
    public int sumVal(int A) {
        if (A == 0) {
            return 0;
        }
        int tempA = sumVal(A/10) + A%10;
        System.out.print(tempA + " ");
        return tempA;
    }
    public int sumSolve(int A) {
        System.out.println("A => " + A);
        if (A%10 != A) {
            int newRes = sumVal(A);
            System.out.println();
            if(newRes == 1) {
                System.out.println("Exit condition 2");
                return 1;
            } else {
                System.out.println("Else condition => " + newRes);
                if(sumSolve(newRes) == 1) {
                    System.out.println("Exit condition");
                    return 1;
                } else {
                    return 0;
                }
            }
        }
        System.out.println("tempA => " + A);
        System.out.println("unnessary");
        return 0;
    }
    public int solve(int A) {
        int value = sumSolve(A);
        System.out.println("Result => " + value);
        return value;
    }
    public static void main(String[] args) {
        isMagic mg =new isMagic();
        int A = 83557;
        mg.solve(A);
    }
}
