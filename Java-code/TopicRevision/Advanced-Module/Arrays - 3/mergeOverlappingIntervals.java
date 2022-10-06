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

class interValSort implements Comparator<Interval> {

    @Override
    public int compare(Interval o1, Interval o2) {
        if(o1.start < o2.start) {
            return -1;
        } else if (o1.start > o2.start){
            return 1;
        }
        return 0;
    }
    
}

public class mergeOverlappingIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        int N = intervals.size();
        ArrayList<Interval> finalIntervals = new ArrayList<Interval>();

        Collections.sort(intervals, new interValSort());

        int mergeSt = intervals.get(0).start;
        int mergeEn = intervals.get(0).end;
        for(int i = 1; i < N; i++) {
            int intStart = intervals.get(i).start;
            int intEnd = intervals.get(i).end;

            if (intStart < mergeEn) {
                mergeEn = Integer.max(intEnd, mergeEn);
            } else {
                Interval inter = new Interval(mergeSt, mergeEn);
                finalIntervals.add(inter);
                mergeSt = intStart;
                mergeEn = intEnd;
            }
        }
        Interval inter = new Interval(mergeSt, mergeEn);
        finalIntervals.add(inter);

        for (int j = 0; j < finalIntervals.size(); j++) {
            System.out.println("List items => " + finalIntervals.get(j).start + " " + finalIntervals.get(j).end);
        }
        return finalIntervals;
    }

    public static void main(String[] args) {
        mergeOverlappingIntervals mg = new mergeOverlappingIntervals();
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        // intervals.add(new Interval(1,3));
        // intervals.add(new Interval(2,6));
        // intervals.add(new Interval(8,10));
        // intervals.add(new Interval(15,18));
        // intervals.add(new Interval(16,21));
        // [1,3],[2,6],[8,10],[15,18]


        // intervals.add(new Interval(1, 10));
        // intervals.add(new Interval(2, 9));
        // intervals.add(new Interval(3, 8));
        // intervals.add(new Interval(4, 7));
        // intervals.add(new Interval(5, 6));
        // intervals.add(new Interval(6, 6));
        // (1, 10), (2, 9), (3, 8), (4, 7), (5, 6), (6, 6)


        intervals.add(new Interval(6, 6));
        intervals.add(new Interval(3, 8));
        intervals.add(new Interval(1, 10));
        intervals.add(new Interval(4, 7));
        intervals.add(new Interval(5, 6));
        intervals.add(new Interval(2, 9));


        
        mg.merge(intervals);
    }
}
