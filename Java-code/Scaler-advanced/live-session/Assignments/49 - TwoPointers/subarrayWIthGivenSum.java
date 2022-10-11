import java.util.ArrayList;
import java.util.Arrays;

public class subarrayWIthGivenSum {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(A.get(0));
        for(int i = 1; i < N; i++) {
            int num = A.get(i) + arr.get(i - 1);
            arr.add(num);
        } 
        System.out.println(arr);

        ArrayList<Integer> sumArray = new ArrayList<Integer>();
        int p1 = 0;
        int p2 = 1;
        boolean present = false;
        while (p1 < N && p2 < N) {
            int arrSum = 0;
            if(p1 != 0) {
                arrSum -= arr.get(p1 - 1); 
            }
            arrSum += arr.get(p2);

            System.out.println(p1 + " " + p2 +  " " + arrSum);
            if(arrSum == B) {
                present = true;
                break;
            }

            if (arrSum < B) {
                p2++;
            } else {
                p1++;
            }
        }

        if (present) {
            System.out.println("present");
            for(int i = p1; i <= p2; i++) {
                sumArray.add(A.get(i));
            }
        } else {
            System.out.println("Not present");
            int noVal = -1;
            sumArray.add(noVal);
        }
        // System.out.println(p1 + " " + p2);
        System.out.println(sumArray);
        return sumArray;
    }
    public static void main(String[] args) {
        subarrayWIthGivenSum ss = new subarrayWIthGivenSum();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        // int B = 5;

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5, 10, 20, 100, 105));
        int B = 110;

        // 
        ss.solve(A, B);
    }
}
