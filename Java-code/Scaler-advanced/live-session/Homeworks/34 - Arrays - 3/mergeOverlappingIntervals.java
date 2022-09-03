import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

// sort the intervals with the start attribute and then return the merged overlapping intervals 
public class mergeOverlappingIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        int N = intervals.size();
        ArrayList<Interval> fIntervals = new ArrayList<Interval>();
        if (N == 0) {
            return fIntervals;
        }

        Collections.sort(intervals, new inBuiltSortComparator());

        int a = intervals.get(0).start;
        int b = intervals.get(0).end;
        for(int i = 0; i < N; i++) {
            int curStart = intervals.get(i).start;
            int curEnd = intervals.get(i).end;
            if ((a <= curStart && b >= curStart) || (a <= curEnd && b >= curEnd)) {
                a = Integer.min(a, curStart);
                b = Integer.max(b, curEnd);
            } else {
                Interval tempIntervals = new Interval(a, b);
                fIntervals.add(tempIntervals);
                a = curStart;
                b = curEnd;
            }
        }
        Interval tempIntervals = new Interval(a, b);
        fIntervals.add(tempIntervals);

        System.out.println("-------------");
        for (int j = 0; j < fIntervals.size(); j++) {
            System.out.println("List items => " + fIntervals.get(j).start + " " + fIntervals.get(j).end);
        }
        return fIntervals;
    }

    public static void main(String[] args) {
        mergeOverlappingIntervals mg = new mergeOverlappingIntervals();

        ArrayList<Interval> intervals = new ArrayList<Interval>();
        // intervals.add(new Interval(1, 10));
        // intervals.add(new Interval(2, 9));
        // intervals.add(new Interval(3, 8));
        // intervals.add(new Interval(4, 7));
        // intervals.add(new Interval(5, 6));
        // intervals.add(new Interval(6, 6));

        intervals.add(new Interval(5,6));
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));


        mg.merge(intervals);
    }
}

class inBuiltSortComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval c1, Interval c2) {
        if (c1.start > c2.start) return 1;
        if (c1.start < c2.start) return -1;
        return 0;
    }
}