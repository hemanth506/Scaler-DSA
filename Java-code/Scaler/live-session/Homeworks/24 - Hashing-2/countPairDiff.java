/*
 * should check for both A[i] + B and A[i] - B, because it may have from added value and the subtracted value in the hashmap
== B=4 ==
A = [3,11,7]

------ i = 3 ------
x-3=4
x=7; 
ans=0; [7 is not present]
3-x=4
x=-1;
ans=0; [-1 is not present]
hm = {3: 1}

------ i = 11 ------
x-11=4;
x=15;
ans = 0; [15 is not present]
11-x=4;
x=7;
ans=0; [7 is not present]
hm = {3: 1, 11: 1}

------ i = 7 ------
x-7=4;
x=11;
ans=1; [11 is present]
7-x=4;
x=3;
ans=2; [3 is present]

2 pairs - {3,7} {11,7}
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class countPairDiff {
    public int solveBruteForce(ArrayList<Integer> A, int B) {
        int N = A.size();

        int ct = 0; 
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if(A.get(i) - A.get(j) == B) {
                    ct += 1;
                    System.out.println(A.get(i) + " " + A.get(j) + " => " + ct);
                }
            }
        }
        System.out.println(ct);
        return ct;
    }

    public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        int ct = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < N; i++) {
            int a = A.get(i); 
            int b = a - B;
            int c = a + B;
            if (hm.containsKey(b)) {
                ct += hm.get(b);
            } else if (hm.containsKey(c)) {
                ct += hm.get(c);
            }
            System.out.println(a + " = contains =>  " + b);
            if(hm.containsKey(a)) {
                int val = hm.get(a) + 1;
                hm.put(a, val);
            } else {
                hm.put(a , 1);
            }
            System.out.println("hm => " + hm);
            System.out.println("ct => " + ct);
        }
        System.out.println(ct);
        return ct;
    }

    
    public static void main(String[] args) {
        countPairDiff ctDiff = new countPairDiff();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 5, 1, 2));
        int B = 4;
        ctDiff.solve(A, B);
    }
}
