import java.util.ArrayList;

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

public class mergeIntervals {
    int mergeStart = 0;
    int mergeEnd = 0;

    public void pushElt(ArrayList<Interval> newArrayIntervals, int start, int end) {
        Interval newInt = new Interval(start, end);
        newArrayIntervals.add(newInt);
    }

    public boolean checkForMerge(int ms, int me, int cs, int ce) {
        if (cs <= ms && me <= ce) {
            return true;
        } else if (ms >= cs && ce <= me && ms <= ce) {
            return true;
        } else if (ms <= cs && cs <= me) {
            return true;
        } else if (cs <= ms && ms <= ce) {
            return true;
        }
        return false;
    }

    public void getStartEnd(int ms, int me, int cs, int ce) {
        mergeStart = Integer.min(ms, cs);
        mergeEnd = Integer.max(me, ce);
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int N = intervals.size();
        ArrayList<Interval> newArrayIntervals = new ArrayList<Interval>();

        // Reason for this => new Interval(10, 6);
        mergeStart = Integer.min(newInterval.start, newInterval.end);
        mergeEnd = Integer.max(newInterval.start, newInterval.end);

        if (N == 0) {
            pushElt(newArrayIntervals, mergeStart, mergeEnd);
        }

        boolean touched = false;
        boolean finalTouch = false;
        for (int i = 0; i < N; i++) {
            int curStart = intervals.get(i).start;
            int curEnd = intervals.get(i).end;

            boolean toMerge = checkForMerge(mergeStart, mergeEnd, curStart, curEnd);
            // System.out.println(mergeStart + " " + mergeEnd + " " + curStart + " " + curEnd + " toMerge = " + toMerge);
            if (toMerge) {
                getStartEnd(mergeStart, mergeEnd, curStart, curEnd);
                finalTouch = true;
            } else {
                if (mergeEnd <= curStart && mergeStart <= curEnd && !touched) {
                    pushElt(newArrayIntervals, mergeStart, mergeEnd);
                    touched = true;
                }
                pushElt(newArrayIntervals, curStart, curEnd);
                finalTouch = false;
            }
        }
        // Will check if the last mergeStart and mergeEnd is pushed or not.
        if (finalTouch) {
            pushElt(newArrayIntervals, mergeStart, mergeEnd);
        }

        int newN = newArrayIntervals.size();
        if (newArrayIntervals.get(newN - 1).end < mergeStart) {
            pushElt(newArrayIntervals, mergeStart, mergeEnd);
        }

        // -------------- the below code if for testing ----------------------
        for (int i = 0; i < newArrayIntervals.size(); i++) {
            System.out.println(newArrayIntervals.get(i).start + " " + newArrayIntervals.get(i).end);
        }
        // -------------------------------------------------------------------

        return newArrayIntervals;
    }

    public static void main(String[] args) {
        mergeIntervals mg = new mergeIntervals();
        ArrayList<Interval> intervals = new ArrayList<Interval>();

        // intervals.add(new Interval(1, 3));
        // intervals.add(new Interval(6, 9));
        // Interval newInterval = new Interval(2, 5);

        // intervals.add(new Interval(1, 2));
        // intervals.add(new Interval(3, 6));
        // Interval newInterval = new Interval(10, 6);

        // intervals.add(new Interval(1, 3));
        // intervals.add(new Interval(4, 7));
        // intervals.add(new Interval(10,14));
        // intervals.add(new Interval(16, 19));
        // intervals.add(new Interval(21, 24));
        // intervals.add(new Interval(27, 30));
        // intervals.add(new Interval(32, 35));
        // intervals.add(new Interval(36, 40));
        // Interval newInterval = new Interval(12, 22);

        Interval newInterval = new Interval(10, 6);

        mg.insert(intervals, newInterval);
    }
}