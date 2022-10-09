import java.util.ArrayList;
//  Refer practise code for better logic and understanding.
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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int N = intervals.size();
        int mergeStart = Integer.min(newInterval.start, newInterval.end);
        int mergeEnd = Integer.max(newInterval.start, newInterval.end);
        
        boolean firstTime = false;
        boolean existAftrInterval = false;
        boolean alreadyAdded = false;
        ArrayList<Interval> finalInter = new ArrayList<Interval>();
        Interval tempInter;

        // Separate from all the intervals
        if (N == 0 || mergeEnd < intervals.get(0).end) {
            tempInter = new Interval(mergeStart, mergeEnd);
            finalInter.add(tempInter);
            alreadyAdded = true;
            if (N == 0) {
                return finalInter;
            }
        }

        for (int i = 0; i < N; i++) {
            int intStart = intervals.get(i).start;
            int intEnd = intervals.get(i).end;

            // Before point
            if(intEnd < mergeStart) {
                // System.out.println("Before");
                tempInter = new Interval(intStart, intEnd);
                finalInter.add(tempInter);
            } 
            else if (intEnd >= mergeStart) {
                System.out.println(mergeEnd + "  " + intEnd);
                // after point
                if (intStart > mergeEnd) {
                    if (firstTime || (!alreadyAdded && mergeEnd < intEnd)) {
                        tempInter = new Interval(mergeStart, mergeEnd);
                        finalInter.add(tempInter);
                        alreadyAdded = true;
                    }
                    tempInter = new Interval(intStart, intEnd);
                    finalInter.add(tempInter);
                    firstTime = false;
                    existAftrInterval = true;
                }
                // merge point
                else {
                    mergeStart = Integer.min(mergeStart, intStart);
                    mergeEnd = Integer.max(mergeEnd, intEnd);
                    firstTime = true;
                }
            }
        }
        if (!existAftrInterval) {
            tempInter = new Interval(mergeStart, mergeEnd);
            finalInter.add(tempInter);
        }
        // System.out.println(finalInter);

        System.out.println("-------------");
        for (int j = 0; j < finalInter.size(); j++) {
            System.out.println("List items => " + finalInter.get(j).start + " " + finalInter.get(j).end);
        }

        return finalInter;
    }

    public static void main(String[] args) {
        mergeIntervals mg = new mergeIntervals();

        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));
        Interval newInterval = new Interval(2, 5);

        // ArrayList<Interval> intervals = new ArrayList<Interval>();
        // intervals.add(new Interval(1,3));
        // intervals.add(new Interval(6,9));
        // Interval newInterval = new Interval(2,6);

        // ArrayList<Interval> intervals = new ArrayList<Interval>();
        // intervals.add(new Interval(1, 2));
        // intervals.add(new Interval(3, 6));
        // Interval newInterval = new Interval(10, 8);

        // ArrayList<Interval> intervals = new ArrayList<Interval>();
        // intervals.add(new Interval(1, 3));
        // intervals.add(new Interval(4,7));
        // intervals.add(new Interval(10,14));
        // intervals.add(new Interval(16,19));
        // intervals.add(new Interval(21,24));
        // intervals.add(new Interval(27,30));
        // intervals.add(new Interval(32,35));
        // intervals.add(new Interval(36,40));
        // Interval newInterval = new Interval(12, 22);

        // ArrayList<Interval> intervals = new ArrayList<Interval>();
        // intervals.add(new Interval(3, 6));
        // intervals.add(new Interval(8, 10));
        // Interval newInterval = new Interval(1, 2);

        // ArrayList<Interval> intervals = new ArrayList<Interval>();
        // Interval newInterval = new Interval(1, 1);

        // ArrayList<Interval> intervals = new ArrayList<Interval>();
        // intervals.add(new Interval(1,2));
        // intervals.add(new Interval(8, 10));
        // Interval newInterval = new Interval(3, 6);

        mg.insert(intervals, newInterval);
    }
}
