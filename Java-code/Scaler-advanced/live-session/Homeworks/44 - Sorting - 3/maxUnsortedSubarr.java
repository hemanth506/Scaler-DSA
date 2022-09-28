import java.util.ArrayList;
import java.util.Arrays;

public class maxUnsortedSubarr {
    /*
     * Don't use this idea: This will fail for this problem.
     * 1,2,3,4,5, 2,8,10, 3,6,9, 4,8
     * 0,0,0,0,0, 1,1,1, 2,2,2, 3,3
     */

    // correct output - Used TA help :(
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int N = A.size();
        int indStr = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();

        // i should be lesser than i+1, if no break.
        for(int i = 0; i < N-1; i++) {
            if(A.get(i) > A.get(i+1)) {
                indStr = i;
                break;
            }
        }

        // i should be greaker than i-1, if no break.
        int indEnd = 0;
        for(int i = N-1; i > 0; i--) {
            if(A.get(i) < A.get(i-1)) {
                indEnd = i;
                break;
            }
        }

        // if start and end are same then the gicen array itself is sorted
        if(indStr == indEnd) {
            arr.add(-1);
            return arr;
        }
        System.out.println(indStr + " " + indEnd);

        // find the max and min value within the indStr and indEnd index.
        int maxV = Integer.MIN_VALUE;
        int minV = Integer.MAX_VALUE;
        for(int i = indStr; i <= indEnd; i++) {
            maxV = Integer.max(maxV, A.get(i));
            minV = Integer.min(minV, A.get(i));
        }
        System.out.println(minV + " " + maxV);
        

        // when iterating from 0, if the value is greater than minV then break
        int startInd = 0;
        int endInd = 0;
        for(int p1 = 0; p1 < N - 1; p1++) {
            if(A.get(p1) > minV) {
                startInd = p1;
                break;
            }
        }

        // when iterating from N-1, if the value is lesser than maxV then break
        for(int p2 = N-1; p2 > 0; p2--) {
            if(A.get(p2) < maxV) {
                endInd = p2;
                break;
            }
        }
        System.out.println(startInd + " " + endInd);

        arr.add(startInd);
        arr.add(endInd);
        return arr;
    }
    
    public static void main(String[] args) {
        maxUnsortedSubarr ms = new maxUnsortedSubarr();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,6,8,17,10,19,11,18,14,20,29,33));
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(4, 15, 4, 4, 15, 18, 20));
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1, 10, 10, 15, 10, 15, 10, 10, 15, 10, 15));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(4, 15, 4, 4, 15, 18, 20));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,1,1,1));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1, 2, 3, 3, 4, 8, 9, 11, 9, 11, 12, 12, 11, 9, 14, 19, 20, 20));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 5, 6, 13, 15, 16, 17, 13, 13, 15, 17, 17, 17, 17, 17, 19, 19));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3));

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 3, 4, 5, 5, 9, 11, 13, 14, 15, 15, 16, 15, 20, 16));

        ms.subUnsort(A);
    }   
}
