import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class batches {
    public int solve(int A, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C, int D) {
        int N = C.size();
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for(int i = 0; i < N; i++) {
            int src = C.get(i).get(0);
            int dest = C.get(i).get(1);

            ArrayList<Integer> arrSrc;
            if(hm.containsKey(src)) {
                arrSrc = hm.get(src);
                arrSrc.add(dest);
            } else {
                arrSrc = new ArrayList<>();
                arrSrc.add(dest);
            }
            hm.put(src, arrSrc);

            ArrayList<Integer> arrDest;
            if(hm.containsKey(dest)) {
                arrDest = hm.get(dest);
                arrDest.add(src);
            } else {
                arrDest = new ArrayList<>();
                arrDest.add(src);
            }
            hm.put(dest, arrDest);

        }

        System.out.println(hm);
        boolean[] visited = new boolean[A+1];
        Arrays.fill(visited, false);
        System.out.println(Arrays.toString(visited));

        Queue<Integer> que = new LinkedList<Integer>();
        HashMap<Integer, Integer> hms = new HashMap<>();
        for(int i = 1; i < A+1; i++) {
            int totalCost = 0;
            if(!visited[i]) {
                // System.out.println("Hemanth");
                que.add(i);

                while(!que.isEmpty()) {
                    int curVal = que.poll();
                    if(hm.containsKey(curVal)) {
                        ArrayList<Integer> curArr = hm.get(curVal);
                        int QN = curArr.size();
                        for(int k = 0; k < QN; k++) {
                            int cur = curArr.get(k);
                            if(!visited[cur]) {
                                que.add(cur);
                                visited[cur] = true;
                                totalCost += B.get(cur-1);
                            } 
                        }
                    } else {
                        visited[i] = true;
                        totalCost += B.get(i-1);
                    }
                }
                hms.put(i, totalCost);
            }
        }
        System.out.println(Arrays.toString(visited));
        System.out.println(hms);

        int ct = 0;
        for(Map.Entry<Integer, Integer> arr: hms.entrySet()) {
            if(arr.getValue() >= D) {
                ct += 1;
            }
        }
        System.out.println(ct);
        return ct;
    }
    public static void main(String[] args) {
        batches bt = new batches();

        // int A = 7;
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1, 6, 7, 2, 9, 4, 5));
        // ArrayList<ArrayList<Integer>> C = new ArrayList<>();
        // C.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        // C.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        // C.add(new ArrayList<Integer>(Arrays.asList(5, 6)));
        // C.add(new ArrayList<Integer>(Arrays.asList(5, 7)));
        // int D = 12;


        int A = 5;
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<ArrayList<Integer>> C = new ArrayList<>();
        C.add(new ArrayList<Integer>(Arrays.asList(1, 5)));
        C.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        int D = 6;

        bt.solve(A, B, C, D);
    }
}
