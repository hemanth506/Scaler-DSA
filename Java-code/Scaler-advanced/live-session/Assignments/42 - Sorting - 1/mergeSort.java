import java.util.ArrayList;
import java.util.Arrays;

public class mergeSort {
    public void mergeArr(ArrayList<Integer> A, int A1start, int A1End, int A2Start, int A2End) {
        int N = A1End;
        int M = A2End;
        System.out.println(A1start + " " +  A1End + " " + A2Start + " " + A2End);

        ArrayList<Integer> C = new ArrayList<Integer>();
        int p1 = A1start; int p2 = A2Start; int p3 = 0;
        while(p1 <= N && p2 <= M) {
            if(A.get(p1) <= A.get(p2)) {
                C.add(p3, A.get(p1));
                p1++; p3++;
            } else {
                C.add(p3, A.get(p2));
                p2++; p3++;
            }
        }

        while(p1 <= N) {
            C.add(p3, A.get(p1));
            p1++; p3++;
        }

        while(p2 <= M) {
            C.add(p3, A.get(p2));
            p2++; p3++;
        }

        if(C.size() != 0) {
            for(int i = 0, j = A1start; j <= A2End; i++, j++) {
                A.set(j, C.get(i));
            }
        }
        System.out.println(A);
    }
    public void mgSort(ArrayList<Integer> A, int start, int end) {
        if(start == end) {
            return;
        }
        int tempEnd = end;
        tempEnd = (start+end)/2;
        System.out.println("mgSort => " + start + " " + tempEnd);
        mgSort(A, start, tempEnd);
        System.out.println("mgSort => " + start + " " + tempEnd + " " + (tempEnd+1) + " " + end);
        mgSort(A, tempEnd + 1, end);
        mergeArr(A, start, tempEnd, tempEnd + 1, end);
    }
    
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int N = A.size();
        mgSort(A, 0, N-1);
        return A;
    }
    public static void main(String[] args) {
        mergeSort mg = new mergeSort();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 4, 10, 2, 1, 5));
        mg.solve(A);

        // int A1start =  0;
        // int A1End =  A.size()/2;
        // int A2Start =  A.size()/2 + 1;
        // int A2End =  A.size()-1;
        // System.out.println(A1start + " " +  A1End + " " + A2Start + " " + A2End);
        // mg.mergeArr(A, A1start, A1End, A2Start, A2End);
    }
}
