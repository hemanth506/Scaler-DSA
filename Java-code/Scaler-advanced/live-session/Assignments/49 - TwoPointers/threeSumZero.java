import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class threeSumZero {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        Collections.sort(A);
        System.out.println(A);
        int N = A.size();

        HashSet<String> hs = new HashSet<String>();
        ArrayList<ArrayList<Integer>> finalArr = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < N; i++) {
            int p1 = i;
            int p2 = i+1;
            int p3 = N-1;

            while (p2 < p3) {
                int sumVal = A.get(p1) + A.get(p2) + A.get(p3);
                if(sumVal == 0) {
                    String str = A.get(p1)+"|"+A.get(p2)+"|"+A.get(p3);
                    if(!hs.contains(str)) {
                        finalArr.add(new ArrayList<Integer>(Arrays.asList(A.get(p1), A.get(p2), A.get(p3))));
                        hs.add(str);
                    }
                    p3--;
                } else if(sumVal < 0) {
                    p2++;
                } else if (sumVal > 0) {
                    p3--;
                }
            }
        }
        System.out.println(finalArr);
        return finalArr;
    }
    public static void main(String[] args) {
        threeSumZero sz = new threeSumZero();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-1,0,1,2,-1,4));
        sz.threeSum(A);
    }
}
