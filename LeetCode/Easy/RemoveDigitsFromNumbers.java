public class RemoveDigitsFromNumbers {
  public String removeDigit(String number, char digit) {
    int N = number.length();

    StringBuilder sb = new StringBuilder();
    boolean captured = false;
    int index = 0;

    int i;
    for (i = 0; i < N - 1; i++) {
      String str = number.charAt(i) + "";
      int curNum = Integer.parseInt(str);
      int nextnum = Integer.parseInt(number.charAt(i + 1) + "");
      if (number.charAt(i) == digit) {
        if (curNum < nextnum && !captured) {
          captured = true;
        } else {
          sb.append(number.charAt(i));
        }
        index = i;
      } else {
        sb.append(number.charAt(i));
      }
    }
    
    if(captured) {
      sb.append(number.charAt(i));
    } else {
      if(number.charAt(i) != digit) {
        sb.deleteCharAt(index);
        sb.append(number.charAt(i));
      } 
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    RemoveDigitsFromNumbers rd = new RemoveDigitsFromNumbers();
    // String number = "1231";
    // char digit = '1';

    // String number = "133235";
    // char digit = '3';

    // String number = "551";
    // char digit = '5';

    String number = "123";
    char digit = '3';
    rd.removeDigit(number, digit);
  }
}
