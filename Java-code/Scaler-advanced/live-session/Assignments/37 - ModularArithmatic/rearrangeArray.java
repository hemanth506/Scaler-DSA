import java.util.ArrayList;
import java.util.Arrays;

public class rearrangeArray {
    // (oldVal * N) + newVal
    public void arrangeCaseI(ArrayList<Integer> a) {
        int N = a.size();

        for (int i = 0; i < N; i++) {
            int oldV = a.get(i);
            a.set(i, oldV * N);
        }

        for (int i = 0; i < N; i++) {
            int oldV = a.get(i);
            int newV = a.get(a.get(i)/N)/N;
            a.set(i, oldV + newV);
        }

        for(int i = 0; i < N; i++) {
            int newV = a.get(i) % N;
            a.set(i, newV);
        }

        System.out.println(a);
	}

    // oldVal + (newVal * N)
    public void arrangeCaseII(ArrayList<Integer> a) {
        int N = a.size();

        for(int i = 0; i < N; i++) {
            int oldV = a.get(i);
            int newV = (a.get(a.get(i)) % N) * N;
            a.set(i, oldV + newV);
        }

        for(int i = 0; i < N; i++) {
            int newV = a.get(i) / N;
            a.set(i, newV);
        }
        System.out.println(a);

    }
    public static void main(String[] args) {
        rearrangeArray ra = new rearrangeArray();
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(3,2,5,4,0,6,1));
        ra.arrangeCaseI(a);
        ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(3,2,5,4,0,6,1));
        ra.arrangeCaseII(b);
    }
}
