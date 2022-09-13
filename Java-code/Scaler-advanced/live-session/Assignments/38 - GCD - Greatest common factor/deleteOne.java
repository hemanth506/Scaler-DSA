import java.util.ArrayList;
import java.util.Arrays;

public class deleteOne {
    public int gcd(int A, int B) {
        if(B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }

    public int solve(ArrayList<Integer> A) {
        int N = A.size();

        int[] prefixGCD = new int[N];
        prefixGCD[0] = gcd(0, A.get(0));
        for(int i = 1; i < N; i++) {
            prefixGCD[i] = gcd(prefixGCD[i-1], A.get(i));
        }
        System.out.println(Arrays.toString(prefixGCD));

        int[] suffixGCD = new int[N];
        suffixGCD[N-1] = gcd(0, A.get(N-1));
        for(int i = N-2; i >= 0; i--) {
            suffixGCD[i] = gcd(suffixGCD[i+1], A.get(i));
        }
        System.out.println(Arrays.toString(suffixGCD));

        System.out.println("==============");
        
        int leftEnd = gcd(0, suffixGCD[1]);
        System.out.println(leftEnd);
        int rightEnd = gcd(prefixGCD[N-2], 0);
        int maxV = Integer.max(leftEnd, rightEnd);
        for(int i = 1; i < N-1; i++) {
            int left = prefixGCD[i - 1];
            int right = suffixGCD[i + 1];
            int gcdV = gcd(left, right);
            System.out.println(gcdV);
            maxV = Integer.max(maxV, gcdV);
        }
        System.out.println(rightEnd);
        System.out.println("==============");


        System.out.println(maxV);


        return maxV;
    }
    public static void main(String[] args) {
        deleteOne delOne = new deleteOne();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(24,16,18,30,15));
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(7,21));
        delOne.solve(A);
    }
}
