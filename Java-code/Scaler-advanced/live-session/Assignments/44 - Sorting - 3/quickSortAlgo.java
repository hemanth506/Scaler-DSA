import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class quickSortAlgo {
    public int getRandomInteger(int start, int end) {
        int randomV = ThreadLocalRandom.current().nextInt(start, end);
        System.out.println("randomV => " + randomV);
        return randomV;
    }
    
    public void swapVal(ArrayList<Integer> A, int index, int swapInd) {
        int temp = A.get(index);
        A.set(index, A.get(swapInd));
        A.set(swapInd, temp);
    }

    public int reArrange(ArrayList<Integer> A, int start, int end) {
        int refInd = getRandomInteger(start, end);
        swapVal(A, start, refInd);
        System.out.println(A.get(start) + " " + A);
        System.out.println(start + " " + end);

        int p1 = start+1;
        int p2 = end; 
        while (p1 <= p2) {
            if(A.get(p1) <= A.get(start)) {
                p1++;
            } else if (A.get(p2) > A.get(start)) {
                p2--;
            } else {
                swapVal(A, p1, p2);
                p1++; p2--;
            }
        }
        swapVal(A, start, p2);
        System.out.println(A);
        return p2;
    }
    public void quickSort(ArrayList<Integer> A, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = reArrange(A, start, end);
        quickSort(A, start, mid-1);
        quickSort(A, mid+1, end);
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int N = A.size();
        quickSort(A, 0, N-1);
        return A;
    }
    public static void main(String[] args) {
        quickSortAlgo qs = new quickSortAlgo();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(14,6,8,18,1,19,17,11,20,10,33,29,29));
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 4, 10, 2, 1, 5));

        System.out.println(A);
        qs.solve(A);
    }    
}
