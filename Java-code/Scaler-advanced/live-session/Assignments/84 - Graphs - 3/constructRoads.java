import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class constructRoads {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int N = B.size();
        int edges = B.size();
        int mod = 1000000007;
        if (N == 0) {
            return 0;
        }
        int[] colArr = new int[A + 1]; // "0" means no color
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int src = B.get(i).get(0);
            int dest = B.get(i).get(1);
            ArrayList<Integer> arr;
            if (hm.containsKey(src)) {
                arr = hm.get(src);
                arr.add(dest);
            } else {
                arr = new ArrayList<>();
                arr.add(dest);
            }
            hm.put(src, arr);

            if (hm.containsKey(dest)) {
                arr = hm.get(dest);
                arr.add(src);
            } else {
                arr = new ArrayList<>();
                arr.add(src);
            }
            hm.put(dest, arr);
        }
        System.out.println(hm);

        Queue<Integer> que = new LinkedList<Integer>();
        for (int k = 1; k <= A; k++) {
            if (colArr[k] == 0) {
                que.add(k);
                colArr[k] = 1; // "1" means Green color and "2" means Blue color
                while (!que.isEmpty()) {
                    int curVal = que.poll();
                    int QN = hm.get(curVal).size();
                    int curCol = 3 - colArr[curVal];
                    ArrayList<Integer> curArr = hm.get(curVal);
                    for (int i = 0; i < QN; i++) {
                        if (colArr[curArr.get(i)] == 0) {
                            colArr[curArr.get(i)] = curCol;
                            que.add(curArr.get(i));
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(colArr));

        int one = 0;
        int two = 0;
        for (int i = 1; i <= A; i++) {
            if (colArr[i] == 1) {
                one += 1;
            } else if (colArr[i] == 2) {
                two += 1;
            }
        }

        int mul = (one%mod * two%mod)%mod;
        int val = (mul%mod - edges%mod)%mod;
        System.out.println(val);

        return val;
    }

    public static void main(String[] args) {
        constructRoads cr = new constructRoads();
        // int A = 5;
        // ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        // B.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
        // B.add(new ArrayList<Integer>(Arrays.asList(1, 4)));
        // B.add(new ArrayList<Integer>(Arrays.asList(3, 2)));
        // B.add(new ArrayList<Integer>(Arrays.asList(3, 5)));

        int A = 3;
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        B.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        B.add(new ArrayList<Integer>(Arrays.asList(1, 3)));
        cr.solve(A, B);
    }
}
