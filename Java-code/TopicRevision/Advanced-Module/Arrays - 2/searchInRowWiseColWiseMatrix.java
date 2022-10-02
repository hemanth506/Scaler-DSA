import java.util.ArrayList;
import java.util.Arrays;

public class searchInRowWiseColWiseMatrix {
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int N = A.size();
        int M = A.get(0).size();
        int i = 0;
        int j = M - 1;
        int indexI = 0;
        int indexJ = 0;
        boolean found = false;
        while (i < N && j >= 0) {
            System.out.println(A.get(i).get(j) + " " + j);
            if (A.get(i).get(j) == B) {
                if (j-1 >= 0 && A.get(i).get(j-1) == B) {
                    System.out.println("multilpe");
                    j -= 1;
                } else {
                    System.out.println("value ");
                    indexI = i;
                    indexJ = j;
                    found = true;
                    break;
                }
            } else if (A.get(i).get(j) < B) {
                i += 1;
            } else {
                j -= 1;
            }
        }
        System.out.println(indexI + " " + indexJ);
        int val = -1;
        if (found) {
            val = (indexI+1) * 1009 + (indexJ+1);
        }
        System.out.println(val);
        return val;
    }
    public static void main(String[] args) {
        searchInRowWiseColWiseMatrix sr = new searchInRowWiseColWiseMatrix();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        // A.add(new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7)));
        // A.add(new ArrayList<Integer>(Arrays.asList(2, 4, 6, 8)));
        // A.add(new ArrayList<Integer>(Arrays.asList(9, 11, 11, 16)));
        // A.add(new ArrayList<Integer>(Arrays.asList(13, 15, 19, 20)));

        A.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
        A.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));
        A.add(new ArrayList<Integer>(Arrays.asList(7,8,9)));




        int B = 2;
        sr.solve(A, B);
    }
}
