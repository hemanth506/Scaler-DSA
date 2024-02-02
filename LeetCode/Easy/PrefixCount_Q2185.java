public class PrefixCount_Q2185 {
  public int prefixCount(String[] words, String pref) {
    int N = words.length;

    int count = 0;
    for (int i = 0; i < N; i++) {
      if (isPrefCount(words[i], pref)) {
        count++;
      }
    }

    System.out.println(count);
    return count;
  }

  private boolean isPrefCount(String string, String pref) {
    int N = string.length();
    int M = pref.length();
    if(M > N) {
      return false;
    }

    for(int i = 0; i < M; i++) {
      if(string.charAt(i) != pref.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    PrefixCount_Q2185 pc = new PrefixCount_Q2185();
    // String[] words = { "pay", "attention", "practice", "attend" };
    // String pref = "at";

    String[] words = { "leetcode","win","loops","success" };
    String pref = "code";
    pc.prefixCount(words, pref);
  }
}
