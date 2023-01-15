import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class firstDepthFirstSearch {
    public int solve(ArrayList<Integer> A, final int B, final int C) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        int N = A.size();
        for(int i = 0; i < N; i++) {
            int key = A.get(i);
            int val = i+1;
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

        HashSet<Integer> hs = new HashSet<Integer>();

        Queue<Integer> que = new LinkedList<Integer>();
        que.add(C);
        hs.add(C);
        while (!que.isEmpty()) {
            int curQueueVal = que.poll();
            ArrayList<Integer> lst = hm.get(curQueueVal);
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
        System.out.println(hm);
        int res = hs.contains(B) ? 1: 0;
        System.out.println(res);
        return res;
    }
    public static void main(String[] args) {
        firstDepthFirstSearch ff = new firstDepthFirstSearch();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1, 1, 3, 3, 2, 2, 7, 6));
        // int B = 2;
        // int C = 8;
        int B = 9;
        int C = 1;
        ff.solve(A, B, C);
    }
}
