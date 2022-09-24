import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class uniqueElements {
    // Heap Memory error
    public int solveError(ArrayList<Integer> A) {
        Collections.sort(A);
        System.out.println(A);
        System.out.println("=====================");
        int N = A.size();
        int maxV = A.get(N-1);
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        int arK = 0;
        for(int i = 0; i < N-1; i++) {
            System.out.println(A.get(i) + " " + A.get(i+1));
            int curV = A.get(i);
            int nextV = A.get(i+1);
            if(curV == nextV) {
                arrList.add(arK, curV);
                System.out.println("Same => " + curV + " " + nextV);
                arK++;
            }
        }
        System.out.println("arrList => " + arrList);
        System.out.println("==============");

        ArrayList<Integer> leftOutList = new ArrayList<Integer>();
        for(int i = 0; i < N - 1; i++) {
            if(A.get(i) != A.get(i+1)) {
                for(int pt = A.get(i)+1; pt < A.get(i+1); pt++) {
                    leftOutList.add(pt);
                }
            }
        }
        // System.out.println("leftOutList => " + leftOutList);

        int p1 = 0;
        int p2 = 0;
        int lenArrList = arrList.size();
        int lenLeftOutList = leftOutList.size();
        int steps = 0;
        int index = p1;
        while(p1 < lenArrList && p2 < lenLeftOutList) {
            if(arrList.get(p1) < leftOutList.get(p2)) {
                steps += leftOutList.get(p2) - arrList.get(p1);
                index = p1;
                p1++;
            }
            p2++;
        }
        System.out.println(steps);
        System.out.println(index);
        while(p1 < lenArrList) {
            maxV = maxV + 1;
            if(arrList.get(p1) < maxV) {
                steps += maxV - arrList.get(p1);
            }
            p1++;
        }
        System.out.println(steps);
        return steps;
    }
    
    // Working code
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        System.out.println(A);
        int N = A.size();
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < N; i++) {
            hs.add(A.get(i));
        }
        System.out.println(hs);

        int steps = 0;
        int cVal = 0;
        for(int i = 0; i < N-1; i++) {
            int curV = A.get(i);
            int nextV = A.get(i+1);
            if(curV == nextV) {
                System.out.println("curV=> " + curV);
                boolean checkCond = true;
                // because of this line #86 the code worked instead of TLE
                cVal = cVal > curV ? cVal : curV;
                // cVal = curV;
                while (checkCond) {
                    cVal += 1;
                    if(!hs.contains(cVal)) {
                        hs.add(cVal);
                        checkCond = false;
                    }
                }
                steps += cVal - curV;
            }
        }
        System.out.println(steps);
        return steps;
    }
    public static void main(String[] args) {
        uniqueElements ue = new uniqueElements();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3,4,3,4,4,2,6));
        
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(51, 6, 10, 8, 22, 61, 56, 48, 88, 85, 21, 98, 81, 76, 71, 68, 18, 6, 14, 23, 72, 18, 56, 30, 97, 100, 81, 5, 99, 2, 85, 67, 46, 32, 66, 51, 76, 53, 36, 31, 81, 56, 26, 75, 69, 54, 54, 54, 83, 41, 86, 48, 7, 32, 85, 23, 47, 23, 18, 45, 79, 95, 73, 15, 55, 16, 66, 73, 13, 85, 14, 80, 39, 92, 66, 20, 22, 25, 34, 14, 51, 14, 17, 10, 100, 35, 9, 83, 31, 60, 24, 37, 69, 62));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(121, 839, 643, 713, 837, 39, 273, 130, 400, 864, 415, 2, 19, 291, 117, 812, 617, 185, 160, 597, 542, 555, 231, 49, 600, 543, 233, 847, 350, 392, 572, 592, 415, 282, 190, 608, 501, 491, 880, 579, 47, 258, 977, 593, 282, 491, 77, 532, 987, 309, 999, 740, 735, 322, 823, 149, 514, 874, 558, 7, 178, 964, 38, 227, 927, 299, 262, 914, 622, 675, 490, 355, 154, 392, 957, 703, 217, 648, 758, 456, 433, 119, 784, 563, 876, 700, 851, 698, 126, 406, 266, 150, 746, 883, 369, 859, 717, 848, 160, 98, 869, 58, 792, 172, 80, 974, 522, 738, 159, 407, 917, 397, 458, 687, 838, 506, 83, 116, 967, 779, 698, 877, 739, 321, 573, 257, 716, 413, 57, 135, 342, 860, 17, 820, 675, 182, 752, 674, 62, 43, 127, 412, 663, 81, 494, 399, 586, 48, 78, 498, 802, 201, 164, 332, 371, 540, 677, 754, 321, 195, 952, 334, 801, 628, 486, 455, 520, 164, 259, 616, 326, 339, 202, 711, 62, 443, 696, 633, 591, 507, 26, 853, 402, 359, 363, 177, 489, 484, 537, 630, 381, 253, 184, 438, 925, 635, 219, 168, 880, 2, 65, 253, 923, 30, 775, 206, 382, 436, 844, 904, 556, 144, 329));

        // ArrayList<Integer> A = new ArrayList<Integer> (Arrays.asList(1, 1000000, 1000000, 100000000, 10000, 10000, 10000));

        ArrayList<Integer> A = new ArrayList<Integer> (Arrays.asList(19,16,17,17,3,3,7,9,14,16,2,3));

        
        ue.solve(A);
    }
}

// 2, 2, 7, 17, 19, 26, 30, 38, 39, 43, 47, 48, 49, 57, 58, 62, 62, 65, 77, 78, 80, 81, 83, 98, 116, 117, 119, 121, 126, 127, 130, 135, 144, 149, 150, 154, 159, 160, 160, 164, 164, 168, 172, 177, 178, 182, 184, 185, 190, 195, 201, 202, 206, 217, 219, 227, 231, 233, 253, 253, 257, 258, 259, 262, 266, 273, 282, 282, 291, 299, 309, 321, 321, 322, 326, 329, 332, 334, 339, 342, 350, 355, 359, 363, 369, 371, 381, 382, 392, 392, 397, 399, 400, 402, 406, 407, 412, 413, 415, 415, 433, 436, 438, 443, 455, 456, 458, 484, 486, 489, 490, 491, 491, 494, 498, 501, 506, 507, 514, 520, 522, 532, 537, 540, 542, 543, 555, 556, 558, 563, 572, 573, 579, 586, 591, 592, 593, 597, 600, 608, 616, 617, 622, 628, 630, 633, 635, 643, 648, 663, 674, 675, 675, 677, 687, 696, 698, 698, 700, 703, 711, 713, 716, 717, 735, 738, 739, 740, 746, 752, 754, 758, 775, 779, 784, 792, 801, 802, 812, 820, 823, 837, 838, 839, 844, 847, 848, 851, 853, 859, 860, 864, 869, 874, 876, 877, 880, 880, 883, 904, 914, 917, 923, 925, 927, 952, 957, 964, 967, 974, 977, 987, 999