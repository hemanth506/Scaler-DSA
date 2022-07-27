import java.util.ArrayList;
import java.util.Arrays;

public class nonDecreasingSubArray {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int NB = B.size();

        ArrayList<Integer> finalResult = new ArrayList<Integer>();
        for (int i = 0; i < NB; i++) {
            ArrayList<Integer> ranges = B.get(i);
            int left = ranges.get(0);
            int right = ranges.get(1);

            int currentValue = A.get(left);
            int ascending = 1;
            for (int j = left + 1; j <= right; j++) {
                if(currentValue <= A.get(j)) {
                    currentValue = A.get(j);
                } else {
                    ascending = 0;
                    break;
                }
            }
            finalResult.add(ascending);
            System.out.println(ascending);
        }
        
        return finalResult;
    }

    public ArrayList<Integer> solveNew(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int N = A.size();

        int[] prefix = new int[N];
        prefix[0] = 0;
        for(int i=1; i< N; i++) {
            prefix[i] = prefix[i - 1];
            if(A.get(i - 1) > A.get(i)) {
                prefix[i] += 1;
                System.out.println("increm" + i);
            }
        }
        System.out.println(Arrays.toString(prefix));

        ArrayList<Integer> res = new ArrayList<Integer>();
        for(ArrayList<Integer> query: B) {
            int l = query.get(0);
            int r = query.get(1);

            if(prefix[l] == prefix[r]) {
                res.add(1);
            } else {
                res.add(0);
            }
        }

        System.out.println(res);

        return res;
    }
    
    public static void main(String[] args) {
        nonDecreasingSubArray nd = new nonDecreasingSubArray();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1, 7, 2, 3, 7 , 8 , 9 , 10, 2,3,4,5));

        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        B.add(new ArrayList<Integer>(Arrays.asList(0, 2)));
        B.add(new ArrayList<Integer>(Arrays.asList(2, 4)));

        // nd.solve(A, B);
        nd.solveNew(A, B);

    }
}
