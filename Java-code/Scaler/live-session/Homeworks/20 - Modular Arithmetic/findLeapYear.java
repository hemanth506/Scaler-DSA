
public class findLeapYear {
    public int solve(int A) {
        if (A % 4 == 0 & A % 100 != 0 || A % 400 == 0) {
            System.out.println("It is leap year");
            return 1;
        }
        System.out.println("It is not a leap year");
        return 0;
    }
    public static void main(String[] args) {
        findLeapYear leap = new findLeapYear();
        int A = 2020;
        leap.solve(A);
    }
}
