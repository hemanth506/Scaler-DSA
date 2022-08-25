import java.util.Arrays;

public class contestBit {
    public static void main(String[] args) {
        int A = 6;
        int B = 2;
        int total = A + B;
        int[] bitArr = new int[total];
        for (int i = 0; i < A; i++) {
            bitArr[i] = 1;
        }

        for (int j = A; j < total; j++) {
            bitArr[j] = 0;
        }
        System.out.println(Arrays.toString(bitArr));

        int sum = 0;
        int initial = 0;
        int p =0;
        for (int k = total - 1; k >= 0; k--) {
            if (bitArr[k] == 1) {
                initial = 1<<p;
                sum += initial;
                System.out.println(initial);
            }
            p++;
        }

        System.out.println("sum" + sum);

    }
}
