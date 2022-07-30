import java.util.ArrayList;
import java.util.Arrays;

public class sortByColors {
    
    public ArrayList<Integer> sortColors(ArrayList<Integer> A) {
        int N = A.size();
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int i= 0; i <N;i++) {
            if(A.get(i) == 0) {
                zero+= 1;
            } else if (A.get(i) == 1) {
                one += 1;
            } else {
                two += 1;
            }
        }
        System.out.println(zero + " " + one + " " + two);

        for (int z = 0; z < zero; z++) {
            A.set(z, 0);
        }

        int os = zero;
        for (int o = 0; o < one; o++) {
            A.set(os, 1);
            os++;
        }

        
        int ts = one + zero;
        for (int t = 0; t < two; t++) {
            A.set(ts, 2);
            ts++;
        }
        System.out.println(A);
        return A;
    }
    
    public static void main(String[] args) {
        sortByColors st = new sortByColors();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 0, 0, 1, 0, 0, 2, 2, 1, 1, 0, 0, 1, 0, 2, 1, 1, 0, 1, 0, 1, 2, 2, 2, 0, 0, 1, 0, 2, 1, 1, 2, 1, 2, 2, 1, 0, 2, 2, 1, 1, 1, 0, 1, 0, 1, 0, 2, 1, 2, 0, 2, 0, 1, 1, 0, 2, 2, 1, 2, 0, 2, 1, 1, 1, 2, 0, 1, 0, 2, 2, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 2, 1, 1, 0, 2, 1, 2, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 1, 1, 0, 2, 1, 2, 2, 2, 1, 2, 2, 0, 1, 0, 1, 2, 1, 1, 0, 1, 2, 0, 1, 0, 2, 2, 1, 2, 1, 0, 2, 2, 1, 1, 0, 2, 1, 2));
        st.sortColors(A);
    }
}

