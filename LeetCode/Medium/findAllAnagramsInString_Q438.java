import java.util.ArrayList;
import java.util.List;

public class findAllAnagramsInString_Q438 {
    public List<Integer> findAnagramsApproach1(String s, String p) {
        int N = s.length();
        int M = p.length();
        int[] availableChar = new int[26];

        for (int i = 0; i < M; i++) {
            availableChar[p.charAt(i) - 97]++;
        }

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] tempAvailableChar = availableChar.clone(); // 26 iteration -> O(1)
            for (int j = i; j < (i + M); j++) {
                if (j == N) {
                    break;
                }
                if (tempAvailableChar[s.charAt(j) - 97] != 0) {
                    tempAvailableChar[s.charAt(j) - 97]--;
                }
            }

            boolean unknowChar = checkIfAllZero(tempAvailableChar); // 26 iteration -> O(1)
            if (unknowChar) {
                arr.add(i);
            }
        }

        System.out.println(arr);
        return arr;
    }

    public boolean checkIfAllZero(int[] tempAvailableChar) {
        for (int k = 0; k < 26; k++) {
            if (tempAvailableChar[k] != 0) {
                return false;
            }
        }
        return true;
    }
    

    // Faster than the above approach - Sliding window tech
    public List<Integer> findAnagrams(String s, String p) {
        int N = s.length();
        int M = p.length();
        int[] availableChar = new int[26];
        int[] charSet = new int[26];
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            availableChar[p.charAt(i) - 97]++;
        }

        int O = Integer.min(N, M);
        for (int i = 0; i < O; i++) {
            charSet[s.charAt(i) - 97]++;
        }
        boolean isEqual = checkIfEqual(charSet, availableChar);
        if(isEqual) {
            arr.add(0);
        }
        
        int x = 0;
        for (int i = M; i < N; i++) {
            charSet[s.charAt(i) - 97]++;
            charSet[s.charAt(x) - 97]--;

            isEqual = checkIfEqual(charSet, availableChar); // 26 iteration -> O(1)
            if (isEqual) {
                arr.add(x+1);
            }
            x++;
        }

        System.out.println(arr);
        return arr;
    }

    public boolean checkIfEqual(int[] charSet, int[] availableChar) {
        for(int i = 0; i < 26; i++) {
            if(charSet[i] != availableChar[i]) {
                return false;
            }
        }
        return true;
    }

    

    public static void main(String[] args) {
        findAllAnagramsInString_Q438 fa = new findAllAnagramsInString_Q438();
        String s = "cbaebabacd";
        String p = "abc";
        fa.findAnagrams(s, p);
    }
}
