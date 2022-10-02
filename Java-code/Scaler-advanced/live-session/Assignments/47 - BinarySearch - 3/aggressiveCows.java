import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class aggressiveCows {
    public boolean check(int M, ArrayList<Integer> A, int N, int B) {
        System.out.println("=========ins " + M + " ide===========");
        int dist = 0;
        int cows = 1;
        int temp = A.get(0);
        // boolean looped = false;
        for(int i = 1; i < N; i++) {
            dist = A.get(i) - temp;
            System.out.println(A.get(i) + " - " + temp);
            if(dist >= M) {
                cows += 1;
                System.out.println(dist + " " + M + " cows => " + cows + " " + B);
                temp = A.get(i);
                if(cows == B) {
                    System.out.println(true);
                    return true;
                }
            }
        }
         System.out.println(false);
        return false;
    }
    public int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int N = A.size();
        int minDis = Integer.MAX_VALUE;
        for(int i = 0; i < N - 1; i++) {
            minDis = Integer.min(A.get(i + 1) - A.get(i) , minDis);
        }
        System.out.println("minDis => " + minDis);
        int maxDis = A.get(N-1) - A.get(0);
        System.out.println("maxDis => " + maxDis);

        int l = minDis;
        int h = maxDis;
        int maxMinDist = 0;
        while (l <= h) {
            int m = (l + h)/2;
            if (check(m, A, N, B)) {
                maxMinDist = m;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        System.out.println("maxMinDist = " + maxMinDist);
        return maxMinDist;
    }
    public static void main(String[] args) {
        aggressiveCows ac = new aggressiveCows();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        // int B = 3;

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2));
        // int B = 2;

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5, 17, 100, 11));
        int B = 2;

        ac.solve(A, B);
    }
}
