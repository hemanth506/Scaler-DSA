import java.util.ArrayList;
import java.util.Arrays;

public class permutations {

    public void swap(ArrayList<Integer> tempA, int i, int j) {
        int temp = tempA.get(j);
        tempA.set(j, tempA.get(i));
        tempA.set(i, temp);
    }
    
    public ArrayList<ArrayList<Integer>> helper(ArrayList<Integer> tempA, int i, int N, ArrayList<ArrayList<Integer>> result) {
        if(i == N) {
            // System.out.println("return " + tempA);
            result.add(new ArrayList<>(tempA));
            return result;
        }

        for(int j = i; j < N; j++) {
            swap(tempA, i, j); // swap
            helper(tempA, i+1, N, result);
            swap(tempA, i, j); // undo swap
        }

        return result;
    }
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        int N = A.size();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result = helper(A, 0, N, result);
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {
        permutations pt = new permutations();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3)); 
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1, 3)); 
        
        pt.permute(A);
    }
}
