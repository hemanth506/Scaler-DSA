import java.util.Arrays;
import java.util.Comparator;

class sortByStart implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        if (o1[1] > o2[1]) {
            return 1;
        } else if (o1[1] < o2[1]) {
            return -1;
        }
        return 0;
    }
}

public class nonOverLappingIntervals_Q435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int N = intervals.length;
        Arrays.sort(intervals, new sortByStart());
        System.out.println(Arrays.deepToString(intervals));

        int count = 0;
        int end = intervals[0][1];
        for (int i = 1; i < N; i++) {
            int curSt = intervals[i][0];
            int curEnd = intervals[i][1];
            if (end > curSt && end <= curEnd) {
                count += 1;
            } else {
                end = curEnd;
            }
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        nonOverLappingIntervals_Q435 nv = new nonOverLappingIntervals_Q435();
        // int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        // int[][] intervals = { { 1, 2 }, { 1, 2 }, { 1, 2 } };

        int[][] intervals = { { 1, 100 }, { 11, 22 }, { 1, 11 }, { 2, 12 } };
        nv.eraseOverlapIntervals(intervals);
    }
}
