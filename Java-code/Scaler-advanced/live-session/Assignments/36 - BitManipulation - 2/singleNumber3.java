import java.util.ArrayList;
import java.util.Arrays;

public class singleNumber3 {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int N = A.size();
        
        int ans = 0;
        for(int i = 0; i < N; i++) {
            ans = ans ^ A.get(i);
        }
        System.out.println(ans);

        int pos = 0;
        for (int i = 0; i < 32; i++) {
            if (((ans>>i) & 1) == 1) {
                pos = i;
                break;
            }
        }

        int set = 0;
        int unset = 0;
        for (int i = 0;i < N; i++) {
            if (((A.get(i)>>pos) & 1) == 1) {
                set ^= A.get(i);
            } else {
                unset ^= A.get(i);
            }
        }

        ArrayList<Integer> B = new ArrayList<Integer>();
        if (set <= unset) {
            B.add(set);
            B.add(unset);
        } else {
            B.add(unset);
            B.add(set);
        }
        // System.out.println(B);
        return B;
    }
    public static void main(String[] args) {
        singleNumber3 s3 = new singleNumber3();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,3,1,2,4));
        s3.solve(A);
    }
}
