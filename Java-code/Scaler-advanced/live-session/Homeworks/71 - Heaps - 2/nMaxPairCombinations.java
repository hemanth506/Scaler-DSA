import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

class InnerPair {
    int ind1;
    int ind2;
    InnerPair(int a, int b){
        this.ind1 = a;
        this.ind2 = b;
    }
}

class Pair {
    int mVal;
    InnerPair newPair;
    Pair(int val, int id1, int id2) {
        this.mVal = val;
        this.newPair = new InnerPair(id1, id2);
    } 
}

class comparePair implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return Integer.compare(o2.mVal, o1.mVal);
    }
    
}

public class nMaxPairCombinations {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int N = A.size();
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B, Collections.reverseOrder());
        ArrayList<Integer> res = new ArrayList<>();
        
        int maxV = A.get(0) + B.get(0);
        Pair p = new Pair(maxV, 0, 0);
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new comparePair());
        maxHeap.add(p);
        

        HashSet<String> hs = new HashSet<>();
        hs.add(Integer.toString(0)+"_"+Integer.toString(0));

        while (!maxHeap.isEmpty()) {
            Pair curMaxPair = maxHeap.poll();
            System.out.println("=====" + curMaxPair.mVal + " " + curMaxPair.newPair.ind1 + " " + curMaxPair.newPair.ind2 + "=====");
            res.add(curMaxPair.mVal);
            if(res.size() == N) {
                break;
            }

            int left = curMaxPair.newPair.ind1;
            int leftPlusOne = curMaxPair.newPair.ind1+1;
            int right = curMaxPair.newPair.ind2;
            int rightPlusOne = curMaxPair.newPair.ind2+1;

            // StringBuilder sb1 = new StringBuilder();
            // sb1.append(Integer.toString(left));
            // sb1.append('_');
            // sb1.append(Integer.toString(rightPlusOne));
            String str1 = Integer.toString(left)+"_"+Integer.toString(rightPlusOne);
            if(!hs.contains(str1)) {
                int cv1 = A.get(left) + B.get(rightPlusOne);
                System.out.println("sb1 ---------" + cv1 + " " + left + " " + rightPlusOne + "---------");
                Pair curPair1 = new Pair(cv1, left, rightPlusOne);
                maxHeap.add(curPair1);
                hs.add(str1);
            }

            // StringBuilder sb2 = new StringBuilder();
            // sb2.append(Integer.toString(leftPlusOne));
            // sb2.append('_');
            // sb2.append(Integer.toString(right));
            String str2 = Integer.toString(leftPlusOne) + "_" + Integer.toString(right);
            if(!hs.contains(str2)) {
                int cv2 = A.get(leftPlusOne) + B.get(right);
                System.out.println("sb2 ---------" + cv2 + " " + leftPlusOne + " " + right + "---------");
                Pair curPair2 = new Pair(cv2, leftPlusOne, right);
                maxHeap.add(curPair2);
                hs.add(str2);
            }

            
        }
        
        System.out.println(res);
        return res;
    }
    public static void main(String[] args) {
        nMaxPairCombinations nMax = new nMaxPairCombinations();
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 4, 2, 3));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(2, 5, 1, 6));
        
        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 4, 1, 1));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(-2, -3, 2, 4));
        

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3,4));
        // ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(3,4));
        

        
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(36, 27, -35, 43, -15, 36, 42, -1, -29, 12, -23, 40, 9, 13, -24, -10, -24, 22, -14, -39, 18, 17, -21, 32, -20, 12, -27, 17, -15, -21, -48, -28, 8, 19, 17, 43, 6, -39, -8, -21, 23, -29, -31, 34, -13, 48, -26, -35, 20, -37, -24, 41, 30, 6, 23, 12, 20, 46, 31, -45, -25, 34, -23, -14, -45, -4, -21, -37, 7, -26, 45, 32, -5, -36, 17, -16, 14, -7, 0, 37, -42, 26, 28));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(38, 34, -47, 1, 4, 49, -18, 10, 26, 18, -11, -38, -24, 36, 44, -11, 45, 20, -16, 28, 17, -49, 47, -48, -33, 42, 2, 6, -49, 30, 36, -9, 15, 39, -6, -31, -10, -21, -19, -33, 47, 21, 31, 25, -41, -23, 17, 6, 47, 3, 36, 15, -44, 33, -31, -26, -22, 21, -18, -21, -47, -31, 20, 18, -42, -35, -10, -1, 46, -27, -32, -5, -4, 1, -29, 5, 29, 38, 14, -22, -9, 0, 43));


        nMax.solve(A, B);
    }
}
