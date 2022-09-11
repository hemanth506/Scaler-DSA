
public class implementPowFunc {
    // Doing this n times using normal iteration
    public int powInterateFor(int A, int B, int C) {
        long val = 0;
        for(int i = 0; i < B; i++) {
            val = ((val%C) + ((A%C)<<i)%C) % C;
            if(val < 0) {
                val = (val + C) % C;
            }
            val = val % C;
        }
        System.out.println(val%C);
        return (int) val%C;
    }

    // =============================================
    // returns stackoverflow error for very large inputs when we iterate it one by one
    public long powModIterateOByO(int A, int B, int C) {
        // Base condition
        if (B == 0 && A == 0) {
            return 0;
        } else if (B == 0) {
            return 1;
        }
        long val = ((powModIterateOByO(A, B-1, C) % C) * (A % C) + C) % C;
        return val % C;
    }
    // =============================================

    // Use recurtion to solve this
    public long pow(int A, int B, int C) {
        // Base condition
        if (B == 0 && A == 0) {
            return 0;
        } else if (B == 0) {
            return 1;
        }
        long val = pow(A, B/2, C);
        if (B % 2 == 0) {
            return ((val * val) + C) % C;
        } else {
            return (((val * val) % C * A) + C) % C;
        }
    }

    public static void main(String[] args) {
        implementPowFunc im = new implementPowFunc();
        // int A = 2;
        // int B = 3;
        // int C = 3;

        // int A = 71045970;
        // int B = 41535484;
        // int C = 64735492;

        // int A = 0;
        // int B = 0;
        // int C = 1;

        int A = 2;
        int B = 120;
        int C = 1000000007;
        System.out.println(im.pow(A, B, C));
    }
}
