public class validAnagram {
  public boolean isAnagram(String s, String t) {
    int N = s.length();
    int M = t.length();
    int[] charArr = new int[26];
    int limit = 'a' + 0;

    for(int i = 0; i < N; i++) {
      charArr[s.charAt(i)-limit]++;
    }


    for(int i = 0; i < M; i++) {
      charArr[t.charAt(i)-limit]--;
    }

    for(int i = 0; i < 26; i++) {
      if(charArr[i] != 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    validAnagram va = new validAnagram();
    String s = "anagram";
    String t = "nagaram";
    va.isAnagram(s, t);
  }
}