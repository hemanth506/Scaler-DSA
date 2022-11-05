import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class maxAndMin {

    public int[] maxFromLeft(ArrayList<Integer> A, int N) {
        int[] arr = new int[N];
        Arrays.fill(arr, -1);
        Stack<Integer> stk = new Stack<Integer>();
        for(int i = 0; i < N; i++) {
            while (!stk.isEmpty() && A.get(i) >= A.get(stk.peek())) {
                stk.pop();
            }
            if(!stk.isEmpty()) {
                arr[i] = stk.peek();
            }
            stk.add(i);
        }
        // System.out.println(stk);
        // System.out.println(Arrays.toString(arr));
        return arr;
    }

    public int[] maxFromRight(ArrayList<Integer> A, int N) {
        int[] arr = new int[N];
        Arrays.fill(arr, N);
        Stack<Integer> stk = new Stack<Integer>();
        for(int i = N-1; i >= 0; i--) {
            while(!stk.isEmpty() && A.get(i) >= A.get(stk.peek())) {
                stk.pop();
            }
            if(!stk.isEmpty()) {
                arr[i] = stk.peek();
            }
            stk.add(i);
        }
        // System.out.println(stk);
        // System.out.println(Arrays.toString(arr));
        return arr;
    }

    public int[] minFromLeft(ArrayList<Integer> A, int N) {
        int[] arr = new int[N];
        Arrays.fill(arr, -1);
        Stack<Integer> stk = new Stack<Integer>();
        for(int i = 0; i < N; i++) {
            while(!stk.isEmpty() && A.get(i) <= A.get(stk.peek())) {
                stk.pop();
            }
            if(!stk.isEmpty()) {
                arr[i] = stk.peek();
            }
            stk.add(i);
        }
        // System.out.println(stk);
        // System.out.println(Arrays.toString(arr));
        return arr;
    }

    public int[] minFromRight(ArrayList<Integer> A, int N) {
        int[] arr = new int[N];
        Arrays.fill(arr, N);
        Stack<Integer> stk = new Stack<Integer>();
        for(int i = N-1; i >= 0; i--) {
            while(!stk.isEmpty() && A.get(i) <= A.get(stk.peek())) {
                stk.pop();
            }
            if(!stk.isEmpty()) {
                arr[i] = stk.peek();
            }
            stk.add(i);
        }
        // System.out.println(stk);
        // System.out.println(Arrays.toString(arr));
        return arr;
    }

    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        int mod = 1000000007;
        int[] maxLeft = maxFromLeft(A, N);
        System.out.println(Arrays.toString(maxLeft));
        int[] maxRight = maxFromRight(A, N);
        System.out.println(Arrays.toString(maxRight));
        int[] minLeft = minFromLeft(A, N);
        System.out.println(Arrays.toString(minLeft));
        int[] minRight = minFromRight(A, N);
        System.out.println(Arrays.toString(minRight));

        long ansMax = 0;
        long ansMin = 0;
        for(int i = 0; i < N; i++) {
            int curVal = A.get(i);
            int maxL = maxLeft[i];
            int maxR = maxRight[i];
            long cMax = 1L* (i - maxL) * (maxR - i);
            long cMaxCont = (cMax%mod * curVal%mod)%mod;
            ansMax = (ansMax%mod + cMaxCont%mod)%mod;

            int minL = minLeft[i];
            int minR = minRight[i];
            long cMin = 1L * (i - minL) * (minR - i);
            long cMinCont = (cMin%mod * curVal%mod)%mod;
            ansMin = (ansMin%mod + cMinCont%mod)%mod;
        }

        int out = (int)(ansMax%mod - ansMin%mod)%mod;

        return out%mod;
    }

    public long inverseMod(int val, int mod) {
        return binPow(val, mod-2, mod);
    }

    public long binPow (int val, int times, int mod) {
        if(times <= 1) {
            return 1;
        }
        long curVal = binPow(val, times/2, mod);
        if(times%2 == 0) {
            return (curVal%mod * curVal%mod)%mod;
        } else {
            return (curVal%mod * curVal%mod * val)%mod;
        }
    }

    public static void main(String[] args) {
        maxAndMin mm = new maxAndMin();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(4, 7, 3, 8));
        
        mm.solve(A);
    }
}
