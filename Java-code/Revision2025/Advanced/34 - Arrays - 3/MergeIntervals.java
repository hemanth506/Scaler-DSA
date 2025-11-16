import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        // intervals.add(new Interval(1, 3));
        // intervals.add(new Interval(2, 5));
        // intervals.add(new Interval(6, 7));
        // intervals.add(new Interval(10, 11));
        // intervals.add(new Interval(15, 18));
        // intervals.add(new Interval(16, 17));
        // Interval newInterval = new Interval(8, 9);

        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 4));
        intervals.add(new Interval(5, 6));
        Interval newInterval = new Interval(4, 5);

        MergeIntervals mi = new MergeIntervals();
        for (Interval interval : mi.insert(intervals, newInterval)) {
            System.out.println(interval.start + " " + interval.end);
        }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int N = intervals.size();
        ArrayList<Interval> result = new ArrayList<>();
        boolean merged = false;
        for (int i = 0; i < N; i++) {
            Interval cur = intervals.get(i);
            if (cur.end < newInterval.start) {
                result.add(cur);
            } else if (cur.end >= newInterval.start & (cur.start < newInterval.start || cur.start <= newInterval.end)) {
                newInterval.start = Math.min(cur.start, newInterval.start);
                newInterval.end = Math.max(cur.end, newInterval.end);
            } else {
                if (!merged) {
                    result.add(newInterval);
                    merged = true;
                }
                result.add(cur);
            }
        }

        if (!merged) {
            result.add(newInterval);
        }
        return result;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}