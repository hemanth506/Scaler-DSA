public class powerFunction {
    public long onlyPowerValue(int A, int B) {
        if (B == 0) {
            return 1;
        }

        long result = onlyPowerValue(A, B / 2);
        if (B % 2 == 0) {
            return (result * result);
        } else {
            return ((result * result) * A);
        }
    }
    
    
    public long res(int A, int B, int C) {
        if (B == 0) {
            return 1;
        }

        long result = res(A, B / 2, C);
        if (B % 2 == 0) {
            return (result * result) % C;
        } else {
            return ((result * result % C) * A) % C;
        }
        // long result = res(A, B-1, C);
        // return (A * result) % C;
    }

    public int pow(int A, int B, int C) {
        long result = res(A, B, C);
        long finRes = 0;
        if (result < 0) {
            finRes = C + result;
            System.out.println(C + " + " + result + " = " + finRes);
        } else {
            finRes = result % C;
            System.out.println(result + " % " + C + " = " + finRes);
        }
        return (int) finRes;
    }

    public static void main(String[] args) {
        powerFunction pf = new powerFunction();
        int A = 2;
        int B = 3;
        int C = 3;
        // int A = -1;
        // int B = 1;
        // int C = 20;
        // int A = 0;
        // int B = 0;
        // int C = 1;
        System.out.println("Ans => " + pf.pow(A, B, C));
        System.out.println("Res Ans => " + pf.res(A, B, C));
        System.out.println("power Ans => " + pf.onlyPowerValue(A, B));


    }
}
