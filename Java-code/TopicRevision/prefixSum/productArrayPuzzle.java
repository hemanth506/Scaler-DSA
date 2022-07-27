import java.util.ArrayList;
import java.util.Arrays;

public class productArrayPuzzle {
    
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int N = A.size();
        int product = A.get(0);
        for (int i = 1; i < N; i++) {
            product *= A.get(i);
        }

        ArrayList<Integer> prod = new ArrayList<Integer>();
        for (int j = 0; j < N; j++) {
            prod.add(product / A.get(j));
        }
        System.out.println(prod);
        return prod;
    }

    public ArrayList<Integer> solveNoDiviOperator(ArrayList<Integer> A) {
        int N = A.size();

        int[] l = new int[N];
        int temp = 1;
        l[0] = temp;
        for (int i = 0; i < N - 1; i++) {
            l[i + 1] = temp * A.get(i);
            temp = l[i + 1];
        }
        System.out.println(Arrays.toString(l));

        int[] r = new int[N];
        int temp2 = 1;
        r[N - 1] = temp2;
        for(int j = N - 1; j >=1 ; j--) {
            r[j - 1] = temp2 * A.get(j);
            temp2 = r[j - 1];
        } 
        System.out.println(Arrays.toString(r));

        ArrayList<Integer> product = new ArrayList<Integer>();
        for (int k = 0; k < N; k++) {
            product.add(l[k] * r[k]);
        }
        System.out.println(product);
        return product;
    }

    
    
    public static void main(String[] args) {
        productArrayPuzzle pd = new productArrayPuzzle();

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        pd.solveNoDiviOperator(A);
        

    }
}
