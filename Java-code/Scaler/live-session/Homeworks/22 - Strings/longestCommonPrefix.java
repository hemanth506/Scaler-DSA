import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class longestCommonPrefix {
    public String longestCommon(ArrayList<String> A) {
        Collections.sort(A, new MySort());
        // System.out.println(A);

        String firstValue = A.get(0);
        int firstIndexLen = firstValue.length();
        int N = A.size();
        int maxLen = firstIndexLen;
        for (int i = 1; i < N ; i++) {
            String currentValue = A.get(i);
            innerloop:
            for (int j = 0; j < firstIndexLen; j++) {
                // System.out.println(firstValue.charAt(j) + " " + currentValue.charAt(j) + " " +j);
                if (firstValue.charAt(j) != currentValue.charAt(j)) {
                    if (maxLen > j) {
                        maxLen = j;
                    }
                    break innerloop;
                }
            }
        }

        String substr2 = firstValue.substring(0,maxLen);
        // System.out.println(substr2);


        return substr2;
    }
    public static void main(String[] args) {
        longestCommonPrefix lcf = new longestCommonPrefix();
        // ArrayList<String> A = new ArrayList<String>(Arrays.asList("abab", "ab", "abcd"));
        ArrayList<String> A = new ArrayList<String>(Arrays.asList("abcdefgh", "aefghijk", "abcefgh"));

        
        lcf.longestCommon(A);
    }
}

class MySort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int diff = o1.length() - o2.length();
        // System.out.println(diff);
        return diff;
    }
    
}
