import java.util.ArrayList;
import java.util.Arrays;

public class maxChunkToMakeSort {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();

        int maxV = 0;
        int chunks = 0;
        for (int i = 0; i < N; i++) {
            maxV = Integer.max(maxV, A.get(i));
            System.out.println(i + " " + A.get(i) + " " + maxV);
            if (maxV == i) {
                System.out.println("add one on chunk");
                chunks += 1;
            }
        }
        System.out.println(chunks);
        return chunks;
    }
    public static void main(String[] args) {
        maxChunkToMakeSort mc = new maxChunkToMakeSort();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(0,4,1,3,2,6,5,8,7));
        mc.solve(A);
    }
}
