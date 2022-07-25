import java.util.ArrayList;
import java.util.Arrays;

public class subarraysBitwiseOr1 {
       
    public Long solve(int A, ArrayList<Integer> B) {
        int totalSubArrays = A * (A+1) / 2;

        int previousValue = -1;
        int previousCt = 0;
        int internalCt = 0;
        for (int i = 0; i < A; i++) {
            if (B.get(i) == 0) {
                if (previousValue == 0) {
                    internalCt += 1;
                    previousCt += internalCt;
                } else {
                    previousCt += 1;
                    internalCt = 1;
                    System.out.println("=== Zero started ===");
                }
                previousValue = 0;
            } else {
                previousValue = 1;
            }
        }
        System.out.println(totalSubArrays-previousCt);
        totalSubArrays -= previousCt;

        return (long) totalSubArrays;
    }

    // peer code.[Not able to understand]
    public long solveN(int A, ArrayList<Integer> B) {
        long total = 0;
        long prev = 0;
        for(int i=0; i< A; i++){
            if(B.get(i) == 0){
                total += prev;
            }
            else{
                prev = i+1;
                total += prev;
            }
        }
        System.out.println(total);
        return total;
    }

    public static void main(String[] args) {
        subarraysBitwiseOr1 sub = new subarraysBitwiseOr1();
        int A = 5;
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0)); // 8
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(0, 1, 1, 0, 1)); // 13
        
        // int A = 9;
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1, 0, 0, 1, 1, 1, 1, 1, 1)); // 42

        // int A = 19;
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0)); // 175

        // int A = 7;
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(1,1,1,1,1,1,1)); // 175


        // 

        sub.solve(A, B);
        sub.solveN(A,B);
    }
}
