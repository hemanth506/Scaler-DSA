import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class largestNumberInbuiltSort {
    public String largestNumber(final List<Integer> A) {

        Collections.sort(A, new inBuiltSortComparator());

        // Otherwise it would return multiple zeros (equal to the length of given array); but the requirement of test case is to just return a single zero if the answer is zero
        if(A.get(0).equals(0)) {
            return "0";   
        }
        
        StringBuilder stbr = new StringBuilder();
        for(int i =0;i<A.size();i++) {
            stbr.append(A.get(i));
        }
        System.out.println(stbr.toString());
        return stbr.toString();
    }
    public static void main(String[] args) {
        largestNumberInbuiltSort lgin = new largestNumberInbuiltSort();
        List<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 30, 34, 5, 9));
        lgin.largestNumber(A);
    }
}

class inBuiltSortComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        String first = String.valueOf(o1) + String.valueOf(o2);
        String second = String.valueOf(o2) + String.valueOf(o1);
        return second.compareTo(first);
    }
}
