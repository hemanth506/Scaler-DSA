import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<>();
    triangle.add(new ArrayList<>(Arrays.asList(1)));
    if (numRows == 1) {
      return triangle;
    }

    int i = 1;
    while (i < numRows) {
      List<Integer> arr = triangle.get(i-1);
      int M = arr.size();
      List<Integer> newArr = new ArrayList<>();
      newArr.add(1);
      for(int j = 0; j < M-1; j++) {
        int val = arr.get(j) + arr.get(j+1);
        newArr.add(val);
      }
      newArr.add(1);
      triangle.add(newArr);
      i++;
    }
    System.out.println(triangle);
    return triangle;
  }

  public static void main(String[] args) {
    PascalTriangle pt = new PascalTriangle();
    pt.generate(5);
  }
}
