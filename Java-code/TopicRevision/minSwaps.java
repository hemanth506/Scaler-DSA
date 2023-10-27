import java.util.ArrayList;
import java.util.Arrays;

public class minSwaps {

  //  wrong approach
  public int solveWrong(ArrayList<Integer> A, int B) {
    int N = A.size();

    int resetVal = 0;
    int maxConsecutive = Integer.MIN_VALUE;
    int totalValLessThatB = 0;
    for (int i = 0; i < N; i++) {

      if (A.get(i) <= B) {
        resetVal++;
        maxConsecutive = Integer.max(maxConsecutive, resetVal);
        totalValLessThatB++;
      } else {
        resetVal = 0;
      }
    }
    System.out.println(maxConsecutive + " " + totalValLessThatB + " " + (totalValLessThatB - maxConsecutive));
    return totalValLessThatB - maxConsecutive;
  }

  public int solve(ArrayList<Integer> A, int B) {

    int N = A.size();
    int ct = 0;
    for (int index = 0; index < N; index++) {
      if(A.get(index) > B) {
        A.set(index, 0);
      } else {
        A.set(index, 1);
        ct++;
      }
    }

    System.out.println(A);

    int sumVal = 0;
    for (int i = 0; i < ct; i++) {
      sumVal += A.get(i);
    }
    System.out.println(sumVal);

    int l = 1;
    int r = ct;
    int ans = sumVal;
    while (r < N) {
      sumVal = sumVal - A.get(l-1) + A.get(r);
      System.out.println("sumVal = "+ sumVal);
      ans = Integer.max(ans, sumVal);
      l++;
      r++;
    }
    System.out.println(ans + " " + (ct-ans));
    return ct-ans;
  }

  public static void main(String[] args) {
    minSwaps ms = new minSwaps();
    // ArrayList<Integer> A = new ArrayList<>(Arrays.asList(5, 17, 100, 11));
    // int B = 20;
    // ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 12, 10, 3, 14, 10, 5));
    // int B = 8;

    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(52,7,93,47,68,26,51,44,5,41,88,19,78,38,17,13,24,74,92,5,84,27,48,49,37,59,3,56,79,26,55,60,16,83,63,40,55,9,96,29,7,22,27,74,78,38,11,65,29,52,36,21,94,46,52,47,87,33,87,70));
    int B = 19;
    ms.solve(A, B);
  }
}
