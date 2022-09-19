import java.util.ArrayList;

public class twrsOfHanoi {
    public void towerOfHanoiSeq(int A, int src, int temp, int dest, ArrayList<ArrayList<Integer>> getFinalTxr) {
        if(A == 0) {
            return;
        }
        towerOfHanoiSeq(A - 1, src, dest, temp, getFinalTxr);
        ArrayList<Integer> movement = new ArrayList<Integer>();
        movement.add(A);
        movement.add(src);
        movement.add(dest);
        getFinalTxr.add(movement);
        towerOfHanoiSeq(A - 1, temp, src, dest, getFinalTxr);
    }
    
    public ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        int src = 1;
        int temp = 2;
        int dest = 3;
        ArrayList<ArrayList<Integer>> getFinalTxr = new ArrayList<ArrayList<Integer>>();
        towerOfHanoiSeq(A, src, temp, dest, getFinalTxr);
        return getFinalTxr;
    }
    public static void main(String[] args) {
        twrsOfHanoi toh = new twrsOfHanoi();
        int A = 3;
        System.out.println(toh.towerOfHanoi(A));
    }
}

 /* A = 3
  * [1 1 3 ]
    [2 1 2 ]
    [1 3 2 ]
    [3 1 3 ]
    [1 2 1 ]
    [2 2 3 ]
    [1 1 3 ]
  */