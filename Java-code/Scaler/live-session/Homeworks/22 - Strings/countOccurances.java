
public class countOccurances {
    public int solve(String A) {
        int N = A.length();

        int count = 0;
        for (int i = 1; i< N - 1;i++) {            
            if (A.charAt(i) == 'o' && A.charAt(i-1) == 'b' && A.charAt(i+1) == 'b') {
                count += 1;
            }
        }
        System.out.println(count);
        return count;
    }
    public static void main(String[] args) {
        countOccurances ct = new countOccurances();
        String A = "bobob";
        ct.solve(A);
    }
}
