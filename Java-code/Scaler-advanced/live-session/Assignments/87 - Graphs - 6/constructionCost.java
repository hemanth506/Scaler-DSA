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
public class constructionCost {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int E = B.size();
        int mod = 1000000007;
        Collections.sort(B, new sortByCost());
        int[] comp = new int[A+1];
        for(int i = 0; i < A; i++) {
            comp[i] = i;
        }

        long minCost = 0;
        for(int i = 0; i < E; i++) {
            int src = B.get(i).get(0);
            int dest = B.get(i).get(1);
            int cost = B.get(i).get(2);

            int srcNode = find(src, comp);
            int destNode = find(dest, comp);

            if(srcNode != destNode) {
                minCost = (minCost%mod + cost%mod)%mod;
                comp[Integer.max(srcNode, destNode)] = Integer.min(srcNode, destNode);
            }
        }
        System.out.println(minCost);
        return (int) minCost%mod;
    }
    
    private int find(int src, int[] comp) {
        if (src == comp[src]) {
            return src;
        }
        comp[src] = find(comp[src], comp);
        return comp[src];
    }

    public static void main(String[] args) {
        constructionCost cc = new constructionCost();
        int A = 3;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<Integer>(Arrays.asList(1, 2, 14)));
        B.add(new ArrayList<Integer>(Arrays.asList(2, 3, 7)));
        B.add(new ArrayList<Integer>(Arrays.asList(3, 1, 2)));

        cc.solve(A, B);
    }
}
