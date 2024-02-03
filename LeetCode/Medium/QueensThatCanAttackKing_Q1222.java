import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class QueensThatCanAttackKing_Q1222 {
  List<List<Integer>> result = new ArrayList<>();
  HashSet<String> queensHs = new HashSet<>();

  private void fourCross(int kx, int ky, int N) {
    for(int i = kx+1; i < N; i++) {
      String indStr = i + "_" + ky;
      System.out.println(indStr);
      if(queensHs.contains(indStr)) {
        result.add(new ArrayList<>(Arrays.asList(i,ky)));
        break;
      }
    }

    System.out.println("=================");
    for(int i = ky+1; i < N; i++) {
      String indStr = kx + "_" + i;
      System.out.println(indStr);
      if(queensHs.contains(indStr)) {
        result.add(new ArrayList<>(Arrays.asList(kx, i)));
        break;
      }
    }

    System.out.println("=================");

    for(int i = kx-1; i >= 0; i--) {
      String indStr = i + "_" + ky;
      System.out.println(indStr);
      if(queensHs.contains(indStr)) {
        result.add(new ArrayList<>(Arrays.asList(i, ky)));
        break;
      }
    }

    System.out.println("=================");
    for(int i = ky-1; i >= 0; i--) {
      String indStr = kx + "_" + i;
      System.out.println(indStr);
      if(queensHs.contains(indStr)) {
        result.add(new ArrayList<>(Arrays.asList(kx, i)));
        break;
      }
    }

  }

  private void fourDiagonal(int kx, int ky, int N) {
    int p1 = kx+1;
    int p2 = ky+1;
    while(p1 < N || p2 < N) {
      String indStr = p1 + "_" + p2;
      System.out.println(indStr);
      if(queensHs.contains(indStr)) {
        result.add(new ArrayList<>(Arrays.asList(p1, p2)));
        break;
      }
      p1++;
      p2++;
    }

    System.out.println("=================");
  
    p1 = kx-1;
    p2 = ky-1;
    while(p1 >= 0 || p2 >= 0) {
      String indStr = p1 + "_" + p2;
      System.out.println(indStr);
      if(queensHs.contains(indStr)) {
        result.add(new ArrayList<>(Arrays.asList(p1, p2)));
        break;
      }
      p1--;
      p2--;
    }

    System.out.println("=================");


    p1 = kx-1;
    p2 = ky+1;
    while(p1 >= 0 && p2 < N) {
      String indStr = p1 + "_" + p2;
      System.out.println(indStr);
      if(queensHs.contains(indStr)) {
        result.add(new ArrayList<>(Arrays.asList(p1, p2)));
        break;
      }
      p1--;
      p2++;
    }

    System.out.println("=================");

    p1 = kx+1;
    p2 = ky-1;
    while(p1 < N && p2 >= 0) {
      String indStr = p1 + "_" + p2;
      System.out.println(indStr);
      if(queensHs.contains(indStr)) {
        result.add(new ArrayList<>(Arrays.asList(p1, p2)));
        break;
      }
      p1++;
      p2--;
    }
    System.out.println("=================");
  }

  public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
    int N = 8;
    int kx = king[0];
    int ky = king[1];

    for(int i = 0; i < queens.length; i++) {
      queensHs.add(queens[i][0] + "_" + queens[i][1]);
    }

    System.out.println(queensHs);

    fourCross(kx, ky, N);
    System.out.println("======Diagonal===========");
    fourDiagonal(kx, ky, N);

    System.out.println(result);
    
    return result;
  }
  

  public static void main(String[] args) {
    QueensThatCanAttackKing_Q1222 qw = new QueensThatCanAttackKing_Q1222();
    int[][] queens = { { 0, 1 }, { 1, 0 }, { 4, 0 }, { 0, 4 }, { 3,3 }, { 2, 4 } };
    int[] king = { 4,4 };
    qw.queensAttacktheKing(queens, king);
  }
}
