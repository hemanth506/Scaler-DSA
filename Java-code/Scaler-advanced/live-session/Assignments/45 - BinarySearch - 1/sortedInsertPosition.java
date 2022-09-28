import java.util.ArrayList;
import java.util.Arrays;

public class sortedInsertPosition {
    public int searchInsert(ArrayList<Integer> A, int B) {
        int N = A.size();
        int l = 0;
        int h = N - 1;
        int ans = 0;
        while (l <= h) {
            int m = (l + h) / 2;
            if(A.get(m) == B) {
                System.out.println("found in " + m);
                return m;
            }

            if (A.get(m) < B) {
                l = m + 1;
                ans = l;
                System.out.println("less than " + l + " " + m + " " + h);
            } else if (A.get(m) > B) {
                h = m - 1;
                ans = l;
                System.out.println("greated than " + l + " " + m + " " + h);
            }
        }
        System.out.println("not present "+ ans);
        return ans;
    }
    public static void main(String[] args) {
        sortedInsertPosition si = new sortedInsertPosition();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,3,5,6,7,8,12,14,15));
        // int B = 11;
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,3,5,7));
        // int B = 8;

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 4, 18, 19, 20, 27, 28, 31, 36, 42, 44, 71, 72, 75, 82, 86, 88, 97, 100, 103, 105, 107, 110, 116, 118, 119, 121, 122, 140, 141, 142, 155, 157, 166, 176, 184, 190, 199, 201, 210, 212, 220, 225, 234, 235, 236, 238, 244, 259, 265, 266, 280, 283, 285, 293, 299, 309, 312, 317, 335, 341, 352, 354, 360, 365, 368, 370, 379, 386, 391, 400, 405, 410, 414, 416, 428, 433, 437, 438, 445, 453, 457, 458, 472, 476, 480, 485, 489, 491, 493, 501, 502, 505, 510, 511, 520, 526, 535, 557, 574, 593, 595, 604, 605, 612, 629, 632, 633, 634, 642, 647, 653, 654, 656, 658, 686, 689, 690, 691, 709, 716, 717, 737, 738, 746, 759, 765, 775, 778, 783, 786, 787, 791, 797, 801, 806, 815, 820, 822, 823, 832, 839, 841, 847, 859, 873, 877, 880, 886, 904, 909, 911, 917, 919, 937, 946, 948, 951, 961, 971, 979, 980, 986, 993));
        int B = 902;
        si.searchInsert(A, B);
    }
}
