import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class crossWall {
    public int solve(int A, int B, ArrayList<Integer> C) {
        int N = C.size();

        HashMap<Integer, Integer> wall = new HashMap<>();
        wall.put(C.get(0), 1);
        
        ArrayList<Integer> rowsProfix = new ArrayList<>();
        rowsProfix.add(C.get(0));

        int sum = C.get(0);
        System.out.println(sum);
        

        for (int i = 1; i < N; i++) {
            int value = C.get(i);
            if (sum < B) {
                value += rowsProfix.get(i - 1);
            } else if (sum == B) {
                System.out.println("zero => " + i);
                sum = 0;
            }

            // System.out.println(sum);
            if (wall.containsKey(value)) {
                int val = wall.get(value) + 1;
                wall.put(value, val);
            } else {
                wall.put(value, 1);
            }
            rowsProfix.add(value);
            sum += C.get(i);
        }
        System.out.println(rowsProfix);
        System.out.println(wall);

        int maxVal = Integer.MIN_VALUE;
        int rows = 0;
        boolean hasOther = false;
        for (HashMap.Entry<Integer, Integer> m : wall.entrySet()) {
            if (m.getKey() != B) {
                if (maxVal < m.getValue()) {
                    maxVal = m.getValue();
                    hasOther = true;
                }
            } else {
                rows = m.getValue();
            }
        }

        System.out.println(rows + " " + maxVal + " " + (rows - maxVal));
        int bricksCrossing = hasOther ? rows - maxVal : A;
        System.out.println(bricksCrossing);

        return bricksCrossing;
    }

    public static void main(String[] args) {
        crossWall cw = new crossWall();
        // int A = 3;
        // int B = 5;
        // ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(1,2,2,5,3,2));
        // ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(1, 1, 2, 1, 5, 3,
        // 2));

        int A = 3;
        int B = 8;        
        ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(1, 5, 2, 2, 2, 2, 2, 3, 2, 3));

        cw.solve(A, B, C);
    }
}
