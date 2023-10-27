import java.util.ArrayList;
import java.util.Arrays;

public class matrixMultiplication {

  public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
    int N = A.size();
    int M = A.get(0).size();
    int P = B.get(0).size();

    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    for(int i = 0; i < N; i++) {
      System.out.println("i = " + i);
      ArrayList<Integer> innerArr = new ArrayList<>();
      for(int j = 0; j < P; j++) {
        int val = 0;
        System.out.println("j = " + j);
        for(int k = 0; k < M; k++) {
          System.out.println(i+","+k + " || " + k+","+j);
          int mulVal = A.get(i).get(k) * B.get(k).get(j);
          val += mulVal;
        }
        innerArr.add(val);
        System.out.println("-----------------");
      }
      arr.add(innerArr);
      System.out.println("==============");
    }
    System.out.println(arr);
    return arr;
  }
  public static void main(String[] args) {
    matrixMultiplication mm = new matrixMultiplication();
    ArrayList<ArrayList<Integer>> A = new ArrayList<>();
    A.add(new ArrayList<>(Arrays.asList(1,2)));
    A.add(new ArrayList<>(Arrays.asList(3,4)));

    ArrayList<ArrayList<Integer>> B = new ArrayList<>();
    B.add(new ArrayList<>(Arrays.asList(5,6)));
    B.add(new ArrayList<>(Arrays.asList(7,8)));

    mm.solve(A, B);
  }
}
