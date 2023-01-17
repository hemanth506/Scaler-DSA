import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int i;
    int j;
    Pair (int x, int y) {
        this.i = x;
        this.j = y;
    }
}

public class distanceOfNearestCell {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        int M = A.get(0).size();
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        Queue<Pair> que = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j = 0; j < M; j++) {
                if(A.get(i).get(j) == 0) {
                    arr.add(-1);
                } else {
                    que.add(new Pair(i, j));
                    arr.add(0);
                }
            }
            B.add(arr);
        }
        System.out.println(A);
        System.out.println(B);


        int dist = 1;
        while(!que.isEmpty()) {
            int QN = que.size();
            for(int x = 0; x < QN; x++) {
                Pair pr = que.poll();
                int i = pr.i;
                int j = pr.j;
                System.out.println(i + " " + j);

                if(i-1 >= 0 && B.get(i-1).get(j) == -1) {
                    // System.out.println(A.get(i-1).get(j) + " " + B.get(i-1).get(j));
                    B.get(i-1).set(j, dist);
                    que.add(new Pair(i-1, j));
                }

                if (i+1 < N && B.get(i+1).get(j) == -1) {
                    // System.out.println(A.get(i+1).get(j) + " " + B.get(i+1).get(j));
                    B.get(i+1).set(j, dist);
                    que.add(new Pair(i+1, j));
                }

                if (j-1 >= 0 && B.get(i).get(j-1) == -1) {
                    // System.out.println(A.get(i).get(j-1) + " " + B.get(i).get(j-1));
                    B.get(i).set(j-1, dist);
                    que.add(new Pair(i, j-1));
                }

                if (j+1 < M && B.get(i).get(j+1) == -1) {
                    // System.out.println(A.get(i).get(j+1) + " " + B.get(i).get(j+1));
                    B.get(i).set(j+1, dist);
                    que.add(new Pair(i, j+1));
                }
                System.out.println("=============");
            }
            dist += 1;
        }

        System.out.println(B);
        
        return B;
    }
    public static void main(String[] args) {
        distanceOfNearestCell dnc = new distanceOfNearestCell();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        // A.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 1)));
        // A.add(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 1)));
        // A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1, 0)));

        A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 0, 1, 1, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 0, 0, 0)));

        dnc.solve(A);
    }
}
