
import java.util.ArrayList;
import java.util.Arrays;

public class beggarsOutsideTemple {
    // TLE solution
    public ArrayList<Integer> solveBruteForce(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> intArr = new ArrayList<Integer>();
        for (int i = 0; i < A; i++) {
            intArr.add(0);
        }
        // System.out.println(intArr);

        for (int i = 0; i < B.size(); i++) {
            ArrayList<Integer> innerB = B.get(i);
            int l = innerB.get(0);
            int r = innerB.get(1);
            int p = innerB.get(2);

            for (int j = l-1; j < r; j++) {
                int element = intArr.get(j) + p;
                intArr.set(j, element);
            }
        }
        System.out.println(intArr);
        return intArr;
    }

    // working solution:
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        int[] intArr = new int[A];
        
        for (int i = 0; i < B.size(); i++) {
            ArrayList<Integer> innerB = B.get(i);
            int l = innerB.get(0) - 1;
            int r = innerB.get(1);
            int p = innerB.get(2);
            System.out.println(l + " " + r);

            int value = intArr[l] + p;
            intArr[l] = value;

            if (r < A) {
                int minValue = intArr[r] - p;
                intArr[r] = minValue;
            }
        }
        System.out.println(Arrays.toString(intArr));

        ArrayList<Integer> PrefixIntArr = new ArrayList<Integer>();
        PrefixIntArr.add(0, intArr[0]);
        for(int i = 1; i < intArr.length; i++) {
            PrefixIntArr.add(i, PrefixIntArr.get(i - 1) + intArr[i]);
        }
        System.out.println(PrefixIntArr);
        return PrefixIntArr;
    }

    public static void main(String[] args) {
        beggarsOutsideTemple bg = new beggarsOutsideTemple();
        int A = 5;
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        B.add(new ArrayList<Integer>(Arrays.asList(1, 2, 10)));
        B.add(new ArrayList<Integer>(Arrays.asList(2, 3, 20)));
        B.add(new ArrayList<Integer>(Arrays.asList(2, 5, 25)));
        
        bg.solveBruteForce(A, B);
        System.out.println("=========================");
        bg.solve(A, B);

    }
}
