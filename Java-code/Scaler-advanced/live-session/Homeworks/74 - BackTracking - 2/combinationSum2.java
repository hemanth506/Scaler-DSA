import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class combinationSum2 {
    int total = 0;
    ArrayList<ArrayList<Integer>> finArr = new ArrayList<>();
    public String convertToString (ArrayList<Integer> arr) {
        StringBuilder sb = new StringBuilder();
        sb.append(arr.get(0));
        for(int i = 1; i < arr.size(); i++) {
            sb.append('_');
            sb.append(arr.get(i));
        }
        return sb.toString();
    }

    HashSet<String> hs = new HashSet<>();
    public void generateCombinations(ArrayList<Integer> A, int B, int N, int i, ArrayList<Integer> arr) {
        if (i == N) {
            return;
        }

        arr.add(A.get(i));
        total += A.get(i);
        if (total == B) {
            ArrayList<Integer> tempArr = new ArrayList<Integer>(arr);
            String strg = convertToString(arr); 
            if(!hs.contains(strg)) {
                finArr.add(tempArr);
                hs.add(strg);
            }
        }
        generateCombinations(A, B, N, i + 1, arr);
        int len = arr.size();
        arr.remove(len - 1);
        total -= A.get(i);
        generateCombinations(A, B, N, i + 1, arr);
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        int N = A.size();
        Collections.sort(A);
        System.out.println(A);
        ArrayList<Integer> arr = new ArrayList<>();
        generateCombinations(A, B, N, 0, arr);
        System.out.println(finArr);
        return finArr;
    }

    public static void main(String[] args) {
        combinationSum2 cs = new combinationSum2();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(10, 1, 2, 7, 6, 1, 5));
        // int B = 8;


        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 1, 3));
        int B = 3;
        cs.combinationSum(A, B);
    }
}
