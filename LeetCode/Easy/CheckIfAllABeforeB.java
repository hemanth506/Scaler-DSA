public class CheckIfAllABeforeB {
  public boolean checkString(String s) {
    int N = s.length();

    for(int i = 1; i < N; i++) {
      if(s.charAt(i) == 'a' && s.charAt(i-1) == 'b') {
        System.out.println("false");
        return false;
      }
    }

    System.out.println("true");
    return true;
  }

  public static void main(String[] args) {
    CheckIfAllABeforeB ci = new CheckIfAllABeforeB();
    String S = "aaaa";
    ci.checkString(S);
  }
}
