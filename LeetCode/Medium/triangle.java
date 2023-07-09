import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class triangle {
    int N;
    public int getMinTotal(int i, int j, HashMap<String, Integer> hm, List<List<Integer>> triangle) {
        if(i >= N || j >= triangle.get(i).size()) {
            return 0;
        }

        String str = i + "_" + j;
        if (!hm.containsKey(str)) {
            int curVal = triangle.get(i).get(j);
            int withI = getMinTotal(i + 1, j, hm, triangle) + curVal;
            int withIPlusOne = getMinTotal(i + 1, j + 1, hm, triangle) + curVal;
            hm.put(str, Integer.min(withI, withIPlusOne));
        }
        return hm.get(str);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        N = triangle.size();
        HashMap<String, Integer> hm = new HashMap<>();
        int val = getMinTotal(0, 0, hm, triangle);
        System.out.println(val);
        return val;
    }

    public static void main(String[] args) {
        triangle tr = new triangle();
        List<List<Integer>> trgle = new ArrayList<List<Integer>>();
        trgle.add(new ArrayList<Integer>(Arrays.asList(2)));
        trgle.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
        trgle.add(new ArrayList<Integer>(Arrays.asList(6, 5, 7)));
        trgle.add(new ArrayList<Integer>(Arrays.asList(4, 1, 8, 3)));
        tr.minimumTotal(trgle);
    }
}
