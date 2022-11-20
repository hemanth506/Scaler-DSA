import java.util.ArrayList;
import java.util.Arrays;

public class checkForBstForOneNode {
    public String solveWrongUnderstanding(ArrayList<Integer> A) {
        int N = A.size();
        int prev = A.get(0);
        int curVal = A.get(1);
        boolean hasOneNode = true;
        boolean firstGreatest = false;
        if (prev <= curVal) {
            firstGreatest = true;
        }
        for (int i = 2; i < N; i++) {
            curVal = A.get(i);
            if (i % 2 == 1) {
                if (firstGreatest) {
                    if (prev <= curVal) {
                        hasOneNode = false;
                        break;
                    }
                } else {
                    if (prev >= curVal) {
                        hasOneNode = false;
                        break;
                    }
                }
            } else {
                if (firstGreatest) {
                    if (prev >= curVal) {
                        hasOneNode = false;
                        break;
                    }
                } else {
                    if (prev <= curVal) {
                        hasOneNode = false;
                        break;
                    }
                }
            }
            prev = curVal;
        }
        String res = hasOneNode ? "YES" : "NO";
        System.out.println(res);
        return res;
    }

    public String solve(ArrayList<Integer> A) {
        int N = A.size();
        int l = Integer.MIN_VALUE;
        int r = Integer.MAX_VALUE;
        int prevVal = A.get(0);
        for (int i = 1; i < N; i++) {
            int curVal = A.get(i);
            if (prevVal <= curVal) {
                l = prevVal;
            } else {
                r = prevVal;
            }

            System.out.println(l + " " + curVal + " " + r);
            if (l >= curVal || curVal >= r) {
                System.out.println("NO");
                return "NO";
            }
            prevVal = curVal;
        }
        System.out.println("YES");
        return "YES";
    }

    public static void main(String[] args) {
        checkForBstForOneNode co = new checkForBstForOneNode();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(4, 10, 5, 8));
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 5, 6, 4));
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(12, 1, 9, 6, 2));

        //
        co.solve(A);
    }
}
