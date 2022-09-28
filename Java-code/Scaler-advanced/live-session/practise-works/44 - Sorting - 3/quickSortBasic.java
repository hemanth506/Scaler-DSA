import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.*;

public class quickSortBasic {
    public int getRandomInteger(int start, int end) {
        int randomV = ThreadLocalRandom.current().nextInt(start, end);
        System.out.println(randomV);
        return randomV;
    }
    public void swapVal(ArrayList<Integer> A, int index, int swapInd) {
        int temp = A.get(index);
        A.set(index, A.get(swapInd));
        A.set(swapInd, temp);
    }
    public void solve(ArrayList<Integer> A, int start, int end) {
        int refInd = getRandomInteger(start, end);
        swapVal(A, start, refInd);
        System.out.println(A.get(0) + " " + A);

        int p1 = 1;
        int p2 = end; 
        while (p1 <= p2) {
            if(A.get(p1) <= A.get(0)) {
                p1++;
            } else if (A.get(p2) > A.get(0)) {
                p2--;
            } else {
                swapVal(A, p1, p2);
                p1++; p2--;
            }
        }
        swapVal(A, start, p2);
        System.out.println(A);
    }
    public static void main(String[] args) {
        quickSortBasic qs = new quickSortBasic();

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(14,6,8,18,1,19,17,11,20,10,33,29));
        System.out.println(A);
        int N = A.size();
        qs.solve(A, 0, N - 1);
    }
}
