import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class singleNumber{

    int number(final List<Integer> A) {
        System.out.println(A);
        int unique = 0;
        for(int i = 0 ; i < A.size(); i++) {
            unique ^= A.get(i);
        }
        return unique;
    }
    public static void main(String[] args) {
        singleNumber num = new singleNumber();

        List<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,2,3,1));
        System.out.println(num.number(A));
    }
}