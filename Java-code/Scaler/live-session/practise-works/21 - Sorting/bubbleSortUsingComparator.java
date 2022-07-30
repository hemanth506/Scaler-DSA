import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class bubbleSortUsingComparator {
    public ArrayList<Integer> sort(ArrayList<Integer> A, ArrayList<Integer> B) {
        int N = A.size();
        bubbleComp bub = new bubbleComp();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < (N - 1 - i); j++) {

                // if (A.get(j) > A.get(j+1)) {
                if (bub.compareAsc(A.get(j), A.get(j+1))) {
                    int temp = A.get(j);
                    A.set(j, A.get(j + 1));
                    A.set((j + 1), temp);
                }

                // if (A.get(j) < A.get(j+1)) {
                if (bub.compareDes(B.get(j), B.get(j+1))) {
                    int temp = B.get(j);
                    B.set(j, B.get(j + 1));
                    B.set((j + 1), temp);
                }

            }
        }

        System.out.println(A);
        System.out.println(B);

        return A;
    }

    public static void main(String[] args) {
        bubbleSortUsingComparator bubble = new bubbleSortUsingComparator();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(30,83,63,22,46,57,15,91,43));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(30,83,63,22,46,57,15,91,43));
        bubble.sort(A, B);
    }
}

class bubbleComp implements Comparator<Integer>{

    public boolean compareAsc(Integer o1, Integer o2) {
        if (o1 % 10 > o2 % 10) {
            return true;
        }
        return false;
    }

    public boolean compareDes(Integer o1, Integer o2) {
        if (o1 % 10 < o2 % 10) {
            return true;
        }
        return false;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        // TODO Auto-generated method stub
        return 0;
    }
}