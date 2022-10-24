import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class maxiLenOfConcatStrOfUniqueChar1239 {
    // Wrong approach
    public int maxLengthWrong(List<String> arr) {
        int N = arr.size();
        HashMap<Integer, HashSet<Character>> hms = new HashMap<Integer, HashSet<Character>>();
        for(int i = 0; i < N; i++) {
            int strLen = arr.get(i).length();
            HashSet<Character> hs = new HashSet<>(); 
            for(int j = 0; j < strLen; j++) {
                hs.add(arr.get(i).charAt(j));
            }
            hms.put(i, hs);
        }
        System.out.println(hms);

        int maxLen = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            HashSet<Character> hs = new HashSet<>(); 
            for(int j = i; j < N; j++) {
                int strLen = arr.get(j).length();
                String curString = arr.get(j);
                boolean noAddAll = false;
                for(int k = 0; k < strLen; k++) {
                    if(hs.contains(curString.charAt(k))) {
                        noAddAll = true;
                        break;
                    }
                }
                if(!noAddAll && strLen == hms.get(j).size()) {
                    System.out.println(hs);
                    hs.addAll(hms.get(j));
                }
            }
            maxLen = Integer.max(maxLen, hs.size());
        }

        System.out.println(maxLen);
        return maxLen;   
    }

    public int maxLength(List<String> arr) {
        int N = arr.size();
        int maxLen = Integer.MIN_VALUE;
        for(int i = 0; i < (1<<N); i++) {
            HashSet<Character> hs = new HashSet<>();
            for(int j = 0; j < N; j++) {
                if(((i>>j) & 1) == 1) {
                    // System.out.println(arr.get(j) + " " + j);
                    int strLen = arr.get(j).length();
                    String curString = arr.get(j);
                    boolean noAddAll = false;
                    HashSet<Character> hms = new HashSet<>();
                    for(int k = 0; k < strLen; k++) {
                        if(hs.contains(curString.charAt(k))) {
                            noAddAll = true;
                            break;
                        } else {
                            hms.add(curString.charAt(k));
                        }
                    }
                    if(!noAddAll && strLen == hms.size()) {
                        // System.out.println(hs);
                        hs.addAll(hms);
                    }
                }
            }
            maxLen = Integer.max(maxLen, hs.size());
            // System.out.println("=====");
        }
        System.out.println(maxLen);
        return maxLen;
    }
    
    public static void main(String[] args) {
        maxiLenOfConcatStrOfUniqueChar1239 ml = new maxiLenOfConcatStrOfUniqueChar1239();
        List<String> arr = new ArrayList<String>();
        // arr.add("un");   
        // arr.add("iq");
        // arr.add("ue");

        // arr.add("abcdefghijklmnopqrstuvwxyz");

        // arr.add("cha");
        // arr.add("r");
        // arr.add("act");
        // arr.add("ers");

        // arr.add("aa");
        // arr.add("bb");

        // arr.add("a");
        // arr.add("abc");
        // arr.add("d");
        // arr.add("de");
        // arr.add("def");

        arr.add("ab");
        arr.add("ba");
        arr.add("cd");
        arr.add("dc");
        arr.add("ef");
        arr.add("fe");
        arr.add("gh");
        arr.add("hg");
        arr.add("ij");
        arr.add("ji");
        arr.add("kl");
        arr.add("lk");
        arr.add("mn");
        arr.add("nm");
        arr.add("op");
        arr.add("po");

        ml.maxLength(arr);
    }
}
