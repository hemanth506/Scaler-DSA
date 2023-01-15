import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class findPathInDirectedGraph {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        int N = B.size();
        for(int i = 0; i < N; i++) {
            int key = B.get(i).get(0);
            int val = B.get(i).get(1);
            if(hm.containsKey(key)) {
                ArrayList<Integer> arr = hm.get(key);
                arr.add(val);
                hm.put(key, arr);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(val);
                hm.put(key, arr);
            }
        }
        System.out.println(hm);
        HashSet<Integer> hs = new HashSet<Integer>();

        Queue<Integer> que = new LinkedList<Integer>();
        que.add(1);
        hs.add(1);
        while (!que.isEmpty()) {
            int curQueueVal = que.poll();
            ArrayList<Integer> lst = hm.get(curQueueVal);
            System.out.println(lst);
            if(lst != null) {
                int M = lst.size();
                for(int i = 0; i < M; i++) {
                    if(!hs.contains(lst.get(i))) {
                        que.add(lst.get(i));
                        hs.add(lst.get(i));
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(exist));
        System.out.println(hs);
        int res = hs.contains(A) ? 1: 0;
        System.out.println(res);
        return res;
    }
    public static void main(String[] args) {
        findPathInDirectedGraph fd = new findPathInDirectedGraph();

        int A = 5;
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        B.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        B.add(new ArrayList<Integer>(Arrays.asList(4, 1)));
        B.add(new ArrayList<Integer>(Arrays.asList(2, 4)));
        B.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
        B.add(new ArrayList<Integer>(Arrays.asList(5, 2)));
        B.add(new ArrayList<Integer>(Arrays.asList(1, 3)));

        // int A = 5;
        // ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        // B.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        // B.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        // B.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
        // B.add(new ArrayList<Integer>(Arrays.asList(4, 5)));

        fd.solve(A, B);
    }
}
