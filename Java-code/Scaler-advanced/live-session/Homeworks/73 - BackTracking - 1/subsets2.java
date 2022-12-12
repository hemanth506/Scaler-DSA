import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class subsets2 {
    ArrayList<ArrayList<Integer>> finRes = new ArrayList<ArrayList<Integer>>();
    HashSet<String> hs = new HashSet<String>();
    public String arrToStr(ArrayList<Integer> res) {
        String finStr = res.get(0) + "";
        for(int i = 1; i < res.size(); i++) {
            finStr += "_" + res.get(i);
        }
        return finStr;
    }
    public void getSubSets(ArrayList<Integer> res, ArrayList<Integer> A, int i, int N) {
        if(i == N) {
            System.out.println("return");
            return;
        }

        res.add(A.get(i));
        System.out.println("add = " + A.get(i) + " " + res);
        String finStr = arrToStr(res);
        if(!hs.contains(finStr)) {
            hs.add(finStr);
            finRes.add(new ArrayList<>(res));
        }
        getSubSets(res, A, i+1, N);
        System.out.println("remove " + res + " " + i);
        res.remove(A.get(i));
        System.out.println("removed = " + res + " " + i);
        getSubSets(res, A, i+1, N);
    }
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        int N = A.size();
        Collections.sort(A);
        ArrayList<Integer> res = new ArrayList<>();
        finRes.add(res);
        getSubSets(res, A, 0, N);
        System.out.println(finRes);
        return finRes;
    }
    public static void main(String[] args) {
        subsets2 s2 = new subsets2();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,2));
        s2.subsetsWithDup(A);
    }
}
