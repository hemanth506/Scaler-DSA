import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class sortByCost implements Comparator<ArrayList<Integer>> {

    @Override
    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
        if(o1.get(2) > o2.get(2)) {
            return 1;
        } else if (o1.get(2) < o2.get(2)) {
            return -1;
        }
        return 0;
    }

}
public class commutableIslands {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int E = B.size();
        Collections.sort(B, new sortByCost());
        System.out.println(B);

        int comp[] = new int[A+1];
        for(int i = 0; i < A+1; i++) {
            comp[i] = i;
        }

        int totalCost = 0;
        for(int i = 0; i < E; i++) {
            int src = B.get(i).get(0);
            int dest = B.get(i).get(1);
            int cost = B.get(i).get(2);

            int srcN = find(src, comp);
            int destN = find(dest, comp);

            if(srcN != destN) {
                totalCost += cost;
                comp[Integer.max(srcN, destN)] = Integer.min(srcN, destN);
            }

        }
        System.out.println(totalCost);
        return totalCost;
    }
    private int find(int src, int[] comp) {
        if(src == comp[src]) {
            return src;
        }
        comp[src] = find(comp[src], comp);
        return comp[src];
    }
    public static void main(String[] args) {
        commutableIslands ci = new commutableIslands();
        int A = 4;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<Integer>(Arrays.asList(1, 2, 1)));
        B.add(new ArrayList<Integer>(Arrays.asList(2, 3, 4)));
        B.add(new ArrayList<Integer>(Arrays.asList(1, 4, 3)));
        B.add(new ArrayList<Integer>(Arrays.asList(4, 3, 2)));
        B.add(new ArrayList<Integer>(Arrays.asList(1, 3, 10)));

        ci.solve(A, B);
    }
}
