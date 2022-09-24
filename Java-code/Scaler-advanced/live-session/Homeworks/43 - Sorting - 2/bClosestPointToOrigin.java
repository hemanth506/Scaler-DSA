import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class bClosestPointToOrigin {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        ArrayList<ArrayList<Integer>> values = new ArrayList<>();
        Collections.sort(A, new minValComaparator());
        System.out.println(A);
        for(int i = 0; i < B; i++) {
            values.add(A.get(i));
        }
        System.out.println(values);
        return values;
    }
    public static void main(String[] args) {
        bClosestPointToOrigin bc = new bClosestPointToOrigin();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
        A.add(new ArrayList<Integer>(Arrays.asList(-2, 2)));
        int B = 1;
        bc.solve(A, B);
    }
}

class minValComaparator implements Comparator<ArrayList<Integer>> {
    @Override
    public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
        int x2 = 0; int y2 = 0;
        int o1x1 = o1.get(0);
        int o1y1 = o1.get(1);
        int o1val = ((o1x1-x2) * (o1x1-x2)) + ((o1y1-y2) * (o1y1-y2));

        int o2x1 = o2.get(0);
        int o2y1 = o2.get(1);
        int o2val = ((o2x1-x2) * (o2x1-x2)) + ((o2y1-y2) * (o2y1-y2));
        System.out.println(o1val  +" " + o2val);
        if(o1val > o2val) {
            // System.out.println("swap");
            return 1;
        } else if (o1val == o2val) {
            return 0;
        } else {
            return -1;
        }
    }
    
}