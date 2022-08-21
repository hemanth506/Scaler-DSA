import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class factorsSortOpt {
    public int factors(int elt) {
        int ct = 0;
        for (int i = 1; i*i <= elt; i++) {
            if(elt%i == 0) {
                if (i == elt/i) {
                    ct += 1;
                } else {
                    ct += 2;
                }
            }
        }
        return ct;
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int N = A.size();
        System.out.println("original list => " + A);
        bubbleSortComp bubble = new bubbleSortComp();
        
        // creating factor array
        int arrInt[] = new int[N];
        for(int i = 0; i < N; i++) {
            arrInt[i] = factors(A.get(i));
        }
        System.out.println("factors array => " + Arrays.toString(arrInt));

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (bubble.shouldSwap(arrInt[j], arrInt[j+1], A.get(j), A.get(j+1))) {
                    int temp = arrInt[j];
                    arrInt[j] = arrInt[j+1];
                    arrInt[j+1] = temp;

                    int tempA = A.get(j);
                    A.set(j, A.get(j + 1));
                    A.set(j+1, tempA);
                } 
            }
        }
        System.out.println("Sorted factors list => " + Arrays.toString(arrInt));
        System.out.println("Final list => " + A);
        return A;
    } 
    public static void main(String[] args) {
        factorsSortOpt fs = new factorsSortOpt();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(7, 36, 16, 3, 1, 35, 17));
        fs.solve(A);
    }
}

class bubbleSortComp implements Comparator<Integer> {
    public boolean shouldSwap(Integer ct1, Integer ct2, Integer o1, Integer o2) {
        if (ct1 > ct2) {
            return true;
        } else if (ct1 == ct2) {
            if(o1 > o2) {
                return true;
            }
        }
        return false;
    }
    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }
}
