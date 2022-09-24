import java.util.ArrayList;
import java.util.Arrays;

public class inversionCount {
    public int solveBruteForce(ArrayList<Integer> A) {
        System.out.println(A);
        int N = A.size();
        int invCt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if(A.get(i) > A.get(j)) {
                    invCt += 1;
                }
            }
        }
        System.out.println(invCt);
        return invCt;
    }

    int count = 0;
    public void merge(ArrayList<Integer> A, int arr1Start, int arr1End, int arr2Start, int arr2End) {
        System.out.println(arr1Start + " " + arr1End + " " + arr2Start + " " + arr2End);
        ArrayList<Integer> C = new ArrayList<Integer>();
        int p1 = arr1Start;
        int p2 = arr2Start;
        while(p1<=arr1End && p2<=arr2End) {
            if(A.get(p1) <= A.get(p2)) {
                C.add(A.get(p1)); p1++;
            } else {
                count= (count + (arr1End - p1 + 1))%1000000007;
                C.add(A.get(p2)); p2++;
            }
        }
        System.out.println(C);
        while(p1<=arr1End) {
            C.add(A.get(p1));p1++;
        }
        while(p2<=arr2End) {
            C.add(A.get(p2));p2++;
        }
        
        int tempArr1Start = arr1Start;
        for(int i = 0; i < C.size(); i++) {
            A.set(tempArr1Start, C.get(i));
            tempArr1Start++;
        }
        System.out.println("C => " + C + " count => " + count);
        return;
    }

    public void mergeSort(ArrayList<Integer> A, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(A,start, mid);
        mergeSort(A,mid+1, end);
        merge(A, start, mid, mid+1, end);

        return;
    }
    

    // merge sort
    public int solve(ArrayList<Integer> A) {
        int start = 0;
        int end = A.size()-1;
        mergeSort(A, start, end);
        System.out.println("final => " + count);
        return 0;
    }
    public static void main(String[] args) {
        inversionCount ic = new inversionCount();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(10,3,8,15,6,12,2,18,7,1));
        ic.solve(A);
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(3,6,8,10,15, 1,2,7,12,18));
        // ic.merge(B, 0, 4, 5, 9);
    }
}
