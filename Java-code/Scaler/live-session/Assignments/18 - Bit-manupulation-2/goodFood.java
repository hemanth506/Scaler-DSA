public class goodFood {

    public int solve(int A) {
        int food = 0;
        while (A > 0) {
            if ((A & 1) == 1) {
                food++;
            }
            A = A >> 1;
        }
        System.out.println(food);
        return food;
    }

    public static void main(String[] args) {
        goodFood good = new goodFood();
        int A = 8;
        good.solve(A);
    }
}
