import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class shaggyAndDistances {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for(int i = 0; i < N; i++) {
            if(hm.containsKey(A.get(i))) {
                ArrayList<Integer> arrSet = hm.get(A.get(i));
                arrSet.add(i);
                hm.put(A.get(i), arrSet);
            } else {
                ArrayList<Integer> arrAdd = new ArrayList<Integer>();
                arrAdd.add(i);
                hm.put(A.get(i), arrAdd);
            }
        }
        System.out.println(hm);
        int minVal = Integer.MAX_VALUE;
        boolean existPair = false;
        for(Map.Entry<Integer, ArrayList<Integer>> mapEntry : hm.entrySet()) {
            if(mapEntry.getValue().size() > 1) {
                int i = mapEntry.getValue().get(0);
                int j = mapEntry.getValue().get(1);

                minVal = Integer.min(minVal, Math.abs(i - j));
                existPair = true;
            }
        }

        System.out.println(minVal);
        return existPair ? minVal : -1;
    }
    public static void main(String[] args) {
        shaggyAndDistances sd = new shaggyAndDistances();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(7, 1, 3, 4, 1, 7));
        sd.solve(A);
    }
}
