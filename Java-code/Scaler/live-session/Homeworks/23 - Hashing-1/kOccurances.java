import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class kOccurances {
    public int getSum(int A, int B, ArrayList<Integer> C) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < A; i++) {
            if (hm.containsKey(C.get(i))) {
                int value = hm.get(C.get(i)) + 1;
                hm.put(C.get(i), value);
            } 
            else {
                hm.put(C.get(i), 1);
            }
        }
        System.out.println(hm);

        long sumHeight = 0;
        boolean hasSum = false;
        for (HashMap.Entry<Integer, Integer> m : hm.entrySet()) {
            if (m.getValue() == B) {
                sumHeight += m.getKey();
                hasSum = true;
            }
        }
        System.out.println(sumHeight);
        sumHeight = sumHeight % 1000000007;
        return hasSum ? (int)sumHeight : -1;
    }
    public static void main(String[] args) {
        kOccurances ko = new kOccurances();
        int A = 5;
        int B = 2;
        ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(1, 2, 2, 3, 3));
        
        
        ko.getSum(A, B, C);
    }
}
