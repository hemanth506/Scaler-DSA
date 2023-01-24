import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

class Pair {
    int dest;
    int cost;

    Pair(int y, int z) {
        this.dest = y;
        this.cost = z;
    }
}

class customComparator implements Comparator<ArrayList<Integer>> {
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

public class commutableIsland {
    int minVal = Integer.MAX_VALUE;
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int N = B.size();
        Collections.sort(B, new customComparator());
        System.out.println(B);
        HashSet<Integer> hs = new HashSet<>();

        int val = 0;
        for(int i = 0; i < N; i++) {
            int src = B.get(i).get(0);
            int dest = B.get(i).get(1);
            int cost = B.get(i).get(2);
            System.out.println(hs + " " + hs.size() + " " + A);
            // if(hs.size() == A) {
            //     break;
            // }
            if(hs.contains(src) && hs.contains(dest)) {
                continue;
            }
            if(!hs.contains(src) || !hs.contains(dest)) {
                hs.add(src);
                hs.add(dest);
                System.out.println(src + " " + dest + " " + cost);
                val += cost;
            }
        }
        
        System.out.println(val);
        // System.out.println(minVal);
        return A;
    }

    public static void main(String[] args) {
        commutableIsland cs = new commutableIsland();
        int A = 4;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<Integer>(Arrays.asList(1, 2, 1)));
        B.add(new ArrayList<Integer>(Arrays.asList(2, 3, 4)));
        B.add(new ArrayList<Integer>(Arrays.asList(1, 4, 3)));
        B.add(new ArrayList<Integer>(Arrays.asList(4, 3, 2)));
        B.add(new ArrayList<Integer>(Arrays.asList(1, 3, 10)));

        cs.solve(A, B);
    }
}
