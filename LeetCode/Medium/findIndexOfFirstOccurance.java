public class findIndexOfFirstOccurance {
    public int strStr(String haystack, String needle) {
        int N = haystack.length();
        int needLen = needle.length();

        if(needLen > N) {
            return -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < needLen; i++) {
            sb.append(haystack.charAt(i));
        }
        System.out.println(sb);
        String fistSet = sb.toString(); 
        if(needle.equals(fistSet)) {
            System.out.println("matched in = " + 0);
            return 0;
        }

        int j = needLen;
        for(int i = 1; i <= (N-needLen); i++) {

            System.out.println(sb + " delete = " + (i-1) + " append = " + j);
            sb.deleteCharAt(0);
            sb.append(haystack.charAt(j));
            System.out.println(sb);
            String remainingSet = sb.toString(); 
            if(needle.equals(remainingSet)) {
                System.out.println("matched in = " + i);
                return i;
            }
            j++;
        }

        System.out.println("No match");
        return -1;   
    }
    public static void main(String[] args) {
        findIndexOfFirstOccurance fi = new findIndexOfFirstOccurance();
        // String haystack = "sadbutsad";
        // String needle = "sad";

        // String haystack = "leetcode";
        // String needle = "leeto";

        String haystack = "hello";
        String needle = "ll";
        fi.strStr(haystack, needle);
    }
}
