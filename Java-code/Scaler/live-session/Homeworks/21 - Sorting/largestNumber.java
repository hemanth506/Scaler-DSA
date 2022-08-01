import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class largestNumber {
    public String largestNumb(final List<Integer> A) {
        List<Integer> B = new ArrayList<Integer>(A);
        largestComparator lg = new largestComparator();
        int N = B.size();
        int previousVal = B.get(0);
        if(previousVal == 0) {
            int count = 0;
            for (int value: B){
                if(value == 0) {
                    count += 1;
                }
            }

            if(count == N) {
                return "0";
            }
        }
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                String a = B.get(j) + "" + B.get(j+1);
                String b = B.get(j+1) + "" + B.get(j);

                long parseA = Long.parseLong(a.trim());
                long parseB = Long.parseLong(b.trim());

                // if(parseA < parseB) {
                if(lg.compareString(parseA, parseB)) {
                    int temp = B.get(j);
                    B.set(j, B.get(j+1));
                    B.set(j+1, temp);

                }
            }

        }
        System.out.println(B);
        String finalStr = "";
        for(int value: B){
            finalStr += value + "";
        }
        System.out.println(finalStr);
        return finalStr;
    }
    public static void main(String[] args) {
        largestNumber lg = new largestNumber();
        List<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 30, 34, 5, 9));
        lg.largestNumb(A);

    }
}

class largestComparator implements Comparator<Integer> {

    public boolean compareString(Long A, Long B) {
        if (A < B) {
            return true;
        }
        return false;
    }


    @Override
    public int compare(Integer A, Integer B) {
        
        return 0;
    }
}

    