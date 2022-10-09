import java.util.ArrayList;
import java.util.Arrays;

// used video explanation to understand the solution ;(
public class allocateBooks {
    public boolean check(ArrayList<Integer> A, int M, int B) {
        int N = A.size();
        int totalVal = A.get(0);
        int person = 0;
        for (int i = 1; i < N; i++) {
            totalVal += A.get(i);
            if (totalVal > M) {
                person += 1;
                totalVal = A.get(i);
                if (person == B) {
                    System.out.println("sumVal = " + false);
                    return false;
                }
            }
        }
        System.out.println("sumVal = " + true);
        return true;
    }

    public int books(ArrayList<Integer> A, int B) {
        int N = A.size();
        if (B > N) {
            return -1;
        }

        int sum = 0;
        int maxV = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            sum += A.get(i);
            maxV = Integer.max(maxV, A.get(i));
        }
        System.out.println("sum = " + sum);

        if (B == 1) {
            return sum;
        } else if (B == N) {
            return maxV;
        }

        int l = maxV;
        int h = sum;
        int maxMinPages = 0;
        while (l <= h) {
            int m = (l + h) / 2;
            System.out.println("m = " + m);
            if (check(A, m, B)) {
                maxMinPages = m;
                h = m - 1;
            } else {
                l = m + 1;
            }
        }

        System.out.println(maxMinPages);
        return maxMinPages;
    }

    public static void main(String[] args) {
        allocateBooks ab = new allocateBooks();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(12, 34, 67, 90));
        // int B = 2;
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(73, 58, 30, 72, 44, 78, 23, 9));
        int B = 5;

        ab.books(A, B);
    }
}
