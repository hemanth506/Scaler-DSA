import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class largeNumber {
    static int modV = 0;
    public String largestNumberWrongOutput(final List<Integer> A) {
        int N = A.size();
        int maxV = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            maxV = Integer.max(maxV, A.get(i));
        }
        System.out.println(maxV);
        if(maxV == 0) {
            return "0";
        }

        int ct = 1;
        while(maxV > 0) {
            modV = ct;
            maxV /= 10;
            ct *= 10;
        }
        System.out.println(modV);

        Collections.sort(A, new compareLargeNum());
        System.out.println(A);

        StringBuilder st = new StringBuilder();
        for(int i = 0; i < N; i++) {
            st.append(A.get(i));
        }

        System.out.println(st);
        return st.toString();
    }

    public String largestNumber(final List<Integer> A) {
        Collections.sort(A, new checkLargeNum());

        if(A.get(0).equals(0)) {
            return "0";
        }

        int N = A.size();
        StringBuilder st = new StringBuilder();
        for(int i = 0; i < N; i++) {
            st.append(A.get(i));
        }

        System.out.println(st);
        return st.toString();
    }
    
    public static void main(String[] args) {
        largeNumber lg = new largeNumber();
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 30, 34, 5, 9));
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(8, 89));
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
        // List<Integer> A = new ArrayList<Integer>(Arrays.asList(12, 121));

        List<Integer> A = new ArrayList<Integer>(Arrays.asList(416, 103, 352, 580, 368, 355, 698, 681, 415, 532, 588, 69, 457, 450, 722, 984, 61, 204, 115, 571, 754, 887, 682, 966, 259, 462, 954, 806, 665, 914, 313, 733, 130, 894, 308, 154, 36, 156, 843, 4, 765, 354, 285, 883, 931, 383, 919, 280, 393, 480, 492, 531, 541, 361, 320, 665, 450, 899, 65, 768, 241, 581, 630, 541, 547, 907, 660, 604, 341, 720, 668, 476, 795, 488, 881, 323, 612, 645, 112, 790, 749, 52, 245, 29, 937, 367, 911, 374, 44, 426, 577));

        lg.largestNumber(A);
    }
}

class compareLargeNum implements Comparator<Integer> {
    // largeNumber lg = new largeNumber();
    // int modVal = largeNumber.modV;
    @Override
    public int compare(Integer o1, Integer o2) {
        // System.out.println(modVal);
        int newModV = 10;
        int o1Mod = o1/newModV;
        int o2Mod = o2/newModV;

        if(o1Mod <= o2Mod) {
            return 1;
        } else if (o1Mod > o2Mod) {
            return -1;
        }
        return 0;
    } 
}

class checkLargeNum implements Comparator<Integer> {
    // largeNumber lg = new largeNumber();
    // int modVal = largeNumber.modV;
    @Override
    public int compare(Integer o1, Integer o2) {
        // System.out.println(modVal);
        String A = String.valueOf(o1) + String.valueOf(o2);
        String B = String.valueOf(o2) + String.valueOf(o1);

        return B.compareTo(A);

    } 
}

