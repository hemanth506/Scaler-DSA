import java.util.HashMap;

public class littlePonnyAndPalindromes {
    public int solve(String A) {
        int N = A.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (hm.containsKey(A.charAt(i))) {
                int value = hm.get(A.charAt(i)) + 1;
                hm.put(A.charAt(i), value);
            } else {
                hm.put(A.charAt(i), 1);
            }
        }
        System.out.println(hm);

        int countOdd = 0;
        for (HashMap.Entry<Character, Integer> m : hm.entrySet()) {
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
