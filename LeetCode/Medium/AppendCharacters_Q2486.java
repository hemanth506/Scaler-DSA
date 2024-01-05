public class AppendCharacters_Q2486 {
  public int appendCharacters(String s, String t) {
    int N = s.length();
    int M = t.length();

    int subSeqLen = 0;
    int i = 0, j = 0;
    while (i < N && j < M) {
      if (t.charAt(j) == s.charAt(i)) {
        subSeqLen++;
        i++;
        j++;
      } else {
        i++;
      }
    }

    int remainingLen = M - subSeqLen;
    return remainingLen;
  }

  public static void main(String[] args) {
    // String s = "coaching", t = "coding";
    // String s = "abcde", t = "a";
    String s = "z", t = "abcde";
    // String s = "vrykt", t = "rkge";

    AppendCharacters_Q2486 ap = new AppendCharacters_Q2486();
    ap.appendCharacters(s, t);
  }
}
