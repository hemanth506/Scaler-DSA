public class AddingSpacesToString {

  public String addSpaces(String s, int[] spaces) {
    int M = spaces.length;
    if(M == 0) {
      return s;
    }
    int N = s.length();
    StringBuilder sb = new StringBuilder();

    int j = 0;
    for(int i = 0; i < N; i++) {
      if(j < M && spaces[j] == i) {
        sb.append(" ");
        sb.append(s.charAt(i));
        j++;

      } else {
        sb.append(s.charAt(i));
      }
    }
    System.out.println(sb);
    return sb.toString();     
  }
  public static void main(String[] args) {
    AddingSpacesToString as = new AddingSpacesToString();
    String s = "LeetcodeHelpsMeLearn";
    int[] spaces = new int[]{8,13,15};
    as.addSpaces(s, spaces);
  }
}
