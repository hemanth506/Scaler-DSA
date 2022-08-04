import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class shaggyAndDistance {
    public int solve(ArrayList<Integer> A) {
        int N = A.size();
        HashMap<Integer, Integer> hm = new HashMap<>();

        int mini = N;
        for(int i = 0; i < N; i++) {
            if(hm.containsKey(A.get(i))) {
                int previousIndex = hm.get(A.get(i));
                int value = i - previousIndex;
                System.out.println("value => " + value);
                if (value < mini) {
                    mini = value;
                }
            } else {
                hm.put(A.get(i), i);
            }
        } 
        System.out.println(mini);
        return mini != N ? mini: -1;
    }
    public static void main(String[] args) {
        shaggyAndDistance sg = new shaggyAndDistance();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 1));    
        sg.solve(A);
    }
}
