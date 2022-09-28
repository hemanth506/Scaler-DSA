import java.util.ArrayList;
import java.util.Arrays;

public class searchBiotonicalArray {
    public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();

        if(A.get(0) == B) {
            return 0;
        } else if (A.get(N-1) == B) {
            return N - 1;
        }

        // get max value index
        int maxIndex = 0;
        int maxl1 = 1; 
        int maxh1 = N - 2;
        while (maxl1 <= maxh1) {
            int maxm1 = (maxl1 + maxh1) / 2;
            System.out.println(maxm1);
            if(A.get(maxm1) == B) {
                return maxm1;
            }

            if(A.get(maxm1 - 1) < A.get(maxm1) && A.get(maxm1) > A.get(maxm1 + 1)) {
                maxIndex = maxm1;
                break;
            }
            else if (A.get(maxm1 - 1) < A.get(maxm1) && A.get(maxm1) < A.get(maxm1 + 1)) {
                maxl1 = maxm1 + 1;
            }
            else if (A.get(maxm1 - 1) > A.get(maxm1) && A.get(maxm1) > A.get(maxm1 + 1)) {
                maxh1 = maxm1 - 1;
            }
        }

        System.out.println("maxIndex => " + maxIndex);

        // left side check
        int l2 = 1; 
        int h2 = maxIndex - 1;
        while (l2 <= h2) {
            int m2 = (l2 + h2) / 2;
            System.out.println(m2);
            if(A.get(m2) == B){
                System.out.println("present in left side check");
                return m2;
            }

            if(A.get(m2 - 1) < A.get(m2) && A.get(m2 + 1) < A.get(m2)) {
                h2 = m2 - 1;
            } else if (A.get(m2) < B) {
                l2 = m2 + 1;
            } else if (A.get(m2) > B) {
                h2 = m2 - 1;
            }
        }

        System.out.println("=========================");

        // right side check
        int l1 = maxIndex + 1; 
        int h1 = N - 2;
        while (l1 <= h1) {
            int m1 = (l1 + h1) / 2;
            System.out.println(m1);
            if(A.get(m1) == B){
                System.out.println("present in right side check");
                return m1;
            }

            if(A.get(m1 - 1) < A.get(m1) && A.get(m1 + 1) < A.get(m1)) {
                l1 = m1 + 1;
            } else  if (A.get(m1) < B) {
                h1 = m1 - 1;
            } else if (A.get(m1) > B) {
                l1 = m1 + 1;
            }
        }
        
        System.out.println("not present");
        return -1;
    }
    public static void main(String[] args) {
        searchBiotonicalArray sr = new searchBiotonicalArray();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3,9,10,20,17,5,2,1));
        int B = 9;

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11));
        // int B = 12;
        sr.solve(A, B);
    }
}
