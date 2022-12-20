import java.util.ArrayList;
import java.util.Arrays;

public class uniquePathInGrid {
    public int totalPaths(ArrayList<ArrayList<Integer>> A, int N, int M, int i, int j) {
        
        if(i >= N || j >= M) {
            System.out.println(i + " " + j + " return");
            return 0;
        }
        if(A.get(i).get(j) == -1) {
            System.out.println(i + " " + j + " one exists ");
            return 0;
        }
        if(i == (N-1) && j == (M-1)) {
            System.out.println(i + " " + j + " add one");
            return 1;
        }
        System.out.println(i + " " + j);
        if(A.get(i).get(j) == 0) {
            int setVal = totalPaths(A, N, M, i+1, j) + totalPaths(A, N, M, i, j+1);
            A.get(i).set(j, setVal);
        }

        return A.get(i).get(j);
    }
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(A.get(i).get(j) == 1) {
                    A.get(i).set(j, -1);
                }
            }
        }
        int total = totalPaths(A, N, M, 0, 0);
        System.out.println(total);
        return total;
    }
    public static void main(String[] args) {
        uniquePathInGrid ug = new uniquePathInGrid();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        // A.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0)));
        // A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1)));
        // A.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0)));

        // A.add(new ArrayList<Integer>(Arrays.asList(0, 1)));

        A.add(new ArrayList<Integer>(Arrays.asList(0, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 0)));



        ug.uniquePathsWithObstacles(A);
    }
}
