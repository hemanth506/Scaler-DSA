import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DistinctNumbersinWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        int N = A.size();
        System.out.println(A);
        ArrayList<Integer> finalVal = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>(); 
        for(int i = 0; i < B; i++) {
            if(hm.containsKey(A.get(i))) {
                int value = hm.get(A.get(i)) + 1;
                hm.put(A.get(i), value);
            } else {
                hm.put(A.get(i), 1);
            }
        }

        System.out.println(hm + " " + hm.size());
        finalVal.add(hm.size());

        int endLimit = N - B + 1;
        for (int i = 1; i < endLimit; i++) {
            if (hm.containsKey(A.get(i - 1))) {
                int removableElt = hm.get(A.get(i - 1)) - 1;
                if (removableElt < 1) {
                    System.out.println("removed => " + A.get(i - 1));
                    hm.remove(A.get(i - 1));
                } else {
                    hm.put(A.get(i - 1), removableElt);
                }

            } else {
                hm.put(A.get(i - 1), 1);
            }
            // System.out.println(hm);

            System.out.println("reched");
            if (hm.containsKey(A.get(B))) {
                int value = hm.get(A.get(B)) + 1;
                hm.put(A.get(B), value);
                // System.out.println(A.get(B) + " " + hm.get(A.get(B)) + " " + value);
            } else {
                // System.out.println("new  => " + A.get(B) + " " + hm.get(A.get(B)) + " " + 1);
                hm.put(A.get(B), 1);
            }
            B++;
            System.out.println(hm);

            finalVal.add(hm.size());
            System.out.println("==========");
        }
        System.out.println(finalVal);
        return finalVal;
    }
    public static void main(String[] args) {
        DistinctNumbersinWindow ds = new DistinctNumbersinWindow();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 1, 3, 4, 3));
        // int B = 3;

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(31, 51, 31, 51, 31, 31, 31, 31, 31, 31, 51, 31, 31));
        int B = 3;
        ds.dNums(A, B);
    }
}
