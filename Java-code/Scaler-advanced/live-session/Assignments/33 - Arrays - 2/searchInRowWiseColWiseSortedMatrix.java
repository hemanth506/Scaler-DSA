import java.util.ArrayList;
import java.util.Arrays;

public class searchInRowWiseColWiseSortedMatrix {
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int N = A.size();
        int M = A.get(0).size();

        int minVal = Integer.MAX_VALUE;
        boolean noMatch = false;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A.get(i).get(j) == B){
                    minVal = Integer.min(minVal, (((i+1) * 1009) + (j+1)));
                    noMatch = true;
                }
            }
        }
        System.out.println(minVal);
        return noMatch ? minVal : -1;
    }
    
    public static void main(String[] args) {
        searchInRowWiseColWiseSortedMatrix sr = new searchInRowWiseColWiseSortedMatrix();

        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        A.add(new ArrayList<Integer>(Arrays.asList(4, 5, 6)));
        A.add(new ArrayList<Integer>(Arrays.asList(7, 8, 9)));

        int B = 2;

        sr.solve(A, B);
    }
}
