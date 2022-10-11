import java.util.ArrayList;
import java.util.Arrays;

public class sortByColor {
    public ArrayList<Integer> sortColors(ArrayList<Integer> A) {
        int N = A.size();
        System.out.println(A);

        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for(int i = 0; i < N; i++) {
            if (A.get(i) == 0) {
                zeros += 1;
            } else if (A.get(i) == 1){
                ones += 1;
            } else {
                twos += 1;
            }
        }

        for(int i = 0; i < zeros; i++) {
            A.set(i, 0);
        }

        int newOnes = zeros+ones;
        for (int j = zeros; j < newOnes; j++) {
            A.set(j, 1);
        }

        int newTwos = newOnes+twos;
        for(int k = newOnes; k < newTwos; k++) {
            A.set(k, 2);
        }

        System.out.println(A);
        return A;
    }
    public static void main(String[] args) {
        sortByColor sc = new sortByColor();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 0, 1, 2));
        sc.sortColors(A);
    }
}
