
public class checkTwoStringsAreEquivalent {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int N = word1.length;
        StringBuilder word1Str = new StringBuilder();
        for(int i = 0; i < N; i++) {
            word1Str.append(word1[i]);
        }
        String StringOne = word1Str.toString();
        System.out.println(StringOne);

        int M = word2.length;
        StringBuilder word2Str = new StringBuilder();
        for(int i = 0; i < M; i++) {
            word2Str.append(word2[i]);
        }
        String StringTwo = word2Str.toString();
        System.out.println(StringTwo);

        boolean result = StringOne.equals(StringTwo);
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {
        checkTwoStringsAreEquivalent ct = new checkTwoStringsAreEquivalent();
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bcd"};

        ct.arrayStringsAreEqual(word1, word2);
    }
}
