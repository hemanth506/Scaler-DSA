import java.util.ArrayList;
import java.util.Arrays;

public class floydWarshallAlgorithm {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int N = A.size();
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j = 0; j < N; j++) {
                if(A.get(i).get(j) == -1) {
                    arr.add(Integer.MAX_VALUE);
                } else {
                    int val = A.get(i).get(j);
                    arr.add(val);
                }
            }
            B.add(arr);
        }

        System.out.println(B);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < N; k++) {
                    int directJK = B.get(j).get(k);
                    int ji = B.get(j).get(i);
                    int ik = B.get(i).get(k);
                    if (k == j || k == i || ji == Integer.MAX_VALUE || ik == Integer.MAX_VALUE) {
                        continue;
                    }
                    
                    int jik = ji + ik;
                    if (directJK > jik) {
                        B.get(j).set(k, jik);
                    }
                }
            }
        }
        System.out.println(B);
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(B.get(i).get(j) == Integer.MAX_VALUE) {
                    B.get(i).set(j, -1);
                }
            }
        }
        System.out.println(B);

        return B;
    }

    public static void main(String[] args) {
        floydWarshallAlgorithm fw = new floydWarshallAlgorithm();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<Integer>(Arrays.asList(0, 50, 39)));
        A.add(new ArrayList<Integer>(Arrays.asList(-1, 0, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(-1, 10, 0)));

        fw.solve(A);
    }
}
