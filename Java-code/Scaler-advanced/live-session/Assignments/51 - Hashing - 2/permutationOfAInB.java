import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class permutationOfAInB {
    public int solveMyCorrectSoln(String A, String B) {
        int N = B.length();
        int k = A.length();

        HashMap<Character, Integer> hmActual = new HashMap<Character, Integer>();
        for(int i = 0; i < k; i++) {
            if(hmActual.containsKey(A.charAt(i))) {
                int charCt = hmActual.get(A.charAt(i)) + 1;
                hmActual.put(A.charAt(i), charCt);
            } else {
                hmActual.put(A.charAt(i), 1);
            }
        }
        System.out.println("hmActual = " + hmActual);

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(int i = 0; i < k; i++) {
            if(hm.containsKey(B.charAt(i))) {
                int charCt = hm.get(B.charAt(i)) + 1;
                hm.put(B.charAt(i), charCt);
            } else {
                hm.put(B.charAt(i), 1);
            }
        }

        int repeat = 0;
        for(Map.Entry<Character, Integer> entryMap: hmActual.entrySet()) {
            System.out.println(entryMap.getKey() + " " + entryMap.getValue());
            if(hm.get(entryMap.getKey()) == entryMap.getValue()) {
                repeat += 1;
            } else {
                break;
            }
        }
        int count = (hm.size() == repeat) ? 1 : 0;

        System.out.println(count + " " + hm);
        int j = k;
        for(int i = 1; i <= (N-k); i++) {
            char removeChar = B.charAt(i - 1);
            char addChar = B.charAt(j);

            // to remove
            if(hm.get(removeChar) > 1) {
                int reduce = hm.get(removeChar) - 1;
                hm.put(removeChar, reduce);
            } else {
                hm.remove(removeChar);
            }

            // to add
            if(hm.containsKey(addChar)) {
                int increase = hm.get(addChar) + 1;
                hm.put(addChar, increase);
            } else {
                hm.put(addChar, 1);
            }
            j++;

            System.out.println(hm);
            

            repeat = 0;
            for(Map.Entry<Character, Integer> entryMap: hmActual.entrySet()) {
                System.out.println(entryMap.getKey() + " " + entryMap.getValue());
                if(hm.get(entryMap.getKey()) == entryMap.getValue()) {
                    repeat += 1;
                } else {
                    break;
                }
            }

            if(hm.size() == repeat) {
                count += 1;
            }
        }

        System.out.println(count);
        return count;
    }

    // Because of hashmap, it was giving some errors for hard cases, so tried with arrays.
    public int solve(String A, String B) {
        System.out.println("Hemanth");
        int N = B.length();
        int K = A.length();
        int hashArr1[] = new int[26];
        int hashArr2[] = new int[26];
        int count = 0;

        for(int i = 0; i < K; i++) {
            System.out.println(A.charAt(i));
            hashArr1[A.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(hashArr1));

        for(int j = 0; j < K; j++) {
            hashArr2[B.charAt(j) - 'a']++;
        }
        System.out.println(Arrays.toString(hashArr2));

        count += same(hashArr1, hashArr2);

        int p = K;
        for(int i = 0; i < (N-K); i++) {
            hashArr2[B.charAt(i) - 'a']--;
            hashArr2[B.charAt(p) - 'a']++;
            p++;
            count += same(hashArr1, hashArr2);
        }

        System.out.println(count);

        return count;
    }

    public int same(int[] hash1, int[] hash2) {
        for(int i = 0; i < 26; i++) {
            if(hash1[i] != hash2[i]) {
                return 0;
            }
        }
        return 1;
    }
    

    public static void main(String[] args) {
        permutationOfAInB ab = new permutationOfAInB();
        String A = "abc";
        String B = "abcbacabc";

        // String A = "aca";
        // String B = "acaa";
        ab.solveMyCorrectSoln(A, B);
        System.out.println("==========================================");
        ab.solve(A, B);

    }
}
