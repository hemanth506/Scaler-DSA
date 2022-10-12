import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class unique2dPoints {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        HashSet<String> hs = new HashSet<String>();
        for(int i = 0; i < N; i++) {
            String joinedString = String.valueOf(A.get(i).get(0)) + "|" + String.valueOf(A.get(i).get(1));
            hs.add(joinedString);
        }
        System.out.println(hs.size());
        return hs.size();
    }
    public static void main(String[] args) {
        unique2dPoints u2d = new unique2dPoints();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(new ArrayList<Integer>(Arrays.asList(5, 6)));
        A.add(new ArrayList<Integer>(Arrays.asList(2, 8)));
        A.add(new ArrayList<Integer>(Arrays.asList(-1, -1)));
        A.add(new ArrayList<Integer>(Arrays.asList(2, -3)));
        A.add(new ArrayList<Integer>(Arrays.asList(2, 8)));
        A.add(new ArrayList<Integer>(Arrays.asList(7, 7)));
        A.add(new ArrayList<Integer>(Arrays.asList(2, -3)));


        u2d.solve(A);
    }
}
