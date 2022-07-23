import java.util.ArrayList;
import java.lang.Math;

public class reverseBits {
    public long reverse(long a) {
        ArrayList<Long> bitArr = new ArrayList<Long>();
        while (a > 0) {
            bitArr.add(a % 2);
            a /= 2;
        }

        int N = bitArr.size();
        int remaining = 32 - N;
        System.out.println(remaining);
        ArrayList<Long> zeroArr = new ArrayList<Long>();
        for (int i = 0; i < remaining; i++){
            zeroArr.add((long) 0);
            System.out.print(0);
        }
        System.out.println();

        bitArr.addAll(zeroArr);
        for (int j = 0; j < 32; j++) {
            System.out.print(bitArr.get(j));
        }
        System.out.println();

        long value = 0;
        int p = 0;
        long bitVal = 0;
        for (int k = 31; k >= 0; k--) {
            if (bitArr.get(k) == 1) {
                bitVal = 1<<p;
                value += Math.abs(bitVal);
                // System.out.println(bitArr.get(k) + " " + bitVal);
            }
            p++;
        }
        System.out.println(value);
        return value;
	}


    public static void main(String[] args) {
        reverseBits rev = new reverseBits();
        long a = 37;
        rev.reverse(a);
    }
}
