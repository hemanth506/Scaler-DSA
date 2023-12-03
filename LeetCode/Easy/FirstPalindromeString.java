public class FirstPalindromeString {
  public String firstPalindrome(String[] words) {
    int N = words.length;

    for(int i = 0; i < N; i++) {
      if(isPalondrome(words[i])) {
        return words[i];
      }
    }
    return "";
  }

  private boolean isPalondrome(String string) {
    int M = string.length();
    int p1 = 0;
    int p2 = M-1;

    while (p1 < p2) {
      if(string.charAt(p1) != string.charAt(p2)) {
        return false;
      }
      p1++;
      p2--;
    }
    return true;
  }
  public static void main(String[] args) {
    FirstPalindromeString fp = new FirstPalindromeString();
    String[] words = new String[]{"abc","car","ada","racecar","cool"};
    fp.firstPalindrome(words);
  }
}
