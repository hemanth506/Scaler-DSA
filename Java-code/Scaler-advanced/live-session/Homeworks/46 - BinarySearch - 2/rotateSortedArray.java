import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class rotateSortedArray {

    public int binarySearch(List<Integer> A, int minInd, int maxInd, int B) {
        int firstL = minInd;
        int firstR = maxInd;
        while (firstL <= firstR) {
            int mid = (firstL + firstR) / 2;
            if (A.get(mid) == B) {
                return mid;
            }

            if (A.get(mid) < B) {
                firstL = mid + 1;
            } else if (A.get(mid) > B) {
                firstR = mid - 1;
            }
        }
        return -1; 
    }
    
    public int search(final List<Integer> A, int B) {
        int N = A.size();
        int leftEnd = A.get(0);
        int rightEnd = A.get(N-1);
        if (leftEnd == rightEnd) {
            System.out.println("only one => " + 0);
            return 0;
        }

        if (leftEnd > rightEnd) {
            int l = 1;
            int r = N - 1;
            int maxInd = 0;
            while (l <= r) {
                int m = (l + r) / 2;
                if (A.get(m) < A.get(m-1)) {
                    maxInd = m;
                    break;
                }
    
                if (A.get(m) < leftEnd) {
                    r = m - 1;
                } else if (A.get(m) > rightEnd) {
                    l = m + 1;
                }
            }
    
            // System.out.println(maxInd);
            if(A.get(maxInd) == B) {
                System.out.println("maxInd => " + maxInd);
                return maxInd;
            }
    
            // first Half
            int firstHalf = binarySearch(A, 0, maxInd - 1, B);
            if (firstHalf != -1) {
                System.out.println("firstHalf => " + firstHalf);
                return firstHalf;
            }
            
            // Second Half
            int secondHalf = binarySearch(A, maxInd + 1, N - 1, B);
            if (secondHalf != -1) {
                System.out.println("secondHalf => " + secondHalf);
                return secondHalf;
            }
        } else {
            int fullArr = binarySearch(A, 0, N - 1, B);
            if (fullArr != -1) {
                System.out.println("fullArr => " + fullArr);
                return fullArr;
            }
        }
        System.out.println("Not present");
        return -1;
    }
    public static void main(String[] args) {
        rotateSortedArray ra = new rotateSortedArray();
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(4, 5, 6, 7, 0, 1, 2, 3));
        // int B = 4;
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(1));
        // int B = 1;
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 7, 67, 133, 178));
        // int B = 1;

        List<Integer> A = new ArrayList<Integer>(Arrays.asList(194, 195, 196, 197, 198, 199, 201, 203, 204, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 20, 21, 22, 23, 24, 25, 26, 27, 29, 30, 31, 32, 33, 34, 35, 36, 37, 39, 40, 42, 43, 44, 45, 47, 48, 49, 50, 51, 52, 53, 54, 55, 57, 58, 59, 60, 61, 63, 65, 66, 68, 69, 70, 71, 73, 74, 76, 77, 79, 80, 81, 82, 83, 84, 86, 87, 88, 89, 91, 92, 93, 94, 95, 97, 98, 99, 101, 103, 104, 105, 106, 107, 108, 109, 110, 113, 114, 115, 117, 118, 120, 121, 122, 123, 124, 127, 128, 130, 131, 133, 134, 135, 136, 137, 139, 140, 141, 142, 143, 144, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 158, 159, 160, 161, 162, 163, 164, 166, 167, 169, 170, 171, 172, 174, 175, 177, 178, 179, 181, 182, 184, 185, 187, 189, 190, 192, 193));
        int B = 1;
        ra.search(A, B);
    }
}
