import java.util.ArrayList;
import java.util.Arrays;

public class maximumPositivity {
    ArrayList<Integer> solve(ArrayList<Integer> A) {

        int N = A.size();
        if(N == 1 & A.get(0) > 0) {
            return A;
        }

        int arraySize = 0;
        int lastNegativeIndex = 0;
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for(int i = 0; i < N; i++) {
            if (A.get(i) < 0) {
                lastNegativeIndex = i;
                ArrayList<Integer> tempArr = new ArrayList<Integer>();
                for (int k = i-1; k >= 0; k--) {
                    if(A.get(k) >= 0) {
                        tempArr.add(A.get(k));
                    } else {
                        break;
                    }
                }
                if (arrList.size() > 0) {
                    if (tempArr.size() > arraySize) {
                        arrList.clear();
                        arraySize = tempArr.size();
                        arrList = tempArr;
                    }
                } else {
                    arraySize = tempArr.size();
                    arrList = tempArr;
                }
            }
        }
        // System.out.println(arrList);

        // reversing the arr since it will be in the reverse order when we append.
        int f = 0;
        int e = arrList.size() - 1;
        int temp;
        while (f < e) {
            temp = arrList.get(f);
            arrList.set(f, arrList.get(e));
            arrList.set(e, temp);
            f++;
            e--;
        }

        // this is for the values which is after the negative value
        ArrayList<Integer> tempNewArr = new ArrayList<Integer>();
        for (int p = lastNegativeIndex + 1; p < N; p++) {
            tempNewArr.add(A.get(p));
        }

        if(arraySize < tempNewArr.size()) {
            arrList.clear();
            arraySize = tempNewArr.size();
            arrList = tempNewArr;
        }
        return arrList;
    }
    
    public static void main(String[] args) {

        maximumPositivity maxiPos = new maximumPositivity();

        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5,6,-1,7,8,4,3,1,-3,6,4,4,8,73));

        // ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5));
        ArrayList<Integer> maxArr = maxiPos.solve(A);
        System.out.println(maxArr);
        
    }
}
