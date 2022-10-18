
public class smallestPrefixString {
    // Using Two Pointer tech
    public String smallestPrefix(String A, String B) {
        int N = A.length();
        StringBuilder str = new StringBuilder();

        // Anyhow the first charaacher in the string A should be there.
        str.append(A.charAt(0));
        int p1 = 1;
        int p2 = 0;

        while (p1 < N) {
            if(A.charAt(p1) < B.charAt(p2)) {
                str.append(A.charAt(p1));
                p1++;
            } else {
                break;
            }
        }
        if(str.length() != 0) {
            str.append(B.charAt(p2));
        } 
        
        System.out.println(str.toString());
        return str.toString();
    }
    public static void main(String[] args) {
        smallestPrefixString sp = new smallestPrefixString();
        // String A = "abba";
        // String B = "cdd";

        // String A = "abba";
        // String B = "ccdd";

        // String A = "acd";
        // String B = "bay";

        // String A = "tom";
        // String B = "riddle";

        // String A = "wixjzniiub";
        // String B = "ssdfodfgap";

        String A = "twvvsl";
        String B = "wtcyawv";
        sp.smallestPrefix(A, B);
    }
}
