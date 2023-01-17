import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int i;
    int j;

    Pair(int x, int y) {
        this.i = x;
        this.j = y;
    }
}

public class rottenOranges {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();
        Queue<Pair> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A.get(i).get(j) == 2) {
                    System.out.println(i + " " + j);
                    Pair np = new Pair(i, j);
                    que.add(np);
                }
            }
        }

        int ct = 0;
        while (!que.isEmpty()) {
            int QN = que.size();
            for (int x = 0; x < QN; x++) {
                Pair pr = que.poll();
                int i = pr.i;
                int j = pr.j;
                if (i - 1 >= 0 && A.get(i - 1).get(j) == 1) {
                    A.get(i - 1).set(j, 2);
                    que.add(new Pair(i - 1, j));
                }
                if (j - 1 >= 0 && A.get(i).get(j - 1) == 1) {
                    A.get(i).set(j - 1, 2);
                    que.add(new Pair(i, j - 1));
                }
                if (i + 1 < N && A.get(i + 1).get(j) == 1) {
                    A.get(i + 1).set(j, 2);
                    que.add(new Pair(i + 1, j));
                }
                if (j + 1 < M && A.get(i).get(j + 1) == 1) {
                    A.get(i).set(j + 1, 2);
                    que.add(new Pair(i, j + 1));
                }
            }
            ct += 1;
        }
        System.out.println(A);
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(A.get(i).get(j) == 1) {
                    System.out.println(-1);
                    return -1;
                }
            }
        }
        System.out.println(ct-1);
        return ct-1;
    }

    public static void main(String[] args) {
        rottenOranges ro = new rottenOranges();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        // A.add(new ArrayList<Integer>(Arrays.asList(2, 1, 1)));
        // A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 0)));
        // A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1)));

        A.add(new ArrayList<Integer>(Arrays.asList(2, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 0, 1)));

        ro.solve(A);
    }
}
