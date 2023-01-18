import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class biPartite {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int N = B.size();
        int[] colArr = new int[A + 1];

        // Make is as undirected grapg
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int src = B.get(i).get(0);
            int dest = B.get(i).get(1);
            ArrayList<Integer> arr;
            if (hm.containsKey(src)) {
                arr = hm.get(src);
                arr.add(dest);
                hm.put(src, arr);
            } else {
                arr = new ArrayList<>();
                arr.add(dest);
                hm.put(src, arr);
            }

            if(hm.containsKey(dest)) {
                arr = hm.get(dest);
                arr.add(src);
                hm.put(dest, arr);
            } else {
                arr = new ArrayList<>();
                arr.add(src);
                hm.put(dest, arr);
            }
        }
        // System.out.println(hm);

        Queue<Integer> que = new LinkedList<Integer>();
        for(int k = 0; k < A; k++) {
            if(colArr[k] == 0) {
                que.add(k);
                colArr[k] = 1;
                while (!que.isEmpty()) {
                    int delVal = que.poll();
                    // System.out.println("delVal = " + delVal);
                    if (hm.containsKey(delVal)) {
                        int QA = hm.get(delVal).size();
                        ArrayList<Integer> delArr = hm.get(delVal);
                        int cur = 3 - colArr[delVal];
                        for (int i = 0; i < QA; i++) {
                            // System.out.println(colArr[delVal] + " " + colArr[delArr.get(i)]);
                            if (colArr[delArr.get(i)] == 0) {
                                colArr[delArr.get(i)] = cur;
                                que.add(delArr.get(i));
                            } else if (colArr[delVal] == colArr[delArr.get(i)]) {
                                // System.out.println(0);
                                return 0;
                            }
                        }
                    }
                }
            }
        }
        
        // System.out.println(1);
        return 1;
    }

    public static void main(String[] args) {
        biPartite bp = new biPartite();
        // int A = 3;
        // ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        // B.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
        // B.add(new ArrayList<Integer>(Arrays.asList(0, 2)));
        // B.add(new ArrayList<Integer>(Arrays.asList(1, 2)));

        // int A = 9;
        // ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        // B.add(new ArrayList<Integer>(Arrays.asList(2, 5)));
        // B.add(new ArrayList<Integer>(Arrays.asList(6, 7)));
        // B.add(new ArrayList<Integer>(Arrays.asList(4, 8)));
        // B.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        // B.add(new ArrayList<Integer>(Arrays.asList(0, 3)));
        // B.add(new ArrayList<Integer>(Arrays.asList(4, 7)));
        // B.add(new ArrayList<Integer>(Arrays.asList(1, 8)));
        // B.add(new ArrayList<Integer>(Arrays.asList(3, 8)));
        // B.add(new ArrayList<Integer>(Arrays.asList(1, 3)));

        int A = 10;
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<Integer>(Arrays.asList(7, 8)));
        B.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        B.add(new ArrayList<Integer>(Arrays.asList(0, 9)));
        B.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
        B.add(new ArrayList<Integer>(Arrays.asList(6, 7)));
        B.add(new ArrayList<Integer>(Arrays.asList(0, 3)));
        B.add(new ArrayList<Integer>(Arrays.asList(2, 5)));
        B.add(new ArrayList<Integer>(Arrays.asList(3, 8)));
        B.add(new ArrayList<Integer>(Arrays.asList(4, 8)));


        bp.solve(A, B);
    }
}
