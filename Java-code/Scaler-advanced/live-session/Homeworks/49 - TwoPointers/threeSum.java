import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class threeSum {
    // wrong logic - sliding window
    public int threeSumClosestWrong(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        System.out.println(A);
        int N = A.size();
        if (N == 2) {
            return 1000000000;
        }
        
        int p1 = 0; int p2 = 1; int p3 = 2;
        int minDiff = Integer.MAX_VALUE;
        int value = 0;
        while (p3 < N) {
            int sumVal = A.get(p1) + A.get(p2) + A.get(p3);
            int diff = Math.abs(sumVal - B);
            if(minDiff > diff) {
                minDiff = diff;
                value = sumVal;
            }
            p1++; p2++; p3++;
        }
        System.out.println(minDiff + " " + value);
        return value;
    }
    
    // bruteforce - O(N^3)
    public int threeSumClosestN3(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int N = A.size();
        int minVal = Integer.MAX_VALUE;
        int totalSum = 0;
        int allThreeValues = 0;
        for(int i = 0; i < N-2; i++) {
            for(int j = i+1; j < N-1; j++) {
                for(int k = j+1; k < N; k++) {
                    allThreeValues = A.get(i) + A.get(j) + A.get(k);
                    int diff = Math.abs(B - allThreeValues);
                    if(minVal > diff) {
                        minVal = diff;
                        totalSum = allThreeValues;
                    }
                }
            }
        }
        System.out.println(totalSum);
        return totalSum;
    }

    //Incompleted and complicated approach
    public int threeSumClosestBS(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        System.out.println(A);
        int N = A.size();
        System.out.println(A.get(0) + " " +A.get(N/2) + " " + A.get(N-1));

        int p1 = 0; int p2 = 1; int p3 = 2;
        int resultVal = 0;
        for(int i = 0; i < 3; i++) {
            if(i == 0) {
                int[] p3Arr = binarySearch(p1, p2, A, B, p3, N);
                int minResult = p3Arr[0];
                p3 = p3Arr[1];
                if(minResult == B) {
                    resultVal = minResult;
                    break;
                }
                System.out.println(minResult + " " + p3);
            }
            else if (i == 1) {
                int[] p2Arr = binarySearch(p1, p3, A, B, p2, p3);
                int minResult = p2Arr[0];
                p2 = p2Arr[1];
                if(minResult == B) {
                    resultVal = minResult;
                    break;
                }
                System.out.println(minResult + " " + p2);
            }
            else {
                int[] p1Arr = binarySearch(p2, p3, A, B, p1, p2);
                int minResult = p1Arr[0];
                p1 = p1Arr[1];
                if(minResult == B) {
                    resultVal = minResult;
                    break;
                }
                System.out.println(minResult + " " + p1);
            }

            System.out.println("====================");
        }
        System.out.println(p1 + " " + p2 + " " + p3);
        resultVal = A.get(p1) + A.get(p2) + A.get(p3);
        System.out.println("resultVal => " + resultVal);
        return B;
    }
    public int[] binarySearch(int id1, int id2, ArrayList<Integer> A, int B, int strId, int endId) {
        int l = strId;
        int h = endId - 1;
        int index = 0;
        int lessThanOrEqualSum = 0;
        while (l < h) {
            int m = (l+h)/2;
            int sumVal = A.get(id1) + A.get(id2) + A.get(m);
            System.out.println(sumVal + " " + l + " " + h);
            if(sumVal <= B) {
                lessThanOrEqualSum = sumVal;
                index = h;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        int arr[] = new int[2];
        arr[0] = lessThanOrEqualSum;
        arr[1] = index;
        return arr;
    }
    
    
    // Correct approach O(N^2) : Used video explanation ;(
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        System.out.println(A);
        int N = A.size();
        
        int totalSum = 0;
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < N-2; i++) {
            int p1 = i;
            int p2 = i+1;
            int p3 = N - 1;
            while (p2 < p3) {
                int currentSum = A.get(p1) + A.get(p2) + A.get(p3);
                System.out.println(p1 + " " + p2 + " " + p3);
                System.out.println("currentSum = " + currentSum);
                int diff = Math.abs(B - currentSum);
                if(minVal > diff) {
                    minVal = diff;
                    totalSum = currentSum;
                }
                if(currentSum < B) {
                    p2++;
                } else {
                    p3--;
                }
            }
        }
        System.out.println(totalSum);
        return totalSum;
    }
    
    
    public static void main(String[] args) {
        threeSum ts = new threeSum();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-1, 2, 1, -4));
        // int B = 1;

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        // int B = 6;

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3));
        // int B = -1;

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5, -2, -1, -10, 10));
        int B = 5;

        ts.threeSumClosest(A, B);
    }
}
