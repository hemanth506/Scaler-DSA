import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class factorsSort {
    public int findFactory (int o1) {
        int ct1 = 0;
        for (int i = 1; i*i <= o1; i++) {
            if (o1%i == 0) {
                System.out.println(i +" " + o1/i);
                if (i == o1/i) {
                    ct1 += 1;
                } else {
                    ct1 += 2;
                }
            }
        }
        System.out.println(ct1);
        return ct1;
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int N = A.size();
        bubbleSort bubble = new bubbleSort();
        for(int i = 0; i < N; i++) {
            System.out.println("==============================");
            for (int j = 0; j < N - 1; j++) {
                // if(A.get(j) < A.get(j + 1)) {
                System.out.println("j => " + A.get(j) + " || j+1 => " + A.get(j+1));
                if(bubble.compareAscending(A.get(j), A.get(j+1))) {
                    int temp = A.get(j);
                    A.set(j, A.get(j+1));
                    A.set(j+1, temp);
                }
            }
            System.out.println(A);
            System.out.println("==============================");
        }
        System.out.println(A);
        return A;
    }
    public static void main(String[] args) {
        factorsSort fs = new factorsSort();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(7, 36, 16, 3, 1, 35, 17));
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(27, 35, 12));
        
        fs.solve(A);
        // fs.findFactory(35);

    }
}

class bubbleSort implements Comparator<Integer>{

    public Boolean compareAscending(Integer o1, Integer o2) {
        int ct1 = 0;
        for (int i = 1; i*i <= o1; i++) {
            if (o1%i == 0) {
                if (i == o1/i) {
                    ct1 += 1;
                } else {
                    ct1 += 2;
                }
            }
        }

        int ct2 = 0;
        for (int i = 1; i*i <= o2; i++) {
            if (o2%i == 0) {
                if (i == o2/i) {
                    ct2 += 1;
                } else {
                    ct2 += 2;
                }
            }
        }

        if (ct1 > ct2) {
            System.out.println(ct1 + " " + ct2 + " = Swap");
            return true;
        } else if (ct1 == ct2) {
            if(o1 > o2) {
                System.out.println(ct1 + " " + ct2 + " " + o1 + " " + o2 + " = Same but swap");
                return true;
            }
        }
        System.out.println(ct1 + " " + ct2 + " " + o1 + " " + o2 + " = No Swap");
        return false;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }
}
