
public class powFormula {
    public int pow1(int A, int B, int C) {
        if (A < 0 && B <= 1) {
            return C + A;
        }
        if (A == 0) {
            return 0;
        }
        if(B == 1 || B == 0) {
            return 1;
        }
        int val = pow1(A, B/2, C) % C;
        if(B % 2 == 0) {
            System.out.println("=======Even=======");
            return (val% C * val% C)% C;
        } else {
            System.out.println("=======Odd=======");
            return ((val% C * val% C)% C * A% C)% C;
        }
    }

    public long powVal(int A, int B, int C) {
        if(B == 0) {
            return 1;
        }
        long val = powVal(A, B/2, C);
        if(B % 2 == 0) {
            // System.out.println("=======Even=======" + B);
            return (val * val) % C;
        } else {
            // System.out.println("=======Odd=======" + B);
            return ((val * val) * A)% C;
        }
    }

    public int pow(int A, int B, int C) {
        long powValue = powVal(A, B, C);
        long result = 0;
        if(powValue < 0) {
            result = powValue + C;
        } else {
            result = powValue % C;
        }
        return (int)result;
    }

    
    public static void main(String[] args) {
        powFormula pf = new powFormula();
        // int A = 2;
        // int B = 3;
        // int C = 3;

        int A = 0;
        int B = 0;
        int C = 1;

        // int A = -1;
        // int B = 2;
        // int C = 20;


        // int A = 71045970;
        // int B = 41535484;
        // int C = 64735492;

        // int A = 2132;
        // int B = 0;
        // int C = 12;
        System.out.println(pf.pow(A, B, C));
    }
}
