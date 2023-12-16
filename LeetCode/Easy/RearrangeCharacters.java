import java.util.Arrays;

public class RearrangeCharacters {
  public int rearrangeCharacters(String s, String target) {
    int N = s.length();
    int M = target.length();
    int[] sArr = new int[26];
    int[] targetArr = new int[26];

    int limit = 'a' + 0;
    System.out.println(limit);
    for (int i = 0; i < N; i++) {
      sArr[s.charAt(i) - limit]++;
    }

    for (int i = 0; i < M; i++) {
      targetArr[target.charAt(i) - limit]++;
    }

    System.out.println(Arrays.toString(sArr));
    System.out.println(Arrays.toString(targetArr));

    int minVal = Integer.MAX_VALUE;
    for(int i = 0; i < 26; i++) {
      if(targetArr[i] != 0) {
        minVal = Integer.min(minVal, sArr[i] / targetArr[i]);
      }
    }

    System.out.println(minVal);

    return minVal;
  }

  public static void main(String[] args) {
    RearrangeCharacters rc = new RearrangeCharacters();
    // String s = "ilovecodingonleetcode";
    // String target = "code";

    // String s = "abcba";
    // String target = "abc";

    String s = "abbaccaddaeea";
    String target = "aaaaa";

    rc.rearrangeCharacters(s, target);
  }
}
