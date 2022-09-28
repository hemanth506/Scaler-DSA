import java.util.ArrayList;
import java.util.Arrays;

public class martixSearch {
    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int N = A.size();
        int Nn = A.get(0).size();
        int index = 0;
        for(int i = 0; i < N; i++) {
            if(A.get(i).get(Nn - 1) >= B) {
                index = i;
                break;
            }
        }
        System.out.println(index);

        int l = 0;
        int h = Nn - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            if (A.get(index).get(m) == B) {
                System.out.println("present");
                return 1;
            }

            if(A.get(index).get(m) < B) {
                l = m + 1;
            } else if (A.get(index).get(m) > B) {
                h = m - 1;
            }
        }
        System.out.println(" not present");
        return 0;
    }
    public static void main(String[] args) {
        martixSearch ms = new martixSearch();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(new ArrayList<Integer>(Arrays.asList(1,3,5,7)));
        A.add(new ArrayList<Integer>(Arrays.asList(10,11,16,20)));
        A.add(new ArrayList<Integer>(Arrays.asList(23,30,34,50)));
        int B = 3;
        ms.searchMatrix(A, B);
    }
}
