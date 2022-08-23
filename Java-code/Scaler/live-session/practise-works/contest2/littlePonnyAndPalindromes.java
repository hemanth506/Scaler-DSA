import java.util.HashMap;

public class littlePonnyAndPalindromes {
    public int solve(String A) {
        int N = A.length();
        HashMap<Character, Integer> hs = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (hs.containsKey(A.charAt(i))) {
                int value = hs.get(A.charAt(i)) + 1;
                hs.put(A.charAt(i), value);
            } else {
                hs.put(A.charAt(i), 1);
            }
        }
        System.out.println(hs);

        int countOdd = 0;
        for (HashMap.Entry<Character, Integer> m : hs.entrySet()) {
            if(m.getValue() % 2 != 0) {
                countOdd += 1;
            }
        }
        System.out.println(countOdd);

        if(countOdd >= 2) {
            return 0;
        }

        return 1;
    }
    public static void main(String[] args) {
        littlePonnyAndPalindromes lt = new littlePonnyAndPalindromes();
        String A = "madamm";
        // String A = 
        lt.solve(A);
    }
}
