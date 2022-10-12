import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class distinctNumbersInWindows {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        System.out.println(A);
        ArrayList<Integer> dNumbers = new ArrayList<>();
        int N = A.size();
        if(N < B) {
            return dNumbers;
        }

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < B; i++) {
            if(hm.containsKey(A.get(i))) {
                int num = hm.get(A.get(i)) + 1;
                hm.put(A.get(i), num);
            } else {
                hm.put(A.get(i), 1);
            }
        }
        System.out.println(hm);
        dNumbers.add(hm.size());

        // System.out.println(N-B);
        int j = B;
        for(int i = 1; i <= (N-B); i++) {
            int toRemoveId = i - 1;
            int toAddId = j;
            System.out.println(toRemoveId + " " + toAddId);

            // remove part
            System.out.println("hm = " + hm);
            System.out.println(hm.get(A.get(toRemoveId)) + " ====== " + A.get(toRemoveId));
            
            if (hm.get(A.get(toRemoveId)) == 1) {
                hm.remove(A.get(toRemoveId));
            } else {
                int decreaseitem = hm.get(A.get(toRemoveId)) - 1;
                hm.put(A.get(toRemoveId), decreaseitem);
            }

            // add part
            if(hm.containsKey(A.get(toAddId))) {
                int val = hm.get(A.get(toAddId)) + 1;
                hm.put(A.get(toAddId), val);
            } else {
                hm.put(A.get(toAddId), 1);
            }

            dNumbers.add(hm.size());
            System.out.println("dNumbers = " + dNumbers);
            j+=1;
        }

        System.out.println(dNumbers);
        return dNumbers;
    }
    public static void main(String[] args) {
        distinctNumbersInWindows dWind = new distinctNumbersInWindows();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 1, 3, 4, 3));
        // int B = 3;


        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1, 2, 2));
        int B = 1;
        dWind.dNums(A, B);
    }
}
