import java.util.Arrays;

public class LargestNumberAfterDigitSwapping {
  public int largestInteger(int num) {
    String str = Integer.toString(num);
    char[] digits = str.toCharArray();
    int N = digits.length;

    for (int i = 0; i < N; i++) {
      int baseInt = Character.getNumericValue(digits[i]);
      boolean isBaseEven = baseInt % 2 == 0;
      int index = -1;
      int curMax = baseInt;
      for (int j = i + 1; j < N; j++) {
        int curInt = Character.getNumericValue(digits[j]);
        boolean isCurEven = curInt % 2 == 0;
        
        if(isBaseEven == isCurEven) {
          if(curMax < curInt) {
            curMax = curInt;
            index = j;
          }
        }
      }

      if(index != -1) {
        // swap i and index of string builder
        swap(digits, i, index);
      }
    }

    System.out.println(Arrays.toString(digits));

    int result = 0;
    int prod = 1;
    for(int i = N-1; i >= 0; i--) {
      result = result + (Integer.parseInt(digits[i]+"") * prod);
      prod = prod * 10;
    }

    System.out.println(result);
    return result;
  }

  


  private void swap(char[] digits, int i, int index) {
    char charVal = digits[i];
    digits[i] = digits[index];
    digits[index] = charVal;
  }



  public static void main(String[] args) {
    int nums = 632879415;
    LargestNumberAfterDigitSwapping lg = new LargestNumberAfterDigitSwapping();
    lg.largestInteger(nums);
  }
}
