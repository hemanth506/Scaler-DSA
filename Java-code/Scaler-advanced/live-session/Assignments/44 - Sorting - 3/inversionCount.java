
import java.util.ArrayList;
import java.util.Arrays;

public class inversionCount {
    int ct = 0;
    public void merge(ArrayList<Integer> A, int aSt, int aEn, int bSt, int bEn) {
        int p1 = aSt;
        int p2 = bSt;

        ArrayList<Integer> C = new ArrayList<Integer>();
        while (p1 <= aEn && p2 <= bEn) {
            if(A.get(p1) <= A.get(p2)) {
                C.add(A.get(p1)); p1++;    
            } else {
                ct += aEn - p1 + 1;
                C.add(A.get(p2)); p2++;
            }
        }
        while(p1 <= aEn) {
            C.add(A.get(p1));
            p1++;
        }
        while(p2 <= bEn) {
            C.add(A.get(p2));
            p2++;
        }

        int iter = aSt;
        for(int i = 0; i < C.size(); i++) {
            A.set(iter, C.get(i));
            iter++;
        }
        System.out.println(A);
    }
    public void mergeSt(ArrayList<Integer> A, int st, int ed) {
        if(st == ed) {
            return;
        }
        int mid = (st + ed) / 2;
        mergeSt(A, st, mid);
        mergeSt(A, mid+1, ed);
        merge(A, st, mid, mid+1, ed);
    }
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        int start = 0;
        int end = N-1;
        mergeSt(A, start, end);
        System.out.println(ct);
        return ct;
    }
    public static void main(String[] args) {
        inversionCount iv = new inversionCount();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 2, 1));
        iv.solve(A);

        // ArrayList<Integer> mg = new ArrayList<Integer>(Arrays.asList(1,4,5,2,8));
        // iv.merge(mg, 0, 2, 3, 4);

    }
}
