
public class CapitalizeTheTitle_Q2129 {
  public String capitalizeTitle(String title) {
    int N = title.length();
    String[] strSb = new String[N];

    int j = 0;
    int i;
    for (i = 0; i < N; i++) {
      char curChar = title.charAt(i);
      String curStr = (curChar + "").toLowerCase();

      if (curChar == ' ') {
        if (i - j > 2) {
          strSb[j] = (title.charAt(j) + "").toUpperCase();
        }
        j = i + 1;
      }
      strSb[i] = curStr;
    }

    if (i - j > 2) {
      strSb[j] = (title.charAt(j) + "").toUpperCase();
    }

    String result = String.join("", strSb);
    return result;
  }

  public static void main(String[] args) {
    CapitalizeTheTitle_Q2129 cp = new CapitalizeTheTitle_Q2129();
    String title = "capiTalIze tHe titLe TH";
    cp.capitalizeTitle(title);
  }
}