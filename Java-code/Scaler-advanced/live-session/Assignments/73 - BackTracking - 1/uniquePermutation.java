import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class uniquePermutation {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    HashSet<String> hs = new HashSet<String>();
    public void swap(ArrayList<Integer> tempA, int i, int j) {
        int temp = tempA.get(j);
        tempA.set(j, tempA.get(i));
        tempA.set(i, temp);
    }
    public String arrToStr(ArrayList<Integer> A, int N) {
        String finStr = A.get(0) + "";
        for(int i = 1; i < N; i++) {
            finStr += "_" + A.get(i);
        }
        return finStr;
    }

    public void helper (ArrayList<Integer> A, int i, int N) {
        if(i == N) {
            String finStr = arrToStr(A, N);
            if(!hs.contains(finStr)) {
                hs.add(finStr);
                res.add(new ArrayList<>(A));
            }
            return;
        }

        for(int j = i; j < N; j++) {
            swap(A, i, j);
            helper(A, i+1, N);
            swap(A, i, j);
        }
    }
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        int N = A.size();
        helper(A, 0, N);
        System.out.println(res);
        return res;
    }
    public static void main(String[] args) {
        uniquePermutation up = new uniquePermutation();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,1,2));
        up.permute(A);
    }    
}
