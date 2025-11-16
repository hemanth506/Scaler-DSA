import java.util.*;

public class SortByFactors {
    public static void main(String[] args) {
        SortByFactors sort = new SortByFactors();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(12, 18, 15, 1, 36));
        System.out.println(sort.solve(A));
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collections.sort(A, new BubbleSortComp() );
        return A;
    } 
}

class BubbleSortComp implements Comparator<Integer> {

    public int countFactors(int elt) {
        int ct = 0;
        for (int i = 1; i * i <= elt; i++) {
            if (elt % i == 0) {
                if (i == elt / i) {
                    ct += 1;
                } else {
                    ct += 2;
                }
            }
        }
        return ct;
    }

    public int compare2(Integer o1, Integer o2) {
        String first = o1 + "" + o2;
        String second = o2 + "" + o1;
        return second.compareTo(first);
    }

    @Override
    public int compare(Integer val1, Integer val2) {
        int count1 = countFactors(val1);
        int count2 = countFactors(val2);
        if(count1 == count2){
            return val1 - val2;
        }
        return count1 - count2;
    }    
}