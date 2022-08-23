import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class studentsMark {

    public ArrayList<String> solve(ArrayList<String> A) {
        int N = A.size();
        
        inBuiltSortComparator inBuilt = new inBuiltSortComparator();
        int[] marks = new int[N]; 
        for (int i = 0; i < N; i++) {
            int lenItem = A.get(i).length();
            String newStr = A.get(i); 
            String newchar = ""; 
            innerLoop:
            for (int j = lenItem - 1; j >= 0; j--) {
                if ((int) newStr.charAt(j) >= 48 && (int) newStr.charAt(j) <= 57) {
                    newchar = newStr.charAt(j) + newchar;
                } else {
                    break innerLoop;
                }
            }
            marks[i] = Integer.parseInt(newchar);
            System.out.println(newchar);
        }
        
        System.out.println(A);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (inBuilt.shouldSwapNew(marks[j], marks[j+1])) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;

                    String swapStr = A.get(j);
                    A.set(j, A.get(j + 1));
                    A.set(j+1, swapStr);
                }
            }
        }
        System.out.println(A);
        return A;
    }
    
    public static void main(String[] args) {
        studentsMark sm = new studentsMark();
        ArrayList<String> A = new ArrayList<String>(Arrays.asList("adarsh9", "harsh95", "shivam95", "hemanth45", "hemathraaj89", "ruchika45"));
        sm.solve(A);
    }
}

class inBuiltSortComparator implements Comparator<Integer> {

    public boolean shouldSwapNew(Integer o1, Integer o2) {
        if (o1 < o2) {
            return true;
        } 
        return false;
    }    

    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }
}