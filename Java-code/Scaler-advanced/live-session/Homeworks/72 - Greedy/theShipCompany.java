import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class theShipCompany {
    public ArrayList<Integer> solve(int A, int B, ArrayList<Integer> C) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < B; i++) {
            minHeap.add(C.get(i));
            maxHeap.add(C.get(i));
        }

        int tempA = A;
        int maxVal = 0;
        while (tempA > 0) {
            int peek = maxHeap.poll();
            maxVal += peek;
            maxHeap.add(peek-1);
            tempA-=1;
        }
        System.out.println(maxVal);

        int minTempA = A;
        int minVal = 0;
        while (minTempA > 0) {
            int peek = minHeap.poll();
            minVal += peek;
            if(peek-1 != 0) {
                minHeap.add(peek-1);
            }
            minTempA-=1;
        }
        System.out.println(minVal);
        ArrayList<Integer> finRes = new ArrayList<Integer>(Arrays.asList(maxVal, minVal));
        System.out.println(finRes);
        return finRes;
    }
    
    public static void main(String[] args) {
        theShipCompany sc = new theShipCompany();
        // int A = 4;
        // int B = 3;
        // ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(2, 1, 1));
        
        // int A = 4;
        // int B = 3;
        // ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(2, 2, 2));
        

        // int A = 10;
        // int B = 5;
        // ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(10, 3, 3, 1, 2));

        int A = 40;
        int B = 10;
        ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 10, 10, 10));
        
        sc.solve(A, B, C);
    }
}
