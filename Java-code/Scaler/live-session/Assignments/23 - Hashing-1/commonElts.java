import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class commonElts {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int N = A.size();
        int M = B.size();
        System.out.println(A);
        System.out.println(B);

        HashMap<Integer, Integer> hmA = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if(hmA.containsKey(A.get(i))) {
                int value = hmA.get(A.get(i)) + 1;
                hmA.put(A.get(i), value);
            } else {
                hmA.put(A.get(i), 1);
            }
        }
        System.out.println(hmA);

        HashMap<Integer, Integer> hmB = new HashMap<>();
        for (int i = 0; i < M; i++) {
            if(hmB.containsKey(B.get(i))) {
                int value = hmB.get(B.get(i)) + 1;
                hmB.put(B.get(i), value);
            } else {
                hmB.put(B.get(i), 1);
            }
        }
        System.out.println(hmB);

        ArrayList<Integer> finalVal = new ArrayList<>();
        for(HashMap.Entry<Integer,Integer> iterMap : hmA.entrySet()) {
            System.out.println(iterMap.getKey() + " " + iterMap.getValue());
            if (hmB.containsKey(iterMap.getKey())) {
                int hmATimes = iterMap.getValue();
                int hmBTimes = hmB.get(iterMap.getKey());
                int minTimes = Integer.min(hmATimes, hmBTimes);
                System.out.println("minTimes => " + minTimes);
                for (int i = 0; i < minTimes; i++) {
                    finalVal.add(iterMap.getKey());
                }
            }
        }

        System.out.println(finalVal);


        return finalVal;
    }
    public static void main(String args[]) {
        commonElts ce = new commonElts();

        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(2, 3, 1, 2));
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 2, 1));

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 1, 4, 10));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(3, 6, 2, 10, 10));
        ce.solve(A, B);
    }
}
