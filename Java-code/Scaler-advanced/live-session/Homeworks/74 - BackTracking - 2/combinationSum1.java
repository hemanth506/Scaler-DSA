import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class combinationSum1 {
    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    HashSet<String> hs = new HashSet<String>();

    public String arrToString(ArrayList<Integer> list) {
        System.out.println("check");
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for(int k = 1; k < list.size(); k++) {
            sb.append('_');
            sb.append(list.get(k));
        }
        return sb.toString();
    }
    public void getCombination(ArrayList<Integer> A, int B, int i, int N, ArrayList<Integer> list) {
        System.out.println("Hemanth i = " + i + " B = " + B + " list = " + list);
        if(B == 0) {
            System.out.println("final = " + list);
            ArrayList<Integer> tempArr = new ArrayList<Integer>(list);
            String str = arrToString(list);
            if(!hs.contains(str)) {
                arr.add(tempArr);
                hs.add(str);
                System.out.println(arr);
            }
            return;
        }
        
        if(i == N || A.get(i) > B) {
            System.out.println("return");
            return;
        }
        
        getCombination(A, B, i+1, N, list);
        System.out.println("i = " + i);
        list.add(A.get(i));
        getCombination(A, B-A.get(i), i, N, list);
        int ln = list.size();
        list.remove(ln-1);
    }
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        int N = A.size();
        Collections.sort(A);
        ArrayList<Integer> list = new ArrayList<>();
        getCombination(A, B, 0, N, list);
        Collections.reverse(arr);
        System.out.println(arr);
        return arr;
    }
    
    public static void main(String[] args) {
        combinationSum1 cs1 = new combinationSum1();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 3, 6, 7));
        // int B = 7;

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 3));
        // int B = 2;

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(8, 10, 6, 11, 1, 16, 8));
        int B = 28;

        cs1.combinationSum(A, B);
    }
}
