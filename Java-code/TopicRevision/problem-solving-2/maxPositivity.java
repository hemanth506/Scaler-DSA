import java.util.ArrayList;
import java.util.Arrays;

public class maxPositivity {
  public ArrayList<Integer> solve(ArrayList<Integer> A) {
    int N = A.size();

    int maxLen = Integer.MIN_VALUE;
    int startIndex = -1;
    for (int i = 0; i < N; i++) {
      if (A.get(i) < 0 && i > 0) {
        System.out.println("==========" + i + "============");
        int j = i - 1;
        int count = 0;
        while (j >= 0 && A.get(j) >= 0) {
          count++;
          j--;
        }
        if (maxLen < count) {
          maxLen = count;
          startIndex = j + 1;
        }
      }
    }

    int p = N - 1;
    if (A.get(p) >= 0) {
      int j = p;
      int count = 0;
      while (j >= 0 && A.get(j) >= 0) {
        count++;
        j--;
      }
      if (maxLen < count) {
        maxLen = count;
        startIndex = j + 1;
      }
    }

    ArrayList<Integer> ar = new ArrayList<>();
    int k = startIndex;
    int curLen = 0;
    while (curLen < maxLen) {
      ar.add(A.get(k));
      k++;
      curLen++;
    }

    System.out.println(ar);
    return ar;
  }

  public static void main(String[] args) {
    maxPositivity mp = new maxPositivity();
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 5, 6, -1, 7, 8, 9, -2, 7, 9, 9, 8));
    mp.solve(A);
  }
}