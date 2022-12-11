import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Pair {
    int st;
    int ed;
    Pair(int s, int e) {
        this.st = s;
        this.ed = e;
    }
}

class sortPair implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return o1.ed - o2.ed;
    }
}


public class findMaxiJobs {

    public void print(int N, ArrayList<Pair> pr) {
        for(int i = 0; i < N; i++) {
            Pair cr = pr.get(i);
            System.out.println(cr.st + " " + cr.ed);
        }
    } 
    
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int N = A.size();
        ArrayList<Pair> pr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            Pair p = new Pair(A.get(i), B.get(i));
            pr.add(p);
        }

        Collections.sort(pr, new sortPair());
        print(N, pr);
        
        Pair firstPair = pr.get(0);
        int pairSt = firstPair.ed;
        int ct = 1;
        for(int i = 1; i < N; i++) {
            Pair curPair = pr.get(i);
            int curSt = curPair.st;
            if(pairSt <= curSt) {
                ct += 1;
                pairSt = curPair.ed;
            }
        }
        System.out.println(ct);

        return ct;
    }
    public static void main(String[] args) {
        findMaxiJobs fm = new findMaxiJobs();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,0,8,5,5,3));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(2,6,9,7,9,4));
        
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 5, 7, 1));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(7, 8, 8, 8));
        

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 2, 6));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(9, 8, 9));
        
        fm.solve(A, B);
    }
}
