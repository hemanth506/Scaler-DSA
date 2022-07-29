import java.util.Arrays;

public class concatenateThreeNum {
    public int solve(int A, int B, int C) {

        int[] arr = {A,B,C};
        System.out.println(Arrays.toString(arr));
        for (int i = 0;i < 3; i++) {
            int currentIndx = i;
            for (int j = i + 1; j < 3; j++) {
                if(arr[currentIndx] > arr[j]) {
                    System.out.println(j);
                    currentIndx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[currentIndx];
            arr[currentIndx] = temp;
        }
        System.out.println(Arrays.toString(arr));

        String result = "";
        for(int k = 0; k < 3; k++) {
            result += ""+arr[k];
        }
        System.out.println(result);
        return Integer.parseInt(result);
    }

    public int solveIfClause(int A, int B, int C) {
        int S = 0;
        if ((A <= B) && (A <= C)) {
            S = A * 10000;
            S += (B < C) ? (B*100 + C) : (C*100 + B);
            System.out.println(S);
        }
        else if ((B <= C) && (B <= A)) {
            S = B;
            S += (C < A) ? (C*100 + A) : (A*100 + C);
            System.out.println(S);
        } 
        else if ((C <= A) && (C <= B)) {
            S = C;
            S += (A < B) ? (A*100 + B) : (B*100 + A);
            System.out.println(S);
        }
        return S;
    }

    public int solveSolution(int A, int B, int C) {
        int[] a = {A,B,C};
        Arrays.sort(a);
        int result = 10000*a[0] + 100 *a[1] + a[2];
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        concatenateThreeNum ct = new concatenateThreeNum();
        int A = 20;
        int B = 33;
        int C = 20; 
        
        // ct.solve(A, B, C);
        ct.solveIfClause(A, B, C);
        ct.solveSolution(A,B,C);

    }
}
