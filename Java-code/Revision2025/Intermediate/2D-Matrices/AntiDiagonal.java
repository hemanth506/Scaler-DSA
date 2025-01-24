import java.util.ArrayList;
import java.util.Arrays;
public class AntiDiagonal {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
        A.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));
        A.add(new ArrayList<Integer>(Arrays.asList(7,8,9)));

        System.out.println(diagonal(A));
    }


    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        int N = A.get(0).size();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int j = 0; j < N; j++) {
            int i = 0;
            int k = j;
            ArrayList<Integer> diagonal = new ArrayList<>();
            while (i >= 0 && k >= 0) {
                System.out.println("check 1: " + i + ", " + j);
                diagonal.add(A.get(i).get(k));
                i++;
                k--;
            }
            result.add(diagonal);
        }

        for(int i = 1; i < N; i++) {
            int j = N - 1;
            int k = i;
            ArrayList<Integer> diagonal = new ArrayList<>();

            while(k < N && j >= 0) {
                System.out.println("check 2: " + k + ", " + j);
                diagonal.add(A.get(k).get(j));
                k++;
                j--;
            }
            result.add(diagonal);
        }
        
        
        
        System.out.println(result);
        int internalSize = A.get(0).size();
        for(int i = 0; i < result.size(); i++) {
            int M = result.get(i).size();
            System.out.println("M: " + M + ", internalSize: " + internalSize);
            while (M < internalSize) {
                result.get(i).add(0);
                M++;
            }
        }
        System.out.println(result);

        return result;
    }
}
