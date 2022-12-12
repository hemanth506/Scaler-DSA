import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class allSubsets {
    ArrayList<ArrayList<Integer>> getList = new ArrayList<ArrayList<Integer>>();
    public void getAllList(ArrayList<Integer> A, int id, int N, ArrayList<Integer> res) {
        if(id == N) {
            System.out.println("return");
            return;
        }

        res.add(A.get(id));
        System.out.println("add = " + A.get(id) + " " + res);
        getList.add(new ArrayList<>(res));
        getAllList(A, id+1, N, res);
        res.remove(A.get(id));
        System.out.println("remove = " + A.get(id) + " " + res);
        getAllList(A, id+1, N, res);
    } 
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        int N = A.size();
        Collections.sort(A);
        ArrayList<Integer> res = new ArrayList<>();
        getList.add(res);
        getAllList(A, 0, N, res);

        System.out.println(getList);
        return getList;   
    }
    public static void main(String[] args) {
        allSubsets as = new allSubsets();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,3));
        as.subsets(A);
    }
}
