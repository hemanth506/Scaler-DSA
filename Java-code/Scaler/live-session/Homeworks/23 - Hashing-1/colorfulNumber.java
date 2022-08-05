import java.util.Arrays;
import java.util.HashSet;

public class colorfulNumber {
    public int colorful(int A) {
        int N = Integer.toString(A).length();
        int[] intArr = new int[N];

        int totalCt = (N * (N+1))/2;
        // System.out.println(totalCt);

        int i = N - 1;
        while (A > 0) {
            int temp = A % 10;
            intArr[i] = temp;
            A /= 10;
            i--;
        }
        System.out.println(Arrays.toString(intArr));

        HashSet<Integer> hs = new HashSet<>();
        for(int x = 0; x < N; x++) {
            int value = 1;
            for (int y = x; y < N; y++) {
                value = value * intArr[y];
                System.out.print(intArr[y] + " -> " + value + ",   ");
                hs.add(value);
            }
            System.out.println();
            System.out.println("=============");
        }
        System.out.println(totalCt + " " + hs.size());

        return totalCt == hs.size() ? 1 : 0;
    }
    public static void main(String[] args) {
        colorfulNumber col = new colorfulNumber();
        int A = 3245;
        col.colorful(A);
    }
}
