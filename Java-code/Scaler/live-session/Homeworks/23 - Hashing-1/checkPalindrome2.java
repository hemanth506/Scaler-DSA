import java.util.HashMap;

public class checkPalindrome2 {
    public int solve(String A) {
        char[] charArr = A.toCharArray();
        int N = charArr.length;
        
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < N; i++) {
            if(hm.containsKey(charArr[i])) {
                int value = hm.get(charArr[i]) + 1;
                hm.put(charArr[i], value);
            } else {
                hm.put(charArr[i], 1);
            }
        }
        System.out.println(hm);

        int countOdd = 0;
        for (HashMap.Entry<Character, Integer> m : hm.entrySet()) {
            if (m.getValue() % 2 == 1) {
                countOdd += 1;
            }
        }
        int result = (countOdd == 0 || countOdd == 1) ? 1 : 0;
        System.out.println(countOdd + " " + result);
        return  result;
    }
    public static void main(String[] args) {
        checkPalindrome2 pal = new checkPalindrome2();
        
        // String A = "abbaee";
        String A = "abcde";
        pal.solve(A);
    }
}
