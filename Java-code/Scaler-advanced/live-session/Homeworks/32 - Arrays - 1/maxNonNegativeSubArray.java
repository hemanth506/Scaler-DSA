import java.util.ArrayList;
import java.util.Arrays;

public class maxNonNegativeSubArray {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        int N = A.size();
        System.out.println(A);
        System.out.println("===================================");
        
        long total;
        int arrLength;
        long maxTotal = 0;
        int maxArrLength = 0;
        int startingIndex = -1;
        int endingIndex = -1;
        for (int i = 0; i < N; i++) {
            if (A.get(i) < 0) {
                if (i != 0) {
                    total = 0;
                    arrLength = 0;
                    int j;
                    innerLoop: for (j = i - 1; j >= 0; j--) {
                        if (A.get(j) < 0) {
                            break innerLoop;
                        }
                        total += A.get(j);
                        arrLength += 1;
                    }

                    if (total > maxTotal) {
                        maxTotal = total;
                        maxArrLength = arrLength;
                        // System.out.println("starting ind => " + (j + 1) + " val => " + A.get(j + 1));
                        // System.out.println("ending ind => " + (i - 1) + " val => " + A.get(i - 1));
                        startingIndex = j + 1;
                        endingIndex = i - 1;
                    } else if (total == maxTotal) {
                        maxTotal = total;
                        if (arrLength > maxArrLength) {
                            maxArrLength = arrLength;
                            // System.out.println("starting ind => " + (j + 1) + " val => " + A.get(j + 1));
                            // System.out.println("ending ind => " + (i - 1) + " val => " + A.get(i - 1));
                            startingIndex = j + 1;
                            endingIndex = i - 1;
                        }
                    }
                    // System.out.println("total => " + total + " " + maxTotal);
                    // System.out.println("length => " + arrLength + " " + maxArrLength);
                }
                // System.out.println("===================================");
            }
        }

        total = 0;
        arrLength = 0;
        int i;
        for (i = N - 1; i >= 0; i--) {
            if (A.get(i) < 0) {
                break;
            } else {
                total += A.get(i);
            }
            arrLength += 1;
        }

        if (total > maxTotal) {
            maxTotal = total;
            maxArrLength = arrLength;
            // System.out.println("starting ind => " + (i + 1) + " val => " + A.get(i + 1));
            // System.out.println("ending ind => " + (N - 1) + " val => " + A.get(N - 1));
            // System.out.println("total => " + total + " " + maxTotal);
            // System.out.println("length => " + arrLength + " " + maxArrLength);
            startingIndex = i + 1;
            endingIndex = N - 1;

        } else if (total == maxTotal) {
            maxTotal = total;
            if (arrLength > maxArrLength) {
                maxArrLength = arrLength;
                // System.out.println("starting ind => " + (i + 1) + " val => " + A.get(i + 1));
                // System.out.println("ending ind => " + (N - 1) + " val => " + A.get(N - 1));
                // System.out.println("total => " + total + " " + maxTotal);
                // System.out.println("length => " + arrLength + " " + maxArrLength);
                startingIndex = i + 1;
                endingIndex = N - 1;
            }
        }

        ArrayList<Integer> subArray = new ArrayList<Integer>();
        if (startingIndex != -1 && endingIndex != -1) {
            for (int k = startingIndex; k <= endingIndex; k++) {
                subArray.add(A.get(k));
            }
        }
        System.out.println(subArray);
        return subArray;
    }

    public static void main(String[] args) {
        maxNonNegativeSubArray mn = new maxNonNegativeSubArray();

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 5, -7, 2, 3, -1, 1, -3, -2, 1, 4, 1, 1, 1, -5, 1, 1, 4, 1, 1));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(10, -1, 2, 3, -4,
        // 100));

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368));
        mn.maxset(A);
    }
}
